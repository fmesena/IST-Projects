package com.forkexec.pts.ws.it;

import com.forkexec.pts.ws.BadInitFault_Exception;
import com.forkexec.pts.ws.cli.exception.EmailAlreadyExistsFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidEmailFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidPointsFaultException;
import com.forkexec.pts.ws.cli.exception.NotEnoughBalanceFaultException;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class DemoF1 extends BaseIT{

    public String email = "demonstracao@points.com";
    public String email1 = "test@points.com";
    // initialization and clean-up for each test
    @Before
    public void setUp() throws BadInitFault_Exception {
        //client.ctrlInit(USER_POINTS);
    }

    @After
    public void tearDown() {
        pointsTestClear();
    }

    @Test
    public void success() throws InvalidEmailFaultException, EmailAlreadyExistsFaultException, InvalidPointsFaultException, NotEnoughBalanceFaultException {
        System.out.println("De momento existem as seguintes réplicas ativas: ");
        System.out.println(client.ctrlPing("ok"));
        System.out.println("A criar o utilizador: " + email);
        client.activateUser(email);
        System.out.println("Valor: " + client.pointsBalance(email));
        System.out.println("Devolvendo novamente o valor de pontos do utilizador " + email);
        System.out.println("Valor: " + client.pointsBalance(email));
        System.out.println("Adicionando 50 pontos ao utilizador: " + email1);
        System.out.println("Valor da conta com após adicionar 50 pontos: " + client.addPoints(email1, 50));
        System.out.println("Removendo 100 pontos ao utilizador");
        System.out.println("Valor da conta após remover 100 pontos: " + client.spendPoints(email1,100));
        Assert.assertEquals(100,client.pointsBalance(email));
        Assert.assertEquals(50, client.pointsBalance(email1));
        System.out.println("Foi possivel verificar o saldo, adicionar pontos e remover pontos mesmo existindo replicação\n");


    }

}
