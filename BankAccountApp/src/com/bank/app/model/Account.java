package com.bank.app.model;
/*
 * Create an abstract class Account with the following fields:
 * accountNumber as integer
 * balance as double
 * openingDate as java LocalDate object
 * list of transactions as List of Transaction objects
 * 
 * Create below methods in the Account class:
 * deposit method to add credit transaction to the list of transactions for each deposit
 * getAccountDetails method which returns a string with account details
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private int accountNumber;
    private double balance;
    private LocalDate openingDate;
    private List<Transaction> transactions;

    public Account(int accountNumber, double balance, LocalDate openingDate, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
        this.transactions = transactions;
    }

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double setBalance(double balance) {
        return this.balance = balance;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        Transaction transaction = new Transaction.TransactionBuilder()
                .setDate(LocalDate.now())
                .setTransactionType(Transaction.TransactionType.CREDIT)
                .setAmount(amount)
                .build();
                
        transactions = transactions == null ? new ArrayList<>() : transactions;
        transactions.add(transaction);
        balance += amount;
    }

    public String getAccountDetails() {
        return "Account Number: " + accountNumber + "\n" +
                "Balance: " + balance + "\n" +
                "Opening Date: " + openingDate + "\n" +
                "Transactions: " + transactions;
    }
}
