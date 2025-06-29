package org.example;

import org.example.core.BankingSystem;
import org.example.model.Account;

public class Main {
    public static void main(String[] args) {

        Account account = new Account("OUSSAMA SAIDI" , 0);
        Account account2 = new Account("ANAS SAIDI" , 0);

        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.addAccount(account);
        bankingSystem.addAccount(account2);
        bankingSystem.runSystem();
    }
}