package org.example.model;

public class Users {
    private int id;
    private int balance;

    public Users(int id,int balance){
        this.id = id;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
