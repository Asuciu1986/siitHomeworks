package oop;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String iban;
    private double balance;
    private List<Card> attachedCardNumbers = new ArrayList<>();

    public BankAccount(String iban) {
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

    public String withdrawMoney(double amount) {
        if(balance>=amount) {
            balance -= amount;
            return "Transaction approved.";
        }
        else{
            return "Insufficient funds. Transaction declined";
        }
    }

    public void attachCard(Card card){
        attachedCardNumbers.add(card);
    }


    public boolean isCardAttached(Card card){
        return attachedCardNumbers.contains(card);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Card> getAttachedCardNumbers() {
        return attachedCardNumbers;
    }

    public void setAttachedCardNumbers(List<Card> attachedCardNumbers) {
        this.attachedCardNumbers = attachedCardNumbers;
    }
}


