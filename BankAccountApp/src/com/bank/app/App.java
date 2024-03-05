package com.bank.app;

import java.time.LocalDate;
import java.util.ArrayList;

import com.bank.app.exceptions.InsufficientBalanceException;
import com.bank.app.model.FDAccount;
import com.bank.app.model.SBAccount;
import com.bank.app.model.Transaction;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println( "Creating FD Account");
        FDAccount fdAccount = new FDAccount(101, 20000, LocalDate.now(), new ArrayList<Transaction>(),
        LocalDate.now().plusYears(1), 5.5);
        System.out.println( "FD Account Details");
        System.out.println(fdAccount.toString());

        System.out.println( "Creating SB Account");
        SBAccount sbAccount = new SBAccount(102, 15000, 5000);        
        System.out.println( "SB Account Details");
        System.out.println(sbAccount.toString());

        System.out.println("Depositing 2500 to SB Account");
        sbAccount.deposit(2500);
        System.out.println(sbAccount.toString());
        System.out.println("Withdrawing 1500 from the SB Account");
        sbAccount.withdraw(1500);
        System.out.println(sbAccount.toString());
        System.out.println("Withdrawing 11000 from the SB Account");
        try {
            sbAccount.withdraw(11000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sbAccount.toString());
        System.out.println("Transactions List");
        System.out.println(sbAccount.getTransactions().toString());
    }
}
