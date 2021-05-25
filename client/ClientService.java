package client;

import java.util.ArrayList;
import java.util.*;
import account.*;
import csv.*;
import card.Card;

public class ClientService {

    public static List<Client> registeredClients = new ArrayList<>();

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
        CSV_Audit.writeAction("Register client.Client");
    }

    public void registerClient(int id, String name){

        Client client = new Client(id, name);
        registeredClients.add(client);
        Collections.sort(registeredClients, new Comparator<Client>(){
            @Override
            public int compare(Client c1, Client c2){
                return c1.getName().compareTo(c2.getName());
            }
        });
        CSV_Audit.writeAction("Register client.Client");
    }

    public void printClients() {
        for(Client client : registeredClients){
            System.out.println(client);
        }
        CSV_Audit.writeAction("Show Clients");
    }

    public void addAccount(Client client){
        Account account = new CurrentAccount(client.getName());
        client.accounts.add(account);
        CSV_Audit.writeAction("Add account.Account");
    }

    public void printCards(){
        for(Client client : registeredClients) {
            for (Account account : client.accounts) {
                if (account instanceof CurrentAccount) {
                    CurrentAccount account1 = (CurrentAccount) account;
                    account1.addCard(account1.getAccHolder());
                    StringBuilder allCards = new StringBuilder();
                    for(Card card : account1.cards){
                        allCards.append(card.number).append(" | ");
                    }
                    System.out.println(client.getName() + "'s card: " + allCards);
                }
            }
        }
        CSV_Audit.writeAction("Show Cards");
    }

    public Client findClientByName(String name){
        for(Client client : registeredClients){
            if(client.getName().equals(name)){
                CSV_Audit.writeAction("Find client.Client");
                return client;
            }
        }

        return null;
    }

}