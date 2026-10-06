package com.banking.service;

import com.banking.exception.InsufficientBalanceException;
import com.banking.model.BankAccount;
import com.banking.model.SavingsAccount;

import java.util.HashMap;
import java.util.Map;

public class BankManager {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void createSavingsAccount(String accNo, String holder, double initialBalance) {
        if (accounts.containsKey(accNo)) {
            System.out.println("Account number already exists!");
            return;
        }

        SavingsAccount account = new SavingsAccount(accNo, holder, initialBalance);
        accounts.put(accNo, account);
        System.out.println("Savings Account created successfully for " + holder);
    }

    public BankAccount getAccount(String accNo) {
        return accounts.get(accNo);
    }

    public void transfer(String fromAcc, String toAcc, double amount)
            throws InsufficientBalanceException {

        BankAccount source = accounts.get(fromAcc);
        BankAccount target = accounts.get(toAcc);

        if (source == null || target == null) {
            System.out.println("Transfer failed! One or both account numbers are invalid.");
            return;
        }

        if (source == target) {
            System.out.println("Transfer failed! Source and target accounts must be different.");
            return;
        }

        source.withdraw(amount);
        try {
            target.deposit(amount);
        } catch (RuntimeException e) {
            // Rollback source withdrawal if target deposit unexpectedly fails.
            source.deposit(amount);
            throw e;
        }

        System.out.println("Transfer successful! $" + amount +
                " transferred from " + fromAcc + " to " + toAcc);
    }
}
