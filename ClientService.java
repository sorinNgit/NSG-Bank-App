
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

import account.Account;
import account.CurrentAccount;
import card.Card;

public class ClientService {

    protected static List<Client> registeredClients = new ArrayList<>();

    public void registerClient(String name) {
        Client client = new Client();
        client.setName(name);
        registeredClients.add(client);
        Collections.sort(registeredClients, new Comparator<Client>(){
            @Override
            public int compare(Client c1, Client c2){
                return c1.getName().compareTo(c2.getName());
            }
        });
    }

    public void printClients() {
        for(Client client : registeredClients){
            System.out.println(client);
        }
    }

    public void addAccount(Client client){
        Account account = new CurrentAccount(client.getName());
        client.accounts.add(account);

    }

    public void printCards(){
        for(Client client : registeredClients) {
            for (Account account : client.accounts) {
                if (account instanceof CurrentAccount) {
                    CurrentAccount account1 = (CurrentAccount) account;
                    account1.addCard(account1.getAccHolder());
                    String allCards = "";
                    for(Card card : account1.cards){
                        allCards += card.number + " | ";
                    }
                    System.out.println(client.getName() + "'s card: " + allCards);
                }
            }
        }
    }

    public Client findClientByName(String name){
        for(Client client : registeredClients){
            if(client.getName().equals(name)){
                return client;
            }
        }
        return null;
    }

}