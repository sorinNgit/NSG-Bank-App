package transaction;

public class Transaction {

    public String target_bank;
    public String motive;
    public double price;
    private String from_to;
    public String day;
    public String month;
    public String year;

    public Transaction(double price, String motive, String from_to,String target_bank){
        this.price = price;
        this.motive = motive;
        this.target_bank = target_bank;
        this.from_to = from_to;
    }
    public void setDate(String day,String month, String year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString(){
        if(from_to == "from"){
            return "From: " + target_bank + " | Motive: " + motive
                    + " | Amount: " + price
                    + " | Date: " + day + "/" +month+ "/"+year;
        }
        else{
            return "To: " + target_bank + " | Motive: " + motive
                    + " | Amount: " + price
                    + " | Date: " + day + "/" +month+ "/"+year;
        }
    }
}
