package com.bank.app.model;

/*
 * Create a class FDAccount which extends Account class with the following properties
 * maturityDate as LocalDate
 * interestRate as double
 * and create below methods
 * getTenure - to return the tenure of the FD in months
 * getMaturityAmount - to return the  maturity amount of the FD
 */
import java.time.LocalDate;
import java.util.List;

public class FDAccount extends Account {

    private LocalDate maturityDate;
    private double interestRate;

    public FDAccount(int accountNumber, double balance, LocalDate openingDate, List<Transaction> transactions, LocalDate maturityDate, double interestRate) {
        super(accountNumber, balance, openingDate, transactions);
        this.maturityDate = maturityDate;
        this.interestRate = interestRate;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTenure() {
        return (int) (maturityDate.toEpochDay() - getOpeningDate().toEpochDay()) / 30;
    }

    public double getMaturityAmount() {
        return getBalance() + (getBalance() * interestRate * getTenure() / 100);
    }

    //override toString method
    @Override
    public String toString() {
        return "FDAccount [maturityDate=" + maturityDate + ", interestRate=" + interestRate + ", getAccountNumber()="
                + getAccountNumber() + ", getBalance()=" + getBalance() + "]";
    }
}
