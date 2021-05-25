import java.io.*;
import java.time.LocalDateTime;


public class CSV_Audit {

    private static CSV_Audit csv_instance;

    private CSV_Audit(){
        //TODO: maybe a constructor
    }

    public static CSV_Audit getInstance(){
        if(csv_instance == null){
            csv_instance = new CSV_Audit();
        }
        return csv_instance;
    }

    public static void writeAction(String name){
        try{
            File csv = new File("audit.csv");
            BufferedReader br = new BufferedReader(new FileReader("audit.csv"));
            FileWriter fw = new FileWriter("audit.csv",true);
            String row = br.readLine();
            if(row == null){
                String header = "action_name,timestamp\n";
                fw.append(header);
                fw.flush();
            }
            fw.append(name +"," + LocalDateTime.now() + "\n");
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
