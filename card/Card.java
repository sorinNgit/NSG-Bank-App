package card;

import java.util.Random;

public class Card {

    public String name;
    public String number;
    public String exp;
    public int cvc;
    public int acc_nr;

    Random rand = new Random();

    public Card(String name){
        this.name = name;
        this.cvc = rand.nextInt(99)+rand.nextInt(9)*100;
        this.exp = rand.nextInt(30) + "/" + rand.nextInt(12);
        this.number = (rand.nextInt(9999-1000) + 1000) + " " + (rand.nextInt(9999-1000) + 1000) + " " + (rand.nextInt(9999-1000) + 1000) + " " + (rand.nextInt(9999-1000) + 1000);
    }

    public void getCard(){
        System.out.println(number + "   " + exp + "   " + cvc);
        System.out.println(name);
        System.out.println(acc_nr);
        System.out.println("------------------------------------------");
    }



    //getters and setters

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String newNumber){
        this.number = newNumber;
    }

    public String getExp(){
        return exp;
    }
    public int getCvc(){
        return cvc;
    }
    public void setAcc_nr(int acc_nr){
        this.acc_nr = acc_nr;
    }
    public int getAcc_nr(){
        return acc_nr;
    }
}
