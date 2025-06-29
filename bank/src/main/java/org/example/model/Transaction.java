package org.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.utils.Const.DATE_FORMATTER;

public class Transaction {



    private LocalDateTime date;
    private int amount;
    private int balance;

    public Transaction(LocalDateTime date,int amount, int balance){
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }


    public int getAmount() {
        return amount;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return  date.format(DATE_FORMATTER) + "| "+ amount + " | " + balance;
    }
}
