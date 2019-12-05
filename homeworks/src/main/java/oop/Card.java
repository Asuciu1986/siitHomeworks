package oop;

import java.util.Date;

public class Card {

    private String ownerName;
    private String cardNumber;
    private Date expirationDate;

    public Card(String ownerName, String cardNumber, Date expirationDate) {
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public boolean checkIfExpired(){
        return expirationDate.compareTo(new Date()) < 0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}

