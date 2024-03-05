package com.bank.app.model;

import java.time.LocalDate;

/*
 * Create a sub class SBAccount which extends Account class with the following fields:
 * minBalance as double
 * and a method withdraw which deducts the amount from the balance and adds a debit transaction to the list of transactions
 * and throws InsufficientBalanceException if the amount is not available in the account
 */
import com.bank.app.exceptions.InsufficientBalanceException;

public class SBAccount extends Account {

    private double minBalance;

    public SBAccount(int accountNumber, double balance, double minBalance) {
        super(accountNumber, balance);
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    //setMinBalance method to set the minimum balance
    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance()) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        Transaction transaction = new Transaction.TransactionBuilder()
                .setDate(LocalDate.now())
                .setTransactionType(Transaction.TransactionType.DEBIT)
                .setAmount(amount)
                .build();
        getTransactions().add(transaction);
        super.setBalance(getBalance() - amount);
    }

    //generate toString method
    @Override
    public String toString() {
        return "SBAccount [minBalance=" + minBalance + ", getAccountNumber()=" + getAccountNumber() + ", getBalance()="
                + getBalance() + "]";
    }
}