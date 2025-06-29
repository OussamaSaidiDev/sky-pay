package org.example.specs;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
