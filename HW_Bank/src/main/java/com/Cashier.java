package com;

import java.util.concurrent.atomic.AtomicBoolean;

public class Cashier extends Thread {
    private Bank bank;

    public Cashier(Bank bank) {
        this.bank = bank;
    }

    public void run() {

        while (true) {
            try
            {
                sleep(3_000); // еееее!!!!! магия!!!!!
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            bank.setIsLoanAvailable(new AtomicBoolean(false));

            for (Client client : bank.getClientsWithLoans())
            {
                bank.addMoney (client.getIntent().getSum().get()*(1+bank.getLOAN_INTEREST()));

                bank.removeClientFromLoanList(client);
            }
            bank.setIsDepositAvailable(new AtomicBoolean(false));

            for (Client client : bank.getClientsWithDeposits())
            {
                bank.takeMoney (client.getIntent().getSum().get()*(1+bank.getDEPOSIT_INTEREST()));

                bank.removeClientFromDepositList(client);
            }

            System.out.println("________________________________________________");
            System.out.println("Cashier end work");
            System.out.println("Bank balance: " + bank.getBalance());
            System.out.println("________________________________________________");

            bank.setIsLoanAvailable(new AtomicBoolean(true));
            bank.setIsDepositAvailable(new AtomicBoolean(true));

        }
    }
}
