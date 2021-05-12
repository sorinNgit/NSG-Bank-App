import card.Card;
import transaction.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CurrentAccount extends Account{
    public double comision = 0.5/100;
    private int limit = 20000;
    List<Transaction> transactions = new ArrayList<>();
    public List<Card> cards = new ArrayList<>();

    Random rand = new Random();

    public CurrentAccount(String acc_holder){
        this.acc_nr = rand.nextInt(999999999-100000000)+100000000;
        this.acc_holder = acc_holder;
        this.founds = 0;
        this.iban = "RO" + (rand.nextInt(9)+rand.nextInt(9)*10) + "NSG" + (rand.nextInt(999999999) + 1000000000);
    }

    @Override
    public void deposit(int amount){
        this.founds += amount - amount*comision;
        System.out.println("\n" + acc_nr + " has been added " + amount + " by " + getAccHolder());
        System.out.println("Card used: " + cards.get(0).getNumber() + "  " + this.acc_holder + "  " + cards.get(0).getExp());
        System.out.println("Founds: " + founds +" "+ currency);
        System.out.println("---------------------------------------------");
        CSV_Audit.writeAction("Deposit");

    }

    @Override
    public void withdrawal(int amount) {
        if (founds - amount - amount * comision < 0) {
            System.out.println("Insufficient founds!");
        } else {
            this.founds -= amount + amount * comision;
            System.out.println("\n" + acc_holder + " has withdrawn " + amount + " from " + acc_nr);
            System.out.println("Card used: " + cards.get(0).getNumber() + "  " + this.acc_holder + "  " + cards.get(0).getExp());
            System.out.println("Founds: " + founds + ' ' + currency);
            System.out.println("---------------------------------------------");
        }
        CSV_Audit.writeAction("Withdrawal");
    }

    public void payment(double amount, String item, String company, String day, String month, String year) {
        if (founds - amount < 0) {
            System.out.println("Insufficient founds!");
        } else {
            this.founds -= amount;
            System.out.println("\nYou have bought " + item + " from " + company + " via bank transfer!");
            Transaction transaction = new Transaction(amount, item, "to", company);
            transaction.setDate(day, month, year);
            transactions.add(transaction);
        }
        CSV_Audit.writeAction("Payment");
    }

    public void cashing(double amount,String item, String payer,String day, String month, String year){
        this.founds += amount;
        System.out.println("\n" + amount + " has been transferred into your account by " + payer);
        Transaction transaction = new Transaction(amount, item, "from", payer);
        transaction.setDate(day, month, year);
        transactions.add(transaction);
        CSV_Audit.writeAction("Cashing");
    }
    public void check_balance(){
        System.out.println("Balance available: " + getFounds() +" "+ currency);
    }


    public void printTransactions(){
        System.out.println("\nTransaction history: ");
        for(Transaction transaction : transactions){
            System.out.println(transaction);
        }
        CSV_Audit.writeAction("Transaction History");
    }

    public void addCard(String name){
        Card card = new Card(name);
        card.setAcc_nr(this.acc_nr);
        cards.add(card);
        CSV_Audit.writeAction("Add Card");
    }


    public void returnItem(double amount, String item,String payer, String day, String month, String year){
        this.founds += amount;
        Transaction transaction = new Transaction(amount, item,"to",payer);
        transaction.setDate(day,month,year);
        transactions.add(transaction);

        System.out.println("\nSuccessfully returned Bicicleta to " + payer +"!");
        CSV_Audit.writeAction("Return item");
    }

    // getters and setters

    public String getIban(){
        return iban;
    }

    public void setIban(String newIban){
        this.iban = newIban;
    }

    public int getAccNr(){
        return acc_nr;
    }

    public void setAccNr(int newAccNr){
        this.acc_nr = newAccNr;
    }

    public String getAccHolder(){
        return acc_holder;
    }

    public void setAccHolder(String newAccHolder){
        this.acc_holder = newAccHolder;
    }

    public double getFounds(){
        return founds;
    }

    public void setFounds(int newFounds){
        this.founds = newFounds;
    }

    @Override
    public String toString(){
       return "\nExtras de cont\nAccount Holder: " + this.acc_holder + '\n'
               + "Account Number: " + this.acc_nr + '\n'
               + "Iban: "+ this.iban;
    }


}
