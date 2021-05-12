package card;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CardService {

    protected static List<Card> registeredCards = new ArrayList<>();

    public static void registerNewCard(String name){
        Card card = new Card(name);
        registeredCards.add(card);
    }

    public static void readCardsFromCsv(){
        File file = new File("card_input.txt");
        String row;
        try(BufferedReader csvReader =  new BufferedReader(new FileReader("card_input.txt"))){
            while((row = csvReader.readLine()) != null){
                String[] data = row.split(",");
                registerNewCard(data[0]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void printCards(){
        for(Card card : registeredCards){
            card.getCard(); 
        }
    }
}
