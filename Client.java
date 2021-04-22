import account.Account;
import account.CurrentAccount;
import card.Card;

import java.util.*;

public class Client {


    private String name;
    private Account account;
    List<Account> accounts = new ArrayList<>();

    public Client(){
        Account account = new CurrentAccount(name);
        accounts.add(account);
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
        return "Client: " + name + " / Accounts: " + allcards;

    }


}
