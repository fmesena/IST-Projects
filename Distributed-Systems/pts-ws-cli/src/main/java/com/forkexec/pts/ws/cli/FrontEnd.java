package com.forkexec.pts.ws.cli;

import com.forkexec.pts.ws.*;
import com.forkexec.pts.ws.cli.exception.EmailAlreadyExistsFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidEmailFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidPointsFaultException;
import com.forkexec.pts.ws.cli.exception.NotEnoughBalanceFaultException;
import com.sun.xml.ws.client.ClientTransportException;
import pt.ulisboa.tecnico.sdis.ws.uddi.UDDINaming;
import pt.ulisboa.tecnico.sdis.ws.uddi.UDDINamingException;
import pt.ulisboa.tecnico.sdis.ws.uddi.UDDIRecord;

import java.net.ConnectException;
import java.util.*;

import javax.xml.ws.Response;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;


public class FrontEnd {

    private static FrontEnd single_instance = null;

    private String uddi;
    private int copies;

    private List<Response<ReadResponse>> readResponses;
    private List<Response<WriteResponse>> writeResponses;

    // Maps user emails to corresponding points balance and tag
    Map<String, PointsData> cache = new ConcurrentHashMap<>();

    private FrontEnd() {
    }

    public static FrontEnd getInstance() {
        if (single_instance == null) {
            single_instance = new FrontEnd();
        }
        return single_instance;
    }

    public void init(String uddi, int num_servers) {
        this.uddi = uddi;
        this.copies  = num_servers;
    }

    private ArrayList<PointsClient> uddiLookup() {
        try {
            List<PointsClient> clients = new ArrayList<>();

            UDDINaming uddiNaming = new UDDINaming(uddi);

            Collection<UDDIRecord> serverRecords = uddiNaming.listRecords("A51_Points%");

            for (UDDIRecord serverRecord : serverRecords)
                clients.add(new PointsClient(serverRecord.getUrl()));

            return (ArrayList<PointsClient>) clients;

            } catch (PointsClientException e) {
                throw new RuntimeException(e);
            } catch (UDDINamingException e) {
                throw new RuntimeException(e);
            }
    }

    /** output option **/
    private boolean verbose = false;

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    private synchronized boolean hasQuorum(int replies) {
        return replies >= this.copies / 2 + 1;
    }


    // remote invocation methods ----------------------------------------------
    public synchronized void activateUser(String userEmail) throws EmailAlreadyExistsFaultException, InvalidEmailFaultException {
        checkValidEmail(userEmail);

        List<PointsClient> clients = this.uddiLookup();

        for (PointsClient client : clients)
            try {
                client.readAsync(userEmail);
            } catch (ClientTransportException e) {}
    }

    public synchronized int pointsBalance(String userEmail) throws InvalidEmailFaultException {
        checkValidEmail(userEmail);

        if (cache.containsKey(userEmail)) {
            System.out.println("-> pointsBalance: Valor lido a partir da cache.\n");
            return cache.get(userEmail).getValue();
        }
        else {
            int maxTagIndex = readQuorum(userEmail);

            try {
                System.out.println("-> pointsBalance: Valor lido de um quorum de réplicas.\n");

                // Update local cache
                int newBalance = readResponses.get(maxTagIndex).get().getReturn().getValue();
                int tag = readResponses.get(maxTagIndex).get().getReturn().getTag();
                PointsData view = new PointsData(newBalance,tag);
                cache.put(userEmail, view);

                return newBalance;
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception occurred.");
                //throw new RuntimeException(e);
            } catch (ExecutionException e) {
                System.out.println("Execution exception occurred.");
                //throw new RuntimeException(e);
            }
        }
        return -1;
    }



    public synchronized int addPoints(String userEmail, int pointsToAdd)
            throws InvalidEmailFaultException, InvalidPointsFaultException {
        int currentBalance = 0;
        int maxTag = 0;

        checkValidEmail(userEmail);

        if(pointsToAdd <= 0) {
            throw new InvalidPointsFaultException("Invalid points amount.");
        }

        // If requested value and tag are found on cache
        if (cache.containsKey((userEmail))) {
            System.out.println("-> addPoints: Valor lido a partir da cache.\n");
            currentBalance = cache.get(userEmail).getValue();
            maxTag = cache.get(userEmail).getTag();
        }
        // If not, read from servers
        else {
            int maxTagIndex = readQuorum(userEmail);

            try {
                System.out.println("-> addPoints: Valor lido a partir de um quorum de réplicas.\n");
                currentBalance = readResponses.get(maxTagIndex).get().getReturn().getValue();
                maxTag = readResponses.get(maxTagIndex).get().getReturn().getTag();
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception occurred.");
                //throw new RuntimeException(e);
            } catch (ExecutionException e) {
                System.out.println("Execution exception occurred.");
                //throw new RuntimeException(e);

            }
        }

        int newBalance = currentBalance + pointsToAdd;

        writeQuorum(userEmail, newBalance, maxTag + 1);

        return newBalance;
    }

