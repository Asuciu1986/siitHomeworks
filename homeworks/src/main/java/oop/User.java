package oop;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Card> cards = new ArrayList<>();
    private List<BankAccount> bankAccounts= new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
    }

    public void addBankAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
