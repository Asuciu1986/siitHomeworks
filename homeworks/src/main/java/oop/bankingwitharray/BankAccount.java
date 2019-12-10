package oop.bankingwitharray;

import java.util.Objects;

public class BankAccount {

    private String iban;
    private double balance;
    private Card[] attachedCardNumbers = new Card[50];

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

        if(!isCardAttached(card)) {
            for (int i = 0; i < attachedCardNumbers.length; i++) {
                if (attachedCardNumbers[i] == null) {
                    attachedCardNumbers[i] = card;
                    break;
                }
            }
        }
    }

    boolean isCardAttached(Card card){
        for (Card attachedCardNumber : attachedCardNumbers) {
            if(Objects.isNull(attachedCardNumber)){
                continue;
            }
            if (attachedCardNumber.equals(card)) {
                return true;
            }
        }
        return false;
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

    Card[] getAttachedCardNumbers() {
        return attachedCardNumbers;
    }

    public void setAttachedCardNumbers(Card[] attachedCardNumbers) {
        this.attachedCardNumbers = attachedCardNumbers;
    }
}


