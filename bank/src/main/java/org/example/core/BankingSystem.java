package org.example.core;

import org.example.exception.InsufficientFundsException;
import org.example.exception.InvalidAmountException;
import org.example.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.utils.Const.*;
import static org.example.utils.DisplayUtils.displayAccountMenu;
import static org.example.utils.DisplayUtils.displayStartMenu;

public class BankingSystem {
    private final List<Account> accountList;
    private final Scanner scanner;


    public BankingSystem() {
        this.accountList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void runSystem(){
        int input = 0;
        Account account = null;
        do{
            if(account == null){

                displayStartMenu(this.accountList);

                //Handling Account Selection
                input = scanner.nextInt();
                if(input >= 0 && input < accountList.size()) account = accountList.get(input);
                scanner.nextLine();

            }else {

                displayAccountMenu(account);
                input = scanner.nextInt();
                handleAccountOperation(input,account);
            }
        }while (input >= 0);
    }


    private void handleAccountOperation(int operation , Account account){
        switch (operation) {
            case DEPOSIT_OPTION:
                System.out.print("Enter deposit amount: ");
                int deposit = scanner.nextInt();
                try{
                    account.deposit(deposit);
                }catch (InvalidAmountException e){
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case WITHDRAW_OPTION:
                System.out.print("Enter withdraw amount: ");
                int withdraw = scanner.nextInt();
                try {
                    account.withdraw(withdraw);
                } catch (InsufficientFundsException | InvalidAmountException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case PRINT_STATEMENT_OPTION:
                account.printStatement();
                break;
            case LOGOUT_OPTION:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        this.accountList.add(account);
    }
}
