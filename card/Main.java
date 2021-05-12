package card;
import card.CardService;

public class Main {
    public static void main(String[] args){
        card.CardService.readCardsFromCsv();

        card.CardService.printCards();

    }
}
