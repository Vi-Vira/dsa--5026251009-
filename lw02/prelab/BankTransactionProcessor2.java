import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BankTransactionProcessor2 {
    public static void main(String [] args) throws Exception{
        LinkedList<String[]> transactions = new LinkedList<>();

        Scanner inp = new Scanner(new File("transactions.txt"));

        while(inp.hasNextLine()){
            String line = inp.nextLine().trim();
            if(!line.isEmpty()){
                String[] parts = line.split("\\s+");
                transactions.add(parts);
            }
        }

        LinkedList<String[]> customers = new LinkedList<>();

        for(String[] t : transactions){
            String name = t[0];
            boolean exist = false;

            for(String[] c : customers){
                if(c[0].equals(name)){
                    exist = true;
                }
            }

            if(!exist){
                customers.add(new String[]{name, "0"});
            }
        }

        Queue<String[]> transac_queue = new LinkedList<>();

        for(String[] t : transactions){
            transac_queue.add(t);
        }

        Stack<String[]> failed_stack = new Stack<>();

        while(!transac_queue.isEmpty()){
            String[] t = transac_queue.poll();

            String name = t[0];
            String type = t[1];
            int amount = Integer.parseInt(t[2]);

            String[] customer = null;
            
            for(String[] c : customers){
                if(c[0].equals(name)){
                    customer = c;
                }
            }

            int balance = Integer.parseInt(customer[1]);

            if(type.toUpperCase().equals("DEPOSIT")){
                balance += amount;
                customer[1] = String.valueOf(balance);
            }
            else if(type.toUpperCase().equals("WITHDRAW")){
                if(amount > balance){
                    failed_stack.push(t);
                }
                else{
                    balance -= amount;
                    customer[1] = String.valueOf(balance);
                }
            }
        }

        System.out.println("=== Final Balance ==");
        for(String[] c : customers){
            System.out.println(c[0] + ": " + c[1]);
        }

        System.out.println();

        System.out.println("=== Failed Transaction == ");
        for(String[] f : failed_stack){
            while (!failed_stack.isEmpty()){
                String[] failed = failed_stack.pop();
                System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
            }
        }
    }
}