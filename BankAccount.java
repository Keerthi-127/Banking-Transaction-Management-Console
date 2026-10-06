package com.banking.model;

import com.banking.exception.InsufficientBalanceException;
import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private String accountNumber;
    private String accountHolder;
    protected double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account opened with initial balance: $" + initialBalance);
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        addTransaction("Deposited: $" + amount + " | New Balance: $" + balance);
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    protected synchronized void addTransaction(String record) {
        transactionHistory.add(record);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public synchronized double getBalance() { return balance; }
    public synchronized List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
}
