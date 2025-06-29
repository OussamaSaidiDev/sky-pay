package org.example.utils;

import org.example.model.Account;

import java.util.List;

public class DisplayUtils {
    public static void displayStartMenu(List<Account> accountList){
        System.out.println("=== Welcome to the Banking System ===");
        System.out.println("Choose an account by ID:");
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println(i + ": " + accountList.get(i).getClientName());
        }
        System.out.print("Enter account ID: ");
    }


    public static void displayAccountMenu(Account account){
        System.out.println("\n=== Account: " + account.getClientName() + " ===");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Print Statement");
        System.out.println("-1. Logout");
        System.out.println("\n=== Balance: " + account.getBalance() + " ===");
        System.out.print("Choose option: ");
    }
}
