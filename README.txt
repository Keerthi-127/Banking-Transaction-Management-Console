# Banking & Transaction Management Console

A console-based Java application that simulates basic banking operations such as account creation, deposits, withdrawals, fund transfers, and transaction history management.

The project demonstrates important **Core Java and Object-Oriented Programming concepts**, including abstract classes, inheritance, encapsulation, exception handling, collections, transaction logging, and basic concurrency using synchronized methods.

---

## 📌 Project Overview

The **Banking & Transaction Management Console** is designed to provide a simple banking environment through a command-line interface.

Users can create savings accounts and perform different banking operations.

### Main Features

* Create Savings Accounts
* Deposit Money
* Withdraw Money
* Transfer Funds between accounts
* Maintain transaction history
* View mini statements
* Validate transactions
* Handle insufficient balance using custom exceptions
* Maintain minimum savings account balance
* Use Java Collections to manage multiple accounts
* Use synchronized methods for basic concurrency protection

---

## 🛠️ Technologies Used

* **Java 24.0.1**
* Core Java
* Object-Oriented Programming
* Abstract Classes
* Inheritance
* Encapsulation
* Polymorphism
* Exception Handling
* Custom Exceptions
* Java Collections
* `HashMap`
* `ArrayList`
* Transaction Logging
* `synchronized` methods
* Console-based application

---

# 🧠 Java Concepts Demonstrated

## 1. Abstraction

`BankAccount` is an abstract class.

```java
public abstract class BankAccount
```

It defines common properties and operations for bank accounts while leaving the withdrawal implementation to subclasses.

The `withdraw()` method is declared abstract:

```java
public abstract void withdraw(double amount)
        throws InsufficientBalanceException;
```

---

## 2. Inheritance

`SavingsAccount` extends `BankAccount`.

```java
public class SavingsAccount extends BankAccount
```

This allows `SavingsAccount` to reuse the common functionality provided by `BankAccount`.

---

## 3. Polymorphism

A `SavingsAccount` object can be stored using a `BankAccount` reference.

```java
BankAccount account = new SavingsAccount(
        accNo,
        holder,
        initialBalance
);
```

The overridden `withdraw()` method of `SavingsAccount` is executed at runtime.

---

## 4. Encapsulation

Account information is protected using private fields.

For example:

```java
private String accountNumber;
private String accountHolder;
private List<String> transactionHistory;
```

Access is provided through getter methods.

```java
public String getAccountNumber()
public String getAccountHolder()
public double getBalance()
```

---

## 5. Java Collections

A `HashMap` is used to store bank accounts.

```java
private Map<String, BankAccount> accounts = new HashMap<>();
```

The account number acts as the unique key.

Transaction records are stored using:

```java
private List<String> transactionHistory;
```

---

## 6. Custom Exception Handling

The project defines a custom exception:

```text
InsufficientBalanceException
```

It is used when a withdrawal or transfer cannot be completed because the minimum balance requirement would be violated.

Example:

```java
throw new InsufficientBalanceException(
    "Withdrawal failed! Minimum balance must be maintained."
);
```

---

## 7. Concurrency / Mutex Basics

The project uses Java's `synchronized` keyword to protect balance-changing operations.

For example:

```java
public synchronized void deposit(double amount)
```

and:

```java
public synchronized void withdraw(double amount)
```

This provides basic protection when multiple threads attempt to modify an account balance.

---

# 💰 Savings Account Rules

The application uses a minimum balance requirement of:

```text
$500.00
```

### Initial Balance

A savings account must be opened with at least:

```text
$500
```

### Withdrawal

After a withdrawal, the account must still contain at least:

```text
$500
```

### Example

If the account balance is:

```text
$1000
```

The maximum withdrawal is:

```text
$500
```

After withdrawal:

```text
$1000 - $500 = $500
```

The transaction is allowed.

If the user attempts to withdraw:

```text
$600
```

the transaction is rejected because:

