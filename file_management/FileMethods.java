package file_management;

import javax.swing.text.JTextComponent;
import java.io.*;
import java.util.Collections;
import java.util.Arrays;

public class FileMethods {

    static String basicDirectory = "C:\\Users\\Sorin\\Desktop\\ANUL 2\\SEM 2\\PAO\\NSG_Bank_App";

    public static void main(String[] args){
        //File dir = createDirectory("proiect_dir_test");
        //createFile(dir, "file1.csv");
        //createFile(dir, "file2.txt");
        String ourPath = "file1.csv";
        readUsingFileReader(ourPath);
        writeUsingFileReader("s","s");
    }


    private static void listFiles(File dir){
        File[] files = dir.listFiles();
        for(File file: files){
            System.out.println(file.getName());
        }
    }

    private static void createFile(File dir, String filename){
        String path = dir.getPath() + File.separator + filename;
        File file = new File(path);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static File createDirectory(String directoryName){
        File dir = new File(directoryName);
        boolean mkdir = dir.mkdir();
        if(mkdir){
            System.out.println("Directory: " + directoryName + " created!");
        } else{
            throw new RuntimeException("Cannot create directory " + directoryName);
        }

        return dir;
    }


    public static void readUsingFileReader(String path){
        File file = new File(path);
        String row;
        try(BufferedReader csvReader =  new BufferedReader(new FileReader(path))){
            while((row = csvReader.readLine()) != null){
                String[] data = row.split(",");
                System.out.println(Arrays.toString(data));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeUsingFileReader(String path, String text){
        try(FileWriter fileWriter = new FileWriter(path)){
            fileWriter.write(text);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
