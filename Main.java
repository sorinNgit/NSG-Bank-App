import java.util.ArrayList;

import account.CurrentAccount;
import account.SavingsAccount;
import card.Card;
import client.ClientService;
import csv.CSV_Reader;
import csv.CSV_Writer;
import databaseConfiguration.DataSetup;
import repository.ClientRepository;
import client.*;
import repository.*;

public class Main {

    public static void main(String[] args){

        CSV_Writer csv_writer = new CSV_Writer();
        csv_writer.writeClient("register_client_input.csv", new String[]{"Vacarescu Cosmin"});
        csv_writer.writePayment("payment.csv","1300", new String[]{"Apple Watch","eBay","29","09","2017"});
        csv_writer.writeDeposit("deposit.csv", new String[]{"200"});
        csv_writer.writeCashing("cashing.csv","2000", new String[]{"","Mama","04","05","2021"});

        ClientService clientService = new ClientService();

        CSV_Reader csv_reader = new CSV_Reader();

        // List of clients input from csv
        ArrayList<String[]> client_data = csv_reader.getClientCSV("register_client_input.csv");
        for(String[] name : client_data){
            clientService.registerClient(name[0]);
        }
        clientService.addAccount(ClientService.registeredClients.get(0));
        clientService.printCards();
        clientService.printClients();

        // Deposit value input from CSV
        ArrayList<String[]> deposit_data = csv_reader.getDepositCSV("deposit.csv");
        int deposit_value = Integer.parseInt(deposit_data.get(0)[0]);

        // Withdrawal value input from CSV
        ArrayList<String[]> withdrawal_data = csv_reader.getWithdrawalCSV("withdrawal.csv");
        int withdrawal_value = Integer.parseInt(withdrawal_data.get(0)[0]);

        // Payment input from CSV
        ArrayList<String[]> payment_data = csv_reader.getPaymentCSV("payment.csv");

        // Cashing input from CSV
        ArrayList<String[]> cashing_data = csv_reader.getCashingCSV("cashing.csv");

        // Return input from CSV
        ArrayList<String[]> return_data = csv_reader.getReturnCSV("return.csv");




        if(clientService.findClientByName(client_data.get(0)[0]).accounts.get(0) instanceof CurrentAccount) {
            CurrentAccount account1 = (CurrentAccount) clientService.findClientByName(client_data.get(0)[0]).accounts.get(0);
            account1.setAccHolder(client_data.get(0)[0]);
            account1.addCard(account1.acc_holder);

            account1.deposit(deposit_value);
            account1.withdrawal(withdrawal_value);

            account1.check_balance();

            // Payment
            for(String[] p_data : payment_data){
                int amount = Integer.parseInt(p_data[0]);
                account1.payment(amount,p_data[1],p_data[2],p_data[3],p_data[4],p_data[5]);
            }
            account1.check_balance();

            // Cashing
            for(String[] c_data : cashing_data){
                int amount = Integer.parseInt(c_data[0]);
                account1.cashing(amount,c_data[1],c_data[2],c_data[3],c_data[4],c_data[5]);
            }
            account1.check_balance();


            account1.convert_eur();
            account1.check_balance();

            account1.convert_gbp();
            account1.check_balance();

            account1.convert_ron();
            account1.check_balance();

            account1.printTransactions();

            // Return item
            for(String[] r_data : return_data){
                int amount = Integer.parseInt(r_data[0]);
                account1.returnItem(amount,r_data[1],r_data[2],r_data[3],r_data[4],r_data[5]);
            }

            account1.printTransactions();
        }


        // Etapa 3

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
