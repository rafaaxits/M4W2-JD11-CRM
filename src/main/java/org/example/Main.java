package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente clienteM = new Cliente("000.111.222-33", "João Batista", 27,
                "Rua teste git", 'M');
        System.out.printf(clienteM.toString());

        Cliente clienteF = new Cliente("444.555.666-77", "Maria Batista", 25,
                "Rua teste git", 'F');
        System.out.printf(clienteF.toString()+"\n");

        ClientBuilder clienteTest = new ClientBuilder().comIdentificacao("Rafael", "Camara", "Figueredo",
                "000.111.222-33", "18/04/1997", 'M').comContatos("rafaelcamara.f@gmail.com",
                "Rua teste", "(81) 9.99745-7742");

        System.out.printf(clienteTest.toString());
    }
}