package com.forkexec.pts.ws.it;

import com.forkexec.pts.ws.BadInitFault_Exception;
import com.forkexec.pts.ws.cli.exception.EmailAlreadyExistsFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidEmailFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidPointsFaultException;
import com.forkexec.pts.ws.cli.exception.NotEnoughBalanceFaultException;
import org.junit.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class DemoF2 extends BaseIT {

    public String email1 = "demo.user1@sd.com";
    public String email2 = "demo.user2@sd.com";
    public String email3 = "demo.user3@sd.com";

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
    public void success() throws InvalidEmailFaultException, EmailAlreadyExistsFaultException, InvalidPointsFaultException,
            NotEnoughBalanceFaultException, IOException, InterruptedException {
        System.out.println("\nDe momento existem as seguintes réplicas ativas: \n");
        System.out.println(client.ctrlPing("ok"));
        System.out.println("\nA criar o utilizador 1: " + email1 + '\n');
        client.activateUser(email1);
        System.out.println("Número de pontos do utilizador (esperado = 100) : " + client.pointsBalance(email1) + '\n');

        System.out.println("A criar o utilizador 2: " + email2 + '\n');
        client.activateUser(email2);
        System.out.println("Conta do utilizador 1 criada\n");

        // Falha num servidor
        System.out.println("-> Tem 15 segundos para simular uma falha num dos servidores de pontos\n");
        Thread.sleep(2000);
        for (int i = 15; i > 0; i--) {
            Thread.sleep(1000);
            System.out.println(i);
        }
        System.out.println('\n');

        System.out.println("Verificando novamente que réplicas estão ativas:\n");
        System.out.println(client.ctrlPing("ok") + "\n");

        System.out.println("\nNúmero de pontos do utilizador 1 (esperado = 100) : " + client.pointsBalance(email2) + '\n');

        System.out.println("Devolvendo novamente o valor de pontos do utilizador 1:");
        System.out.println("Valor (esperado = 100): " + client.pointsBalance(email1) + '\n');

        System.out.println("Adicionando 50 pontos ao utilizador 2");
        System.out.println("Valor da conta com após adicionar 50 pontos (esperado = 150): " + client.addPoints(email2, 50) + '\n');

        System.out.println("A criar o utilizador 3: " + email3 + '\n');
        client.activateUser(email3);
        System.out.println("Conta do utilizador 3 criada\n");

        // Voltar a ligar servidor e matar outro
        System.out.println("-> Tem 30 segundos para voltar a ligar o servidor e simular uma falha num outro\n");
        Thread.sleep(2000);
        for (int i = 30; i > 0; i--) {
            Thread.sleep(1000);
            System.out.println(i);
        }
        System.out.println('\n');

        System.out.println("Verificando novamente que réplicas estão ativas:\n");
        System.out.println(client.ctrlPing("ok") + "\n");

        System.out.println("Verificando o número de pontos do utilizador 3, apenas registado numa das réplicas ativas de momento");
        System.out.println("\nNúmero de pontos do utilizador 3 (esperado = 100) : " + client.pointsBalance(email3) + '\n');

        System.out.println("Removendo 100 pontos ao utilizador 2\n");
        System.out.println("Valor da conta após remover 100 pontos (esperado = 50): " + client.spendPoints(email2,100) + '\n');

        Assert.assertEquals(100, client.pointsBalance(email1));
        Assert.assertEquals(50, client.pointsBalance(email2));
        Assert.assertEquals(100, client.pointsBalance(email3));

        System.out.println("Foi possivel verificar o saldo, adicionar pontos e remover pontos mesmo existindo falhas\n");
    }

}
