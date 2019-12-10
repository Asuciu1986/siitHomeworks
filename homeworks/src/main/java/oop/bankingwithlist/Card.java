package oop.bankingwithlist;

import java.util.Date;
import java.util.Objects;

public class Card {

    private String ownerName;
    private String cardNumber;
    private Date expirationDate;

    Card(String ownerName, String cardNumber, Date expirationDate) {
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    boolean checkIfExpired(){
        return expirationDate.compareTo(new Date()) < 0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    String getCardNumber() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return ownerName.equals(card.ownerName) &&
                cardNumber.equals(card.cardNumber) &&
                expirationDate.equals(card.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerName, cardNumber, expirationDate);
    }
}

