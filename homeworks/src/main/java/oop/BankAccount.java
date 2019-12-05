package oop;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String iban;
    private double balance;
    private List<Card> attachedCardNumbers = new ArrayList<>();

    BankAccount(String iban) {
        this.iban = iban;
    }

    public void addMoney(double amount) {
        if(amount>0) {
            balance += amount;
            System.out.println("Added " + amount + " to your account.");
        }
        else{
            System.out.println("Invalid amount. Transaction declined");
        }
    }

    String withdrawMoney(double amount) {
        if(balance>=amount) {
            balance -= amount;
            return "Transaction approved.";
        }
        else{
            return "Insufficient funds. Transaction declined";
        }
    }

    void attachCard(Card card){
        attachedCardNumbers.add(card);
    }


    public boolean isCardAttached(Card card){
        return attachedCardNumbers.contains(card);
    }

    String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    List<Card> getAttachedCardNumbers() {
        return attachedCardNumbers;
    }

    public void setAttachedCardNumbers(List<Card> attachedCardNumbers) {
        this.attachedCardNumbers = attachedCardNumbers;
    }
}


