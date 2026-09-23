import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        InputStream file = Main.class.getResourceAsStream("/Washes.txt");
        Scanner inp = new Scanner(file);

        int T_val = inp.nextInt(); 
        List<WashService> washes = new ArrayList<>();

        for(int i = 0; i < T_val; i++){
            String label = inp.next();
            String id = inp.next();
            int days = inp.nextInt();
            int unit = inp.nextInt();

            if(label.toUpperCase().equals("MOTORCYCLE")){
                washes.add(new MotorcycleWash(id, days));
            }
            else if(label.toUpperCase().equals("CAR")){
                washes.add(new CarWash(id, days));
            }
        }
        for(WashService wash : washes){
            System.out.println(wash.Summary());
        }
        inp.close();
    }
}