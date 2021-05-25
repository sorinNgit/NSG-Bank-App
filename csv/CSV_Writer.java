package csv;

import java.io.FileWriter;
import java.io.IOException;

public class CSV_Writer {
    private static CSV_Writer csv_instance;

    public CSV_Writer(){
        //TODO: maybe a constructor
    }

    public static CSV_Writer getInstance(){
        if(csv_instance == null){
            csv_instance = new CSV_Writer();
        }
        return csv_instance;
    }

    public static void writeMultipleUsingFileReader(String path,String first, String[] text){
        try(FileWriter fileWriter = new FileWriter(path,true)){
            fileWriter.append("\n");
            fileWriter.append(first);
            for(String element : text){
                fileWriter.append(","+element);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeOneUsingFileReader(String path, String[] text){
        try(FileWriter fileWriter = new FileWriter(path,true)){
            fileWriter.append("\n");
            fileWriter.append(text[0]);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeClient(String path, String[] text){
        writeOneUsingFileReader(path,text);
    }

    public void writeDeposit(String path, String[] text){
        writeOneUsingFileReader(path, text);
    }

    public void writePayment(String path,String first, String[] text){
        writeMultipleUsingFileReader(path, first, text);
    }

    public void writeCashing(String path, String first, String[] text){
        writeMultipleUsingFileReader(path, first, text);
    }
}
