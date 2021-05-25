package client;

import java.util.*;
import account.*;

public class Client {

    private int id;
    private String name;
    private Account account;
    public List<Account> accounts = new ArrayList<>();

    public Client(){
        Account account = new CurrentAccount(name);
        accounts.add(account);
    }
    public Client(int id, String name){
        Account account = new CurrentAccount(name);
        accounts.add(account);
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public List<Account> getAccounts(){
        return accounts;
    }
    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;
    }
    public void addAccount(String name){
        Account account = new CurrentAccount(name);
        accounts.add(account);

    }

    @Override
    public String toString(){
        String allcards = "";
        for(Account account : accounts){
            allcards += account.acc_nr + " | ";
        }
        return "client.Client: " + name + " / Accounts: " + allcards;

    }


}
