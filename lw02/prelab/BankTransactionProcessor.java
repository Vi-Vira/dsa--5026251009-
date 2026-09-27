import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BankTransactionProcessor {
    public static void main(String[] args) throws Exception {
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();

        Scanner fileScanner = new Scanner(new File("transactions.txt"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            transactions.add(parts); // {name, type, amount}
        }
        fileScanner.close();

        for (String[] t : transactions) {
            String name = t[0];
            boolean found = false;
            for (String[] c : customers) {
                if (c[0].equals(name)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                customers.add(new String[]{name, "0"});
            }
        }

        Queue<String[]> queue = new LinkedList<>(transactions);
        Stack<String[]> failedStack = new Stack<>();

        while (!queue.isEmpty()) {
            String[] trx = queue.poll();
            String name = trx[0];
            String type = trx[1];
            int amount = Integer.parseInt(trx[2]);

            String[] customer = null;
            for (String[] c : customers) {
                if (c[0].equals(name)) {
                    customer = c;
                    break;
                }
            }

            int balance = Integer.parseInt(customer[1]);

            if (type.equals("DEPOSIT")) {
                balance += amount;
                customer[1] = String.valueOf(balance);
            } else if (type.equals("WITHDRAW")) {
                if (amount > balance) {
                    failedStack.push(trx); // gagal
                } else {
                    balance -= amount;
                    customer[1] = String.valueOf(balance);
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] c : customers) {
            System.out.println(c[0] + " : " + c[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!failedStack.isEmpty()) {
            String[] f = failedStack.pop();
            System.out.println(f[0] + " " + f[1] + " " + f[2]);
        }
    }
}