package org.example.model;

import org.example.exception.InsufficientFundsException;
import org.example.exception.InvalidAmountException;
import org.example.specs.AccountService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.example.utils.ExceptionMessages.*;

public class Account implements AccountService {



    private String clientName;
    private int balance;
    private List<Transaction> transactions;

    
    public  Account(String clientName,int balance){
        this.clientName = clientName;
        this.balance = balance;
        this.transactions = new ArrayList<>(0);
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException(INVALID_AMOUNT);
        }
        balance += amount;
        transactions.add(new Transaction(LocalDateTime.now(),amount,balance));
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException(INVALID_AMOUNT);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(INSUFFICIENT_FUNDS);
        }
        balance -= amount;
        transactions.add(new Transaction(LocalDateTime.now(),-amount,balance));
    }

    @Override
    public void printStatement() {
        System.out.println("Statement for " + clientName);
        System.out.println("Date | Amount | Balance");
        for(int i =  transactions.size() - 1  ; i >= 0 ;i--){
            System.out.println( transactions.get(i).toString());
        }
        System.out.println("Current Balance: " + balance);
    }


    public int getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return List.copyOf(transactions);
    }

    public String getClientName() {
        return clientName;
    }
}
