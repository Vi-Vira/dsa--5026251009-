import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
    LinkedList<String[]> orders = new LinkedList<>();
    LinkedList<String[]> food = new LinkedList<>();
    LinkedList<String[]> drink = new LinkedList<>();
    LinkedList<String[]> success_orders = new LinkedList<>();

    Queue<String[]> process_orders = new LinkedList<>();

    Stack<String[]> failed_orders = new Stack<>();

    Scanner inp = new Scanner(Main.class.getResourceAsStream("orders.txt"));

    while(inp.hasNextLine()){
        String line = inp.nextLine().trim();
        if(!line.isEmpty()){
            String[] parts = line.split(" ");
            orders.add(parts);
        }
    }

    food.add(new String[]{"Bakso", "2"});
    food.add(new String[]{"Sate", "1"});
    food.add(new String[]{"Soto", "2"});

    drink.add(new String[]{"EsTeh", "4"});
    drink.add(new String[]{"EsJeruk", "2"});

    for(String[] o : orders){
        process_orders.add(o);
    }

    while(!process_orders.isEmpty()){
        String[] order = process_orders.poll();

        String name = order[0];
        String dish = order[1];
        String beverage = order[2];
        String table = order[0];

        boolean dish_avail = false;
        boolean beverage_avail = false;

        for(String[] f : food){
            if(f[0].equals(dish)){
                int food_stock = Integer.parseInt(f[1]);
                if(food_stock >= 1){
                    dish_avail = true;
                }
                else if(dish.equals("-")){
                    dish_avail = true;
                }
                else{
                    break;
                }
            }
        }

        for(String[] d : drink){
            if(d[0].equals(beverage)){
                int drink_stock = Integer.parseInt(d[1]);
                if(drink_stock >= 1){
                    beverage_avail = true;
                }
                else if(beverage.equals("-")){
                    beverage_avail = true;
                }
                else{
                    break;
                }
            }
        }

        if(dish_avail && beverage_avail){
            success_orders.add(order);
            for(String[] f : food){
                if(f[0].equals(dish)){
                int food_stock = Integer.parseInt(f[1]);
                food_stock -= 1;
                }
            }
            for(String[] d : drink){
                if(d[0].equals(beverage)){
                int drink_stock = Integer.parseInt(d[1]);
                drink_stock -= 1;
                }
            }
        }

        else{
            failed_orders.add(order);
        }
        
    }

    System.out.println("=== Success Orders ===");
    for (String[] s : success_orders) {
        System.out.println(s[0] + " " + s[1] + " " + s[2] + " " + s[3]);
    }

    System.out.println();
        
    System.out.println("=== Remaining Food Stock ===");
        for (String[] f : food) {
            System.out.println(f[0] + " : " + f[1]);
        }

System.out.println();
    
    System.out.println("=== Remaining Drink Stock ===");
        for (String[] d : drink) {
            System.out.println(d[0] + " : " + d[1]);
        }

System.out.println();

    System.out.println("=== Failed Orders ===");
        for (String[] f : failed_orders) {
            while(!failed_orders.isEmpty()){
                String[] failed = failed_orders.pop();
                System.out.println(failed[0] + " " + failed[1] + " " + failed[2] + " " + failed[3]);
            }
        }
    }
}