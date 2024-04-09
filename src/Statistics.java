import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Locale.ENGLISH;

public class Statistics  {

    public static Scanner readReceipts;

    static {
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
            int tokenInt = lineReader.nextInt();
            String token = lineReader.next();
            revenueSum += lineReader.nextDouble();
        }

        while (readReceipts.hasNextDouble())  {
            revenueSum += readReceipts.nextDouble();
        }
        readReceipts.close();
        return revenueSum;

    }
}
