package com.banking.model;

import com.banking.exception.InsufficientBalanceException;

public class SavingsAccount extends BankAccount {
    private static final double MINIMUM_BALANCE = 500.00;

    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance) {
        super(accountNumber, accountHolder, initialBalance);
        if (initialBalance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Initial balance must be at least $" + MINIMUM_BALANCE);
        }
    }

    @Override
    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (balance - amount < MINIMUM_BALANCE) {
            throw new InsufficientBalanceException(
                "Withdrawal failed! Minimum balance of $" + MINIMUM_BALANCE + " must be maintained."
            );
        }
        balance -= amount;
        addTransaction("Withdrew: $" + amount + " | New Balance: $" + balance);
    }
}
