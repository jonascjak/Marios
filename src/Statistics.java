import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.Locale.ENGLISH;

public class Statistics  {
//2 Scannere oprettet for at undgå at starte lsæning af fil et forkert sted.
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

//Metode der læser fra Receipt.txt og finder alle doubles (Pris), akkummulere summen og returnere.
    public static double showStatistics() {
        double revenueSum = 0;

        while(readReceipts.hasNextLine()) {
            String line = readReceipts.nextLine();
            Scanner lineReader = new Scanner(line);
            String token = lineReader.next();
            revenueSum += lineReader.nextDouble();
        }
        return revenueSum;

    }
//Metode der læser fra Receipts.txt og finder navnene på pizzaerne, printer de mest solgte pizzaer (top 5)
    public static ArrayList<String> showTopFive () {

        ArrayList<String> pizza = new ArrayList<>();                    //ArrayList med pizza fra Receipt.txt
        ArrayList<String> topFivePizza = new ArrayList<>();             // Arraylist med top 5 pizzer fra pizza ArrayList

//Loop der fylder ArrayList med pizzaer fra filen (Kun navnene, prisen).
        while (readReceipts2.hasNextLine())  {
            String line = readReceipts2.nextLine();
            Scanner lineReader = new Scanner(line);
            String name = lineReader.next();
            String number = lineReader.next();
            pizza.add(name);
        }
// Sortere ArrayList.
        Collections.sort(pizza);

// Loop der tæller antal gengangere i ArrayList og printer til konsol.
        int sum = 1;
// if condition i+1 < pizza.size() gør at loopet ikke læser udover ArrayList / avoider fencepost error
        for(int i = 0; i < pizza.size(); i++)    {
            if(i + 1 < pizza.size() && pizza.get(i + 1) != null && pizza.get(i).equalsIgnoreCase(pizza.get(i + 1)))   {
                sum += 1;
            } else {
                StringBuilder buildString = new StringBuilder();
                buildString.append(sum + " x ");
                buildString.append(pizza.get(i));
                topFivePizza.add(String.valueOf(buildString));
                sum = 1;
            }
        }

        Collections.sort(topFivePizza, Collections.reverseOrder());                         //Sortere topFivePizza ArrayList ud fra mest solgte

        for (int i = 5; i < topFivePizza.size(); i++)   {                                   //Fjerner alle pizzaer i ArrayList der ikke er top 5
            topFivePizza.remove(i);
        }


        return topFivePizza;
    }
}