```text
$1000 - $600 = $400
```

which is below the required minimum balance.

---

# 📂 Project Structure

```text
BankingTransactionManagementConsole/
│
├── src/
│   └── com/
│       └── banking/
│           │
│           ├── BankingApp.java
│           │
│           ├── model/
│           │   ├── BankAccount.java
│           │   └── SavingsAccount.java
│           │
│           ├── exception/
│           │   └── InsufficientBalanceException.java
│           │
│           └── service/
│               └── BankManager.java
│
├── out/
│   └── Compiled .class files
│
└── README.md
```

---

# 📄 File Description

## `BankAccount.java`

Abstract base class containing common bank account properties and operations.

Responsibilities:

* Store account number
* Store account holder name
* Maintain balance
* Maintain transaction history
* Deposit money
* Provide account information

---

## `SavingsAccount.java`

Concrete implementation of a savings account.

Responsibilities:

* Implement withdrawal
* Enforce minimum balance
* Validate withdrawal amount
* Record withdrawal transactions

---

## `InsufficientBalanceException.java`

Custom checked exception used when a withdrawal cannot be completed due to insufficient available balance.

---

## `BankManager.java`

Service class responsible for managing bank accounts.

Responsibilities:

* Create accounts
* Find accounts
* Transfer funds
* Manage account collection

---

## `BankingApp.java`

Main application class.

Responsibilities:

* Display the menu
* Accept user input
* Call banking operations
* Handle exceptions
* Display results

---

# ⚙️ Requirements

Before running the application, make sure you have:

* Java JDK 8 or later
* VS Code
* Java Extension Pack for VS Code (recommended)

This project was developed/tested with:

```text
Java 24.0.1
```

Check your installed Java version:

```powershell
java -version
```

Check the Java compiler:

```powershell
javac -version
```

Expected output:

```text
java 24.0.1
javac 24.0.1
```

---

# ▶️ How to Run in VS Code

## Step 1 — Open the Project

Extract the project ZIP.

Open the following folder in VS Code:

```text
BankingTransactionManagementConsole
```

---

## Step 2 — Open the Terminal

In VS Code:

```text
Terminal → New Terminal
```

---

## Step 3 — Compile the Project

Run this command:

```powershell
javac -d out src/com/banking/model/BankAccount.java src/com/banking/model/SavingsAccount.java src/com/banking/exception/InsufficientBalanceException.java src/com/banking/service/BankManager.java src/com/banking/BankingApp.java
```

If there are no errors, the project has compiled successfully.

---

## Step 4 — Run the Application

Run:

```powershell
java -cp out com.banking.BankingApp
```

---

# 🖥️ Application Menu

When the program starts, it displays:

```text
=========================================
   ENTERPRISE BANKING CONSOLE SYSTEM
=========================================

1. Create Savings Account
2. Deposit Money
3. Withdraw Money
4. Transfer Funds
5. Print Mini Statement
6. Exit
Choose action:
```

---

# 🧪 Example Usage

## 1. Create Savings Account

Select:

```text
1
```

Enter:

```text
Account Number: A101
Account Holder Name: Anu
Initial Deposit: 1000
```

Output:

```text
Savings Account created successfully for Anu
```

---

## 2. Deposit Money

Select:

```text
2
```

Example:

```text
Enter Account Number: A101
Enter Deposit Amount: 500
```

Output:

```text
Deposit completed!
```

The new balance becomes:

```text
$1500
```

---

## 3. Withdraw Money

Select:

```text
3
```

Example:

```text
Enter Account Number: A101
Enter Withdrawal Amount: 300
```

Output:

```text
Withdrawal completed!
```

The balance becomes:

```text
$1200
```

---

## 4. Transfer Funds

First create two accounts.

Example:

```text
Account A101 → $1000
Account A102 → $1000
```

Select:

```text
4
```

Enter:

```text
From Account Number: A101
To Account Number: A102
Transfer Amount: 200
```

Output:

