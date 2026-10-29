import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner inp = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int len = inp.nextInt();
        int[] values = new int[len];

        for(int i = 0 ; i < len ; i++){
            values[i] = inp.nextInt();
        }

        int count = 0;
        for(int i = 1 ; i < len ; i++){
            if(count < 3){
                int key = values[i];
                int j = i - 1;
                while(j >= 0 && values[j] < key){
                    values[j + 1] = values[j];
                    j--;
                }
                values[j + 1] = key;
                count++;
            }
            else{
                break;
            }
        }

        for(int val : values){
            System.out.print(val + " ");
        }

        System.out.println();

        int targets = inp.nextInt();
        for(int i = 0 ; i < targets ; i++){
            int target = inp.nextInt();
            int index = 0;
            boolean found = false;
            
            for(int j = 0 ; j < len ; j++){
                int val = values[j];
                if(val == target){
                    found = true;
                    index = j;
                    break;
                }
                else{
                    found = false;
                }
            }

            if(found){
                System.out.println(target + ": FOUND at index " + index);
            }
            else{
                System.out.println(target + ": NOT FOUND");
            }
        }
        inp.close();
    }
}