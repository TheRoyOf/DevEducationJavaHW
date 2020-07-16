package com;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();

        new Cashier(bank).start();

        Thread newClients = new Thread(() -> {
            while (true) {
                new Client(bank).start();
                try {
                    Thread.sleep(100); // еееее!!!!! магия!!!!!
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        newClients.start();





    }
}
