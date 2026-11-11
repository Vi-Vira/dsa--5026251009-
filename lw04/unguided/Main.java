import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner inp = new Scanner(Main.class.getResourceAsStream("parcels.txt"));
        int len = inp.nextInt();
        int[] weights = new int[len];

        for(int i = 0; i < len; i++){
            weights[i] = inp.nextInt();
        }

        int[] two_passes = new int[len];

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len - 1 - i; j++){
                if (weights[j] < weights[j + 1]) {
                    int temp = weights[j];
                    weights[j] = weights[j + 1];
                    weights[j + 1] = temp;
                }
                if (weights[j] > weights[j + 1]){
                    continue;
                }
            }
            if(i == 1){
                int idx = 0;
                for(int w : weights){
                    two_passes[idx] = w;
                    idx++;
                }
            }
        }

        System.out.println("==== After 2 Passes ====");
        for(int t : two_passes){
            System.out.print(t + " ");
        }

        System.out.println();

        System.out.println("==== Fully Sorted ====");
        for(int w : weights){
            System.out.print(w + " ");
        }

        System.out.println();

        int targets = inp.nextInt();
        for(int i = 0; i < targets; i++){
            int target = inp.nextInt();
            int low = len - 1;
            int high = 0;
            int step = 0;
            boolean found = false;

            while (low >= high){
                int mid = high + (low - high) / 2;
                step++;
                if (weights[mid] == target){
                    System.out.println(target + ": FOUND at index " + mid + " (steps: " + step + ")"); 
                    found = true;
                    break;
                } 
                else if(weights[mid] < target){
                    low = mid - 1; 
                }
                else{
                    high = mid + 1;
                }
            }
            
            if(!found){
                System.out.println(target + ": NOT FOUND (steps: " + step + ")");
            }
        }
    inp.close();
    }
}