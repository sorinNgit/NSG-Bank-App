package repository;

import account.CurrentAccount;
import account.SavingsAccount;
import card.Card;
import client.Client;
import databaseConfiguration.DataSetup;

public class Main {
    public static void main(String[] args){

        DataSetup setUpData = new DataSetup();

        setUpData.setUp("clients");
        ClientRepository clientRepository = new ClientRepository();
        Client client = new Client(8,"Titu Pavel");
        clientRepository.insertClient(client);
        clientRepository.updateClientName("Ayton Senna",18);
        setUpData.displayClient();


        setUpData.setUp("cards");
        CardRepository cardRepository = new CardRepository();
        Card card = new Card(4,"Ionescu Petru",993,"2881 4447 1760 4510","2/9");
        cardRepository.insertCard(card);
        cardRepository.updateCvc(888,2);
        cardRepository.displayCards();

        setUpData.setUp("current_accounts");
        CurrentAccountRepository currentAccountRepository = new CurrentAccountRepository();
        CurrentAccount currentAccount = new CurrentAccount(3,"Nicolae Ioan", 328, 11239923,"RO12NSG1002901763");
        currentAccountRepository.insertCurrentAccount(currentAccount);
        currentAccountRepository.updateFoundsCurrentAccount(0,1);
        currentAccountRepository.displayCurrentAccounts();

        setUpData.setUp("savings_accounts");
        SavingsAccountRepository savingsAccountRepository = new SavingsAccountRepository();
        SavingsAccount savingsAccount = new SavingsAccount(1,"Dobrescu Claudia", 3990, 183902339,"RO12NSG0913823991");
        SavingsAccountRepository.insertSavingsAccount(savingsAccount);
        savingsAccountRepository.updateFoundsSavingsAccount(1,1);
        savingsAccountRepository.displaySavingsAccount();




    }
}
