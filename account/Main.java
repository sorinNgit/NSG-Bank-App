package account;

public class Main {

    public static void main(String[] args){
        CurrentAccount x = new CurrentAccount("Sorin");
        x.addCard(x.acc_holder);
        x.deposit(25000);
        x.withdrawal(300);
        SavingsAccount y =  new SavingsAccount("Sorin");
        y.deposit(500);
        y.check_balance();
        y.withdrawal(39999);
        y.deposit(200);

        CurrentAccount ema = new CurrentAccount("Ema");
        ema.cashing(10000, "pt vacanta", "Sory", "31","03","2021");
        ema.check_balance();
        ema.payment(3000,"vacanta","Hotel Malibu", "01", "04","2021");
        ema.check_balance();
        ema.convert_eur();
        ema.check_balance();


        x.payment(800, "bicicleta", "eMag", "18" ,"07" ,"2020");
        x.payment(9000000, "pepsi" , "Kaufland", "20", "12", "2020");
        x.check_balance();
        x.cashing(1500,"",  "bunica","19", "05" ,"2020");
        x.check_balance();
        x.convert_eur();
        x.check_balance();
        x.convert_gbp();
        x.check_balance();
        x.convert_ron();
        x.check_balance();
        x.printTransactions();
        System.out.println(x);
    }
}
