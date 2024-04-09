import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.Locale.ENGLISH;

public class Statistics  {

    public static Scanner readReceipts;
    public static Scanner readReceipts2;

    static {
        try {
            readReceipts2 = new Scanner (new File("src/Receipts.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            readReceipts = new Scanner (new File("src/Receipts.txt"));
        } catch (FileNotFoundException e) {
        }
    }


    public static double showStatistics() {
        double revenueSum = 0;

        while(readReceipts.hasNextLine()) {
            String line = readReceipts.nextLine();
            Scanner lineReader = new Scanner(line);
            String token = lineReader.next();
            revenueSum += lineReader.nextDouble();
        }
        readReceipts.close();
        return revenueSum;

    }

    public static void showTopFive () {
        ArrayList<String> Receipts = new ArrayList<String>();

        while(readReceipts2.hasNextLine()) {
            String line = readReceipts2.nextLine();
            String[] tokens = line.split(" ");
            String name = tokens[0];
            Receipts.add(name);
        }

        Collections.sort(Receipts);

        Map <String, Integer> ReceiptCounter = new HashMap<>();

        for(String pizza : Receipts) {
            ReceiptCounter.put(pizza, ReceiptCounter.getOrDefault(pizza, 0) + 1);
        }

        System.out.println("Pizza Counts:");

        for (Map.Entry<String, Integer> entry : ReceiptCounter.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }
    }
}
