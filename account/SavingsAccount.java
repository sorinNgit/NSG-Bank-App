package account;

import account.Account;
import card.Card;
import java.util.*;

public class SavingsAccount extends Account {

    private double comision = 0.5 / 100;

    Card card = new Card(this.acc_holder);
    Random rand = new Random();
    public List<Card> cards = new ArrayList<>();
    public SavingsAccount(String name) {
        this.acc_nr = rand.nextInt(999999999 - 100000000) + 100000000;
        this.acc_holder = name;
        this.founds = 0;
        this.iban = "RO" + (rand.nextInt(9) + rand.nextInt(9) * 10) + "NSG" + (rand.nextInt(999999999) + 1000000000);
    }

    public SavingsAccount(int id,String name, double founds, int acc_nr, String iban){
        this.id = id;
        this.acc_holder = name;
        this.acc_nr = acc_nr;
        this.founds = founds;
        this.iban = iban;
    }

    public void addCard(String name){
        Card card = new Card(name);
        card.setAcc_nr(this.acc_nr);
        cards.add(card);
    }

    @Override
    public void deposit(int amount) {
        this.founds += amount - amount * comision;
        System.out.println(iban + " has been added " + amount + " by " + acc_holder);
        System.out.println("Card used: " + card.number + "  " + this.acc_holder + "  " + card.exp);
        System.out.println("Founds: " + founds + " " + currency);
        if(this.founds <0){
            System.out.println("You're still in debt "+ founds +" to the bank!");
        }
        System.out.println("---------------------------------------------");

    }

    @Override
    public void withdrawal(int amount) {
        this.founds -= amount + amount * comision;
        System.out.println(acc_holder + " has withdrawn " + amount + " from " + acc_nr);
        System.out.println("Card used: " + card.number + "  " + this.acc_holder + "  " + card.exp);
        System.out.println("Founds: " + founds + ' ' + currency);
        if (this.founds < 0) {
            System.out.println("You're in debt " + founds + " to the bank!");
        }
        System.out.println("---------------------------------------------");

    }

    public void check_balance(){
        System.out.println("Balance available: " + getFounds() +" "+ currency);
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

    public int getId(){return id;}
}
