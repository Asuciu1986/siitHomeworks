package oop.bankingwitharray;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BankPaymentsPlay {

    public static void main(String[] args) throws ParseException {

        User user1 = new User();
        User user2 = new User();

        Card card1 = new Card("Alexandru Suciu", "4689234556781234", new SimpleDateFormat("dd/MM/yyyy").parse("21/10/2023"));
        Card card2 = new Card("Alexandru Suciu", "578923455672234", new SimpleDateFormat("dd/MM/yyyy").parse("21/10/2024"));
        Card card3 = new Card("Alexandru Suciu", "2389234556781234", new SimpleDateFormat("dd/MM/yyyy").parse("21/10/2018"));
        Card card4 = new Card("Gigel Comanel", "998923455672234", new SimpleDateFormat("dd/MM/yyyy").parse("21/10/2024"));


        user1.addCard(card1);
        user1.addCard(card2);
        user1.addCard(card3);
        user2.addCard(card4);

        BankAccount bankAccount1 = new BankAccount("RO23RNCB23288482823");

        System.out.println(bankAccount1.isCardAttached(card1));


        bankAccount1.attachCard(card1);

        BankAccount bankAccount2 = new BankAccount("RO88RNCB67288482863");
        bankAccount1.attachCard(card2);
        bankAccount2.attachCard(card3);

        BankAccount bankAccount3 = new BankAccount("RO99RNCB67288482863");
        bankAccount3.attachCard(card4);

        user1.addBankAccount(bankAccount1);
        user1.addBankAccount(bankAccount2);
        user2.addBankAccount(bankAccount3);

        bankAccount1.setBalance(1000.23);

        user1.addBankAccount(bankAccount1);
        user1.addBankAccount(bankAccount2);
        user2.addBankAccount(bankAccount3);

        Pos pos1 = new Pos();
        pos1.addKnownBankAccount(bankAccount1);
        pos1.addKnownBankAccount(bankAccount2);
        pos1.addKnownBankAccount(bankAccount3);

        String result=pos1.pay(800d,card1);
        System.out.println(result);


    }
}
