package oop.bankingwitharray;

import java.util.Objects;

public class Pos {

    private BankAccount[] bankAccounts = new BankAccount[50];

    void addKnownBankAccount(BankAccount bankAccount){
        //todo metoda asta face acelasi lucru cu cea din Card
        if(!hasBankAccount(bankAccount)) {
            for (int i = 0; i < bankAccounts.length; i++) {
                if (bankAccounts[i] == null) {
                    bankAccounts[i] = bankAccount;
                    break;
                }
            }
        }
    }

    private BankAccount linkCardToBankAccount(Card card) {
        BankAccount bankAccount = null;
        for (BankAccount bankAccounta : bankAccounts) {
            if(Objects.isNull(bankAccounta)){
                continue;
            }
            if (bankAccounta.isCardAttached(card)) {
                bankAccount = bankAccounta;
            }
        }
        return bankAccount;
    }

    private boolean hasBankAccount(BankAccount bankAccount){
        for(BankAccount item:bankAccounts){

            if(Objects.isNull(item)){
                continue;
            }
            if(item.equals(bankAccount)){
                return true;
            }
        }
        return false;
    }


    String pay(double amount, Card card){
        String output;
        BankAccount bankAccount = linkCardToBankAccount(card);
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

    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(BankAccount[] bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
