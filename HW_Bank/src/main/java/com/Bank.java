package com;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    private int cycleCount;
    private final int MAX_BALANCE = 1_000_000;
    private final int startCapital = 50_000;
    private AtomicInteger balance;
    private Queue<Client> clientQueue;
    private List<Client> clientsWithDeposits;
    private List<Client> clientsWithLoans;
    private AtomicBoolean isBeingChecked;
    private AtomicBoolean isDepositAvailable;
    private AtomicBoolean isLoanAvailable;
    private final float DEPOSIT_INTEREST = 0.03f;
    private final float LOAN_INTEREST = 0.15f;

    private boolean inspectorLoanRule = true;
    private boolean inspectorLDepositRule = true;

    private FileLogger fileLogger;
    private String logFile;
    private String destination = "";

    public float getDEPOSIT_INTEREST() {
        return DEPOSIT_INTEREST;
    }

    public float getLOAN_INTEREST() {
        return LOAN_INTEREST;
    }

    public Bank() {
        this.cycleCount = 10_000;
        this.balance = new AtomicInteger(startCapital);
        this.isBeingChecked = new AtomicBoolean(false);
        this.clientQueue = new ConcurrentLinkedQueue<>();
        this.clientsWithDeposits = new CopyOnWriteArrayList<>();
        this.clientsWithLoans = new CopyOnWriteArrayList<>();
        this.isLoanAvailable = new AtomicBoolean(true);
        this.isDepositAvailable = new AtomicBoolean(true);
        this.fileLogger = new FileLogger(this);
        //this.logFile = this.fileLogger.createLog(destination);
    }

    public Bank(int cycleCount) {
        this.cycleCount = cycleCount;
        this.balance = new AtomicInteger(startCapital);
        this.isBeingChecked = new AtomicBoolean(false);
        this.clientQueue = new ConcurrentLinkedQueue<>();
        this.clientsWithDeposits = new CopyOnWriteArrayList<>();
        this.clientsWithLoans = new CopyOnWriteArrayList<>();
        //this.fileLogger = new FileLogger(this);
    }

    public synchronized void giveLoan(Client client) {

        if (!isBeingChecked.get())
        {
        int sum = client.getIntent().getSum().get();
        client.getMoney().getAndAdd(sum);
        balance.set((balance.get() - sum));
        this.clientsWithLoans.add(client);
        this.clientQueue.add(client);
        //fileLogger.logUpdate(logFile, destination, client.getIntentionSelector(),client.getIntent().getSum().get());
        }
    }

    public synchronized void acceptDeposit(Client client) {

        if (!isBeingChecked.get()){
        int sum = client.getIntent().getSum().get();
        client.getMoney().set(client.getMoney().get() - sum);
        balance.set((balance.get() + sum));
        this.clientsWithDeposits.add(client);
        this.clientQueue.add(client);
        //fileLogger.logUpdate(logFile, destination, client.getIntentionSelector(),client.getIntent().getSum().get());
        }
    }

    public synchronized boolean isLoanAvailable(int sum) {

        if (clientsWithDeposits.isEmpty() && balance.get()-sum >= 58_000 && isLoanAvailable.get()) {
            return true;
        } else if (!clientsWithDeposits.isEmpty() && isLoanAvailable.get()) {
            return true;
        }
        return false;
    }

    public synchronized boolean isDepositAvailable() {
        return isDepositAvailable.get() && balance.get() < MAX_BALANCE;
    }

    public synchronized boolean isDepositAvailable(int sum) {
        return isDepositAvailable.get() && balance.get() + sum < MAX_BALANCE;
    }


    public int addMoney(float money)
    {
        return balance.addAndGet((int) money);
    }

    public void takeMoney(float money)
    {
        balance.set(balance.get() - (int) money);
    }

    public AtomicBoolean getIsBeingChecked() {
        return isBeingChecked;
    }

    public List<Client> getClientsWithDeposits() {
        return clientsWithDeposits;
    }

    public List<Client> getClientsWithLoans() {
        return clientsWithLoans;
    }

    public boolean removeClientFromLoanList(Client client)
    {
        return clientsWithLoans.remove(client);
    }

    public boolean removeClientFromDepositList(Client client)
    {
        return clientsWithDeposits.remove(client);
    }

    public AtomicInteger getBalance() {
        return balance;
    }

    public void setIsDepositAvailable(AtomicBoolean isDepositAvailable) {
        this.isDepositAvailable = isDepositAvailable;
    }

    public void setIsLoanAvailable(AtomicBoolean isLoanAvailable) {
        this.isLoanAvailable = isLoanAvailable;
    }

}
