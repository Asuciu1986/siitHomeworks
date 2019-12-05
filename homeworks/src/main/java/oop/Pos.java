package oop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pos {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    void addKnownBankAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
    }

    private BankAccount linkCardToBankAccout(Card card) {
        BankAccount bankAccount = null;
        for (BankAccount bankAccounta : bankAccounts) {
            if (bankAccounta.getAttachedCardNumbers().contains(card)) {
                bankAccount = bankAccounta;
            }
        }
        return bankAccount;
    }

    String pay(double amount, Card card){
        String output;
        BankAccount bankAccount = linkCardToBankAccout(card);
        if(card.checkIfExpired()){
            return "Card expired. Contact your bank.";
        }
        if(bankAccount!=null) {

            output = bankAccount.withdrawMoney(amount);
            System.out.println("Bank account is " + bankAccount.getIban() + ", card is " + card.getCardNumber() + ", " +
                    " account balance is " + bankAccount.getBalance());
        }
        else{
            return "Card could not be linked to an account. Contact with you bank.";
        }

        return output;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
