import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner regist = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        
        Set<String> registrations = new LinkedHashSet<>();
        
        while(regist.hasNext()){
            String nrp = regist.next();
            registrations.add(nrp);
        }

        Scanner checkin = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        Set<String> checkins = new LinkedHashSet<>();
        List<String> checkInList = new ArrayList<>();

        int success = 0;
        int rejected = 0;

        System.out.println("===== Event Check-In Results =====");

        while(checkin.hasNext()){
            String nrp = checkin.next();
                if((!checkins.contains(nrp) && (registrations.contains(nrp)))){
                    checkins.add(nrp);
                    checkInList.add(nrp + ": Checked in");
                    success += 1;
                }
                else if(checkins.contains(nrp)){
                    checkInList.add(nrp + ": Rejected (already checked in)");
                    rejected += 1;
                }
                else{
                    checkInList.add(nrp + ": Rejected (not registered)");
                    rejected += 1;
                }
        }

        for(String c : checkInList){
            System.out.println(c);
        }

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registrations.size());
        System.out.println("Succesful check-ins: " + success);
        System.out.println("Absent students: " + (registrations.size() - success));
        System.out.println("Rejected attempts: " + rejected);
    }
}
