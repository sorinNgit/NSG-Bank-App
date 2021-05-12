import java.util.Objects;

public abstract class Account {

    public int acc_nr;
    public String acc_holder;
    public double founds;
    public String iban;
    public String currency = "RON";
    public double eur_rate = 4.92;
    public double usd_rate = 4.20;
    public double gbp_rate = 5.77;
    public double rub_rate = 0.056;


    public abstract void deposit(int amount);
    public abstract void withdrawal(int amount);
    public void convert_eur(){
        System.out.println("\nConverting " +this.currency + " into EUR");
        if(this.currency == "RON"){
            this.founds = founds*0.20;
        } else if(this.currency == "USD"){
            this.founds = founds*0.85;
        } else if(this.currency == "GBP"){
            this.founds = founds*1.17;
        } else if(this.currency == "RUB"){
            this.founds = founds*0.011;
        }
        this.currency = "EUR";
    }
    public void convert_usd(){
        System.out.println("\nConverting " +this.currency + " into USD");
        if(this.currency == "RON"){
            this.founds = founds*0.24;
        } else if(this.currency == "EUR"){
            this.founds = founds*1.17;
        } else if(this.currency == "GBP"){
            this.founds = founds*1.38;
        } else if(this.currency == "RUB"){
            this.founds = founds*0.013;
        }
        this.currency = "USD";
    }
    public void convert_gbp(){
        System.out.println("\nConverting " +this.currency + " into GBP");
        if(this.currency == "RON"){
            this.founds = founds*0.17;
        } else if(this.currency == "EUR"){
            this.founds = founds*0.85;
        } else if(this.currency == "USD"){
            this.founds = founds*0.73;
        } else if(this.currency == "RUB"){
            this.founds = founds*0.0096;
        }
        this.currency = "GBP";
    }
    public void convert_rub(){
        System.out.println("\nConverting " +this.currency + " into RUB");
        if(this.currency == "RON"){
            this.founds = founds*17.94;
        } else if(this.currency == "EUR"){
            this.founds = founds*88.31;
        } else if(this.currency == "USD"){
            this.founds = founds*75.29;
        } else if(this.currency == "GBP"){
            this.founds = founds*103.67;
        }
        this.currency = "RUB";
    }
    public void convert_ron(){
        System.out.println("\nConverting " +this.currency + " into RON");
        if(this.currency == "EUR"){
            this.founds = founds*eur_rate;
        }else if(this.currency == "USD"){
            this.founds = founds*usd_rate;
        } else if(this.currency == "GBP"){
            this.founds = founds*gbp_rate;
        }else if(this.currency == "RUB"){
            this.founds = founds*rub_rate;
        }
        this.currency = "RON";
    }

    @Override
    public int hashCode(){
        return Objects.hash(acc_holder,acc_nr,founds,iban);
    }




}
