package com;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Inspector extends Thread {
    private Bank bank;


    public Inspector(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.getIsBeingChecked().set(true);
        System.out.println("Inspector is checking the bank");
        checkStatus();
        bank.getIsBeingChecked().set(false);
    }


    private long calculateDepositSum(Bank bank) {
        return bank.getClientsWithDeposits()
                .stream()
                .map(Client::getIntent)
                .map(Intention::getSum)
                .mapToInt(AtomicInteger::get)
                .sum();
    }

    private long calculateCreditSum(Bank bank) {
        return bank.getClientsWithLoans()
                .stream()
                .map(Client::getIntent)
                .map(Intention::getSum)
                .mapToInt(AtomicInteger::get)
                .sum();
    }

    private void checkStatus() {

        if ((1 - (calculateCreditSum(bank) / calculateDepositSum(bank))) * 100 >= 20) {  //заменить
            bank.setIsDepositAvailable(new AtomicBoolean(false));
            bank.setIsLoanAvailable(new AtomicBoolean(true)); //заменить на значения под испектрора
            System.out.println("Deposits are temporarily blocked");

        } else if ((1 - (calculateDepositSum(bank) / calculateCreditSum(bank))) * 100 >= 20){  //заменить
            bank.setIsLoanAvailable(new AtomicBoolean(false));
            bank.setIsDepositAvailable(new AtomicBoolean(true));  //заменить на значения под испектрора
            System.out.println("Loans are temporarily blocked");
        }
    }
}
