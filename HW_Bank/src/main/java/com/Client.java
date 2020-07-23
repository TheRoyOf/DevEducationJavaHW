package com;


import com.enums.EIntention;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Client extends Thread implements Serializable {
    private static AtomicInteger staticId = new AtomicInteger(0);
    private AtomicInteger money;
    private EIntention intentionSelector;
    private Intention intention;
    private Bank bank;

    public EIntention getIntentionSelector() {
        return intentionSelector;
    }

    public Client(Bank bank) {
        staticId.incrementAndGet();
        this.bank = bank;
        this.money = new AtomicInteger(ThreadLocalRandom.current().nextInt(20_000, 40_000 + 1));
        this.intentionSelector = ThreadLocalRandom.current().nextBoolean() ? EIntention.DEPOSIT : EIntention.LOAN;
        this.intention = intentionSelector.equals(EIntention.DEPOSIT) ?
                new Intention(1000, 20_000 + 1) : new Intention(500, 20_000 + 1);
    }

    public void run() {
        switch (intentionSelector) {

            case LOAN:
                boolean loanCheckActive = true;
                while (loanCheckActive)
                {
                    if (this.bank.isLoanAvailable()) {
                        bank.giveLoan(this);
                        System.out.println("Client " + getStaticId() + " took a loan of " + this.getIntent().getSum().get() +
                                " Bank balance: " + this.bank.getBalance().get());
                        loanCheckActive = false;
                    } else {
                        Thread.yield();
                    }
                }
                break;
            case DEPOSIT:
                boolean depositCheckActive = true;
                while (depositCheckActive)
                {
                    if (this.bank.isDepositAvailable()) {
                        bank.acceptDeposit(this);
                        System.out.println("Client " + getStaticId() + " had put a deposit of " + this.getIntent().getSum().get()
                                + " Bank balance: " + this.bank.getBalance().get());
                        depositCheckActive = false;
                    } else {
                        Thread.yield();
                    }
                }
                break;
        }
    }

    public static AtomicInteger getStaticId() {
        return staticId;
    }

    public AtomicInteger getMoney() {
        return money;
    }

    public Intention getIntent() {
        return intention;
    }
}