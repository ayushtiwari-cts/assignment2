package com.bank.app.model;


/*
 * Create Transaction class with the following fields:
 * date as java LocalDate object
 * transactionType as enum with 'debit' and 'credit'
 * amount as double
 * create a builder class for the Transaction class to create Transaction objects
 */
    
import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private TransactionType transactionType;
    private double amount;

    public enum TransactionType {
        DEBIT, CREDIT
    }

    public Transaction(LocalDate date, TransactionType transactionType, double amount) {
        this.date = date;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public static class TransactionBuilder {
        private LocalDate date;
        private TransactionType transactionType;
        private double amount;

        public TransactionBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public TransactionBuilder setTransactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public TransactionBuilder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Transaction build() {
            return new Transaction(date, transactionType, amount);
        }
    }

    //override toString method
    @Override
    public String toString() {
        return "Transaction [date=" + date + ", transactionType=" + transactionType + ", amount=" + amount + "]";
    }
}
