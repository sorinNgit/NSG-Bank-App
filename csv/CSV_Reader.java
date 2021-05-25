package csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV_Reader {
    private static CSV_Reader csv_instance;

    public CSV_Reader(){
        //TODO: maybe make constructor
    }

    public static CSV_Reader getInstance(){
        if(csv_instance == null){
            csv_instance = new CSV_Reader();
        }
        return csv_instance;
    }


    public static ArrayList<String[]> readUsingFileReader(String path){
        File file = new File(path);
        ArrayList<String[]> all_data = new ArrayList<>();
        String row;
        try(BufferedReader csvReader =  new BufferedReader(new FileReader(path))){
            while((row = csvReader.readLine()) != null){
                String[] data = row.split(",");
                all_data.add(data);
            }
            return all_data;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String[]> getClientCSV(String path){
        ArrayList<String[]> data = readUsingFileReader(path);
        return data;

    }

    public ArrayList<String[]> getDepositCSV(String path){
        ArrayList<String[]> data = readUsingFileReader(path);
        return data;
    }

    public ArrayList<String[]> getWithdrawalCSV(String path){
        ArrayList<String[]> data = readUsingFileReader(path);
        return data;
    }

    public void getCardCSV(){
        //TODO: implement
    }

    public ArrayList<String[]> getPaymentCSV(String path){
        ArrayList<String[]> data = readUsingFileReader(path);
        return data;
    }

    public ArrayList<String[]> getCashingCSV(String path){
        ArrayList<String[]> data = readUsingFileReader(path);
        return data;
    }

    public ArrayList<String[]> getReturnCSV(String path){
        ArrayList<String[]> data = readUsingFileReader(path);
        return data;
    }


}
