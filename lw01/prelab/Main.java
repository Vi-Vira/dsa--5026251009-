import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        InputStream file = Main.class.getResourceAsStream("/jobs.txt");
        Scanner inp = new Scanner(file);

        List <PrintJob> jobs = new ArrayList<>();

        while(inp.hasNext()){
            String label = inp.next();
            String id = inp.next();
            int pages = inp.nextInt();

            if(label.equals("MONO")){
                jobs.add(new MonoPrint(id, pages));
            }
            else if(label.equals("COLOUR")){
                jobs.add(new ColourPrint(id, pages));
            }
        }

        for(PrintJob job : jobs){
            System.out.println(job.summary());
        }

        inp.close();
    }
}