    public synchronized int spendPoints(String userEmail, int pointsToSpend)
            throws InvalidEmailFaultException, InvalidPointsFaultException, NotEnoughBalanceFaultException {
        int currentBalance = 0;
        int maxTag = 0;

        checkValidEmail(userEmail);

        if(pointsToSpend <= 0) {
            throw new InvalidPointsFaultException("Invalid points amount.");
        }

        // If requested value and tag are found on cache
        if (cache.containsKey((userEmail))) {
            System.out.println("-> spendPoints: Valor lido a partir da cache.\n");
            currentBalance = cache.get(userEmail).getValue();
            maxTag = cache.get(userEmail).getTag();
        }
        // If not, read from servers
        else {
            int maxTagIndex = readQuorum(userEmail);

            try {
                System.out.println("-> spendPoints: Valor lido a partir de um quorum de réplicas.\n");
                currentBalance = readResponses.get(maxTagIndex).get().getReturn().getValue();
                maxTag = readResponses.get(maxTagIndex).get().getReturn().getTag();
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception occurred.");
                //throw new RuntimeException(e);
            } catch (ExecutionException e) {
                System.out.println("Execution exception occurred.");
                //throw new RuntimeException(e);
            } catch (ClientTransportException e) {
            }
        }

        int newBalance = currentBalance - pointsToSpend;
        if(newBalance < 0)
            throw new NotEnoughBalanceFaultException();

        writeQuorum(userEmail, newBalance, maxTag + 1);

        return newBalance;
    }

    // control operations -----------------------------------------------------

    public String ctrlPing(String inputMessage) {
        List<PointsClient> clients = this.uddiLookup();
        String response = "";
        int i = 1;

        for (PointsClient client : clients)
            try {
                response += "Servidor " + i++ + " respondeu com: " + client.ctrlPing("ping");
                response += "\n";
            } catch (ClientTransportException e) {}


        return response;
    }

    public void ctrlClear() {
        cache = new ConcurrentHashMap<>();

        List<PointsClient> clients = this.uddiLookup();

        for (PointsClient client : clients)
            try {
                client.ctrlClear();
            } catch (Exception e) {}
    }

    public void ctrlInit(int startPoints) throws BadInitFault_Exception {
        List<PointsClient> clients = this.uddiLookup();

        for (PointsClient client : clients)
            try {
                client.ctrlInit(startPoints);
            } catch (Exception e) {

            }
    }



    /** Email address validation. */
    private void checkValidEmail(final String emailAddress) throws InvalidEmailFaultException {
        final String message;
        if (emailAddress == null) {
            message = "Null email is not valid";
        } else if (!Pattern.matches("(\\w\\.?)*\\w+@\\w+(\\.?\\w)*", emailAddress)) {
            message = String.format("Email: %s is not valid", emailAddress);
        } else {
            return;
        }
        throw new InvalidEmailFaultException(message);
    }


    /** Read from a Quorum */
    public synchronized int readQuorum(String userEmail) {
        int replies = 0;
        int maxTag = -1;
        int index = -1;
        List<Integer> finished = new ArrayList<>();
        readResponses = new ArrayList<>();
        List<PointsClient> clients = this.uddiLookup();

        try {
            for (PointsClient client : clients)
                try {
                    readResponses.add(client.readAsync(userEmail));
                } catch(ClientTransportException e) {

                }

            while (!hasQuorum(replies)) {
                Thread.sleep(10);
                for (int j = 0; j < readResponses.size(); j++)
                    try {
                        if (readResponses.get(j).isDone() & !finished.contains(j)) {
                            replies++;
                            finished.add(j);
                            if (readResponses.get(j).get().getReturn().getTag() > maxTag)
                                index = j;
                        }
                    } catch (ExecutionException e) {}
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception occurred.");
        }

        return index;
    }


    /** Write to a Quorum */
    public synchronized void writeQuorum(String userEmail, int newBalance, int tag) {
        int replies = 0;
        List<Integer> finished = new ArrayList<>();
        writeResponses = new ArrayList<>();
        List<PointsClient> clients = this.uddiLookup();

        // Update local cache
        PointsData view = new PointsData(newBalance,tag);
        cache.put(userEmail, view);

        try {
            for (PointsClient client : clients)
                writeResponses.add(client.writeAsync(userEmail, newBalance, tag));

            while (!hasQuorum(replies)) {
                Thread.sleep(10);
                for (int j = 0; j < writeResponses.size(); j++)
                    if (writeResponses.get(j).isDone() & !finished.contains(j)) {
                        replies++;
                        finished.add(j);
                    }
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupt exception occured in function \'writeQuorum\'");
            //throw new RuntimeException(e);
        } catch(ClientTransportException e) {

        }
    }

}