```text
Transfer successful! $200.0 transferred from A101 to A102
```

Balances become:

```text
A101 → $800
A102 → $1200
```

---

## 5. Print Mini Statement

Select:

```text
5
```

Enter:

```text
Enter Account Number: A101
```

Example output:

```text
--- Mini Statement for Anu ---

Account opened with initial balance: $1000.0
Deposited: $500.0 | New Balance: $1500.0
Withdrew: $300.0 | New Balance: $1200.0

Current Balance: $1200.0
```

---

# ⚠️ Exception Handling

The application handles invalid transactions.

## Invalid Deposit

If the user enters:

```text
-100
```

the application displays:

```text
Error: Deposit amount must be positive.
```

---

## Invalid Withdrawal

If the user enters:

```text
-200
```

the application displays:

```text
Error: Withdrawal amount must be greater than zero.
```

---

## Insufficient Balance

If a withdrawal would reduce the balance below `$500`:

```text
Error: Withdrawal failed! Minimum balance of $500.0 must be maintained.
```

---

## Invalid Account

If an account number does not exist:

```text
Account not found.
```

---

# 🔄 Transaction Flow

The general transaction flow is:

```text
User
  │
  ▼
BankingApp
  │
  ▼
BankManager
  │
  ├── Create Account
  │
  ├── Find Account
  │
  └── Transfer Funds
  │
  ▼
BankAccount
  │
  ├── Deposit
  │
  └── Withdraw
  │
  ▼
Transaction History
```

---

# 🏗️ Application Architecture

The project follows a simple layered architecture.

```text
┌─────────────────────────────┐
│       BankingApp.java       │
│     Console / User Input    │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│       BankManager.java      │
│      Business Operations    │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│       BankAccount.java      │
│       Abstract Model        │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│      SavingsAccount.java    │
│    Account Implementation   │
└─────────────────────────────┘
```

Exception handling is provided through:

```text
InsufficientBalanceException.java
```

---

# 🔐 Data Validation

The application validates:

* Account number uniqueness
* Minimum initial balance
* Positive deposit amount
* Positive withdrawal amount
* Minimum savings balance
* Valid source account
* Valid destination account
* Valid transfer amount

---

# 📊 Example Test Scenario

### Account 1

```text
Account Number: A101
Holder: Anu
Initial Balance: $1000
```

### Account 2

```text
Account Number: A102
Holder: Priya
Initial Balance: $1500
```

### Deposit

```text
A101 → Deposit $500
```

Balance:

```text
A101 → $1500
```

### Withdrawal

```text
A101 → Withdraw $200
```

Balance:

```text
A101 → $1300
```

### Transfer

```text
A101 → A102
Amount → $300
```

Final balances:

```text
A101 → $1000
A102 → $1800
```

---

# 🚀 Future Enhancements

The current project is a console-based implementation. It can be extended with:

* Current Account support
* Fixed Deposit Account
* Interest calculation
* User authentication
* PIN/password authentication
* Database integration using MySQL
* JDBC integration
* Persistent account storage
* REST API using Spring Boot
* Web-based banking interface
* ATM simulation
* Email/SMS transaction notifications
* Monthly statements
* Loan management
* Role-based access control
* Improved concurrent transaction management

---

# 🎯 Learning Outcomes

Through this project, the following concepts are demonstrated:

* Understanding Java classes and objects
* Implementing abstraction
* Implementing inheritance
* Understanding polymorphism
* Applying encapsulation
* Using Java Collections
* Creating custom exceptions
* Handling runtime and checked exceptions
* Maintaining transaction records
* Using synchronized methods
* Building a layered Java application
* Developing a menu-driven console application

---

# 👩‍💻 Author

**Banking & Transaction Management Console**

A Core Java project developed for learning and demonstrating Object-Oriented Programming, exception handling, collections, transaction management, and basic concurrency concepts.

---

# 📄 License

This project is created for **educational, learning, and portfolio purposes**.
