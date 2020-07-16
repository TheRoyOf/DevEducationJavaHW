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
    }

    public Bank(int cycleCount) {
        this.cycleCount = cycleCount;
        this.balance = new AtomicInteger(startCapital);
        this.isBeingChecked = new AtomicBoolean(false);
        this.clientQueue = new ConcurrentLinkedQueue<>();
        this.clientsWithDeposits = new CopyOnWriteArrayList<>();
        this.clientsWithLoans = new CopyOnWriteArrayList<>();

    }

    public synchronized void giveLoan(Client client) {

        if (!isBeingChecked.get()){
        int sum = client.getIntent().getSum().get();
        client.getMoney().getAndAdd(sum);
        balance.set((balance.get() - sum));
        this.clientsWithLoans.add(client); // переделать
        this.clientQueue.add(client);

        }
    }

    public synchronized void acceptDeposit(Client client) {

        if (!isBeingChecked.get()){
        int sum = client.getIntent().getSum().get();
        client.getMoney().set(client.getMoney().get() - sum);
        balance.set((balance.get() + sum));
        this.clientsWithDeposits.add(client); // ))
        this.clientQueue.add(client);
        }
    }

    public synchronized boolean isLoanAvailable() {

        if (clientsWithDeposits.isEmpty() && balance.get() >= 58_000 && isLoanAvailable.get()) { // magic!!!!
            return true;
        } else if (!clientsWithDeposits.isEmpty() && isLoanAvailable.get()) {
            return true;
        }
        return false;
    }

    public synchronized boolean isDepositAvailable() {
        return isDepositAvailable.get() && balance.get() < MAX_BALANCE;
    }

    private int getDepositSum() {
        return clientsWithDeposits.stream()
                .map(Client::getIntent)
                .map(Intention::getSum)
                .mapToInt(AtomicInteger::get)
                .sum();
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
