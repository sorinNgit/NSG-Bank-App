package transaction;
import card.Card;

public class OnlineTransaction{


    Card card = new Card("Neculae Sorin");

    public void PrintCardNumber(){
        System.out.println(card.number);
    }

}
