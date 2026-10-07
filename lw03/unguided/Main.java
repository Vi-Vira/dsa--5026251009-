import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner regist = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        
        Set<String> registrations = new LinkedHashSet<>();
        
        while(regist.hasNext()){
            String nrp = regist.next();
            if(registrations.contains(nrp)){
                continue;
            }
            else{
                registrations.add(nrp);
            }
        }

        Scanner checkin = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        Map<String, String> count = new LinkedHashMap<>();

        int success = 0;
        int rejected = 0;

        System.out.println("===== Event Check-In Results =====");

        while(checkin.hasNext()){
            String nrp = checkin.next();
            for(String r : registrations){
                if(nrp.equals(r)){
                    count.put(nrp, "Checked in");
                    success += 1;
                }
                else if((nrp.equals(r)) && (count.containsKey(nrp))){
                    count.put(nrp, "Rejected (already checked in)");
                    rejected += 1;
                }
                else{
                    count.put(nrp, "Rejected (not registered)");
                    rejected += 1;
                }
            }
        }

        for(String c : count.keySet()){
            System.out.println(c + ": " + count.get(c));
        }

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registrations.size());
        System.out.println("Succesful check-ins: " + success);
        System.out.println("Absent students: ");
        System.out.println("Rejected attempts: " + rejected);
    }
}
