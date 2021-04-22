import account.CurrentAccount;

public class Main {

    public static void main(String[] args){
        ClientService clientService = new ClientService();
        clientService.registerClient("Neculae Sorin");
        clientService.addAccount(clientService.registeredClients.get(0));
        clientService.registerClient("Cucureanu Bogdan");
        clientService.registerClient("Popescu Alexandru");
        clientService.registerClient("Andronescu Florin ");
        clientService.printCards();
        clientService.printClients();

        if(clientService.findClientByName("Neculae Sorin").accounts.get(0) instanceof CurrentAccount) {
            CurrentAccount account1 = (CurrentAccount) clientService.findClientByName("Neculae Sorin").accounts.get(0);
            account1.setAccHolder("Neculae Sorin");
            account1.addCard(account1.acc_holder);
            account1.deposit(25000);
            account1.withdrawal(300);
            account1.check_balance();

            account1.payment(800, "bicicleta", "eMag", "18" ,"07" ,"2020");
            account1.payment(9000000, "pepsi" , "Kaufland", "20", "12", "2020");
            account1.check_balance();
            account1.cashing(1500,"",  "bunica","19", "05" ,"2020");
            account1.check_balance();
            account1.convert_eur();
            account1.check_balance();
            account1.convert_gbp();
            account1.check_balance();
            account1.convert_ron();
            account1.check_balance();
            account1.printTransactions();
            account1.returnItem(800, "return bicicleta","eMag", "20" ,"07" , "2020");
            account1.printTransactions();
        }

    }
}
