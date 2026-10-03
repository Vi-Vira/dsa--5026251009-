import java.util.*;

public class Main {
    public static void main(String[] args){
        //Problem 1
        Scanner problem1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> songs = new ArrayList<>();

        while(problem1.hasNext()){
            String line = problem1.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            if(type.equals("ADD")){
                String title = parts[1];
                songs.add(title);
            }
            else if(type.equals("INSERT")){
                int ind = Integer.parseInt(parts[1]);
                String title = parts[2];
                songs.add(ind, title);
            }
            else if(type.equals("REMOVE")){
                String title = parts[1];
                songs.remove(title);
            }
        }
        
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs:" + songs.size());
        for(int i = 1; i <= songs.size();i++){
            System.out.println(i + ": " + songs.get(i-1));
        }
        problem1.close();

        //Problem 2
        Scanner problem2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new LinkedHashSet<>();
        int duplicate = 0;
        int total_unique = 0;
        while(problem2.hasNext()){
            String name = problem2.next();
            if(participants.contains(name)){
                duplicate++;
            }
            else{
                participants.add(name);
                total_unique++;
            }
        }

        System.out.println();
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + total_unique);
        int count = 1;
        for(String p : participants){
            System.out.println(count + ". " + p);
            count++;
        }
        System.out.println("Duplicate registrations: " + duplicate);
        problem2.close();

        //Problem 3
        Scanner problem3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failed = 0;
        while(problem3.hasNext()){
            String line3 = problem3.nextLine();
            String[] parts3 = line3.split(" ");
            String type3 = parts3[0];
            String product = parts3[1];
            int quantity = Integer.parseInt(parts3[2]);
            if(type3.equals("ADD")){
                if(inventory.containsKey(product)){
                    inventory.put(product, inventory.get(product) + quantity);
                }
                else{
                    inventory.put(product, quantity);
                }
            }
            else{
                if(inventory.containsKey(product) && inventory.get(product) >= quantity){
                    inventory.put(product, inventory.get(product) - quantity);
                }
                else{
                    failed +=1;
                }
            }
        }

        System.out.println();
        System.out.println("===== Problem 3 =====");
        for(String i : inventory.keySet()){
            System.out.println(i + ": " + inventory.get(i));
        }
        System.out.println("Failed Sales: " + failed);
        problem3.close();
    }
}