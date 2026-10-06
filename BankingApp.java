package com.banking;

import com.banking.exception.InsufficientBalanceException;
import com.banking.model.BankAccount;
import com.banking.service.BankManager;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        BankManager manager = new BankManager();
        Scanner scanner = new Scanner(System.in);
        boolean active = true;

        System.out.println("=========================================");
        System.out.println("   ENTERPRISE BANKING CONSOLE SYSTEM");
        System.out.println("=========================================");

        while (active) {
            System.out.println("\n1. Create Savings Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Print Mini Statement");
            System.out.println("6. Exit");
            System.out.print("Choose action: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (option) {
                    case 1:
                        System.out.print("Account Number: ");
                        String accNo = scanner.nextLine();
                        System.out.print("Account Holder Name: ");
                        String holder = scanner.nextLine();
                        System.out.print("Initial Deposit (Min $500): ");
                        double balance = scanner.nextDouble();
                        manager.createSavingsAccount(accNo, holder, balance);
                        break;

                    case 2:
                        System.out.print("Enter Account Number: ");
                        String depAcc = scanner.nextLine();
                        System.out.print("Enter Deposit Amount: ");
                        double depAmt = scanner.nextDouble();
                        BankAccount accountToDeposit = manager.getAccount(depAcc);
                        if (accountToDeposit != null) {
                            accountToDeposit.deposit(depAmt);
                            System.out.println("Deposit completed!");
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account Number: ");
                        String wAcc = scanner.nextLine();
                        System.out.print("Enter Withdrawal Amount: ");
                        double wAmt = scanner.nextDouble();
                        BankAccount accountToWithdraw = manager.getAccount(wAcc);
                        if (accountToWithdraw != null) {
                            accountToWithdraw.withdraw(wAmt);
                            System.out.println("Withdrawal completed!");
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;

                    case 4:
                        System.out.print("From Account Number: ");
                        String from = scanner.nextLine();
                        System.out.print("To Account Number: ");
                        String to = scanner.nextLine();
                        System.out.print("Transfer Amount: ");
                        double tAmt = scanner.nextDouble();
                        manager.transfer(from, to, tAmt);
                        break;

                    case 5:
                        System.out.print("Enter Account Number: ");
                        String stmtAcc = scanner.nextLine();
                        BankAccount stmtAccount = manager.getAccount(stmtAcc);
                        if (stmtAccount != null) {
                            System.out.println("\n--- Mini Statement for " +
                                    stmtAccount.getAccountHolder() + " ---");
                            stmtAccount.getTransactionHistory().forEach(System.out::println);
                            System.out.println("Current Balance: $" + stmtAccount.getBalance());
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;

                    case 6:
                        active = false;
                        System.out.println("Thank you for using Enterprise Banking System.");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (InsufficientBalanceException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
