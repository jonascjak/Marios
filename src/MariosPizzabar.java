//Første tværfaglige projekt - April 2024, (Fatima, Jonas, Mads & Nunu)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.time.LocalTime;
import static java.time.LocalTime.*;

public class MariosPizzabar {
    //public static så det er tilgængeligt for alle, uden at parameteroverføre
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Order> orderList = new ArrayList();
    public static ArrayList<Pizza> allPizzaList = new ArrayList();
    public static LocalTime time = now();

    public static void main(String[] args) throws FileNotFoundException {
        readMenu();
        mainMenu();
    }

    public static void showList() {
        System.out.println("Bestillingsliste:");

        /*Da collections.sort kun kan sortere efter numerisk eller alfabetisk rækkefølge bruger vi
        comparator for at sortere efter LocalTime orderTime*/
        orderList.sort(Comparator.comparing(t->t.orderTime));

        for (Order Orders:orderList) {
            System.out.println(Orders.orderNumber);
            System.out.print(Orders.orderTime + " ");
            System.out.print(Orders.order + " ");
            System.out.print("Leveringsadresse:" + Orders.deliveryAddress + " ");
            System.out.println();
            System.out.println();
        }
    }
    public static void mainMenu() throws FileNotFoundException {
        int answer;

        do {
            showList();
            System.out.println("**Velkommen til Mario's Pizzabar**\nVælg en af de følgende muligheder for at fortsætte");
            System.out.println("Tast 1 for at Oprette Bestilling");
            System.out.println("Tast 2 for at Redigere ordre");
            System.out.println("Tast 3 for at Slette ordre");
            System.out.println("Tast 4 for at Vise Menukort");
            System.out.println("Tast 5 for at Vise Statistik");
            System.out.println("Tast 0 for at afslutte Hovedmenu");
            answer = scan.nextInt();

            switch (answer) {
                case 1:
                    System.out.println("Opret ny bestilling");
                    addOrder();
                    break;

                case 2:
                    System.out.println("Rediger ordre");
                    editOrder();
                    break;

                case 3:
                    System.out.println("Slet ordre");
                    //deleteOrder();

                case 4:
                    System.out.println("Her er Mario's menukort:");
                    showMenu();
                    break;

                case 5:
                    PrintRevenueAndTopFive();
                    break;

            }
        } while (answer != 0);
        System.out.println("Tak for denne gang.");
        System.exit(0);
    }
    public static void showMenu() throws FileNotFoundException {
        Scanner menuFile = new Scanner(new File("src/menu.txt"));

        //printer menu.txt filen så længe der er en ny linje at læse
        while (menuFile.hasNextLine()) {
            System.out.println(menuFile.nextLine());
        }
        menuFile.close();
    }

    public static void addOrder() {
        ArrayList<Pizza> Pizzas = new ArrayList<>();
        int answer;
        double totalPrice = 0;

        do {
            System.out.println("Indtast pizzanummer: ");
            try {
                Pizza first = allPizzaList.get(scan.nextInt() - 1);
                Pizzas.add(first);
                totalPrice += first.pizzaPrice;
            } catch(Exception e){
                System.out.println("Den pizza findes ikke i systemet.");
            }
            System.out.println("Vil du tilføje flere pizza'er?\nTast 1 for ja\nTast 2 for nej");
            answer = scan.nextInt();

        } while (answer != 2);

        String deliveryAddress = null;
        LocalTime deliveryTime = null;

        //Bruger LocalTime til at vælge bestemt bestillings tidspunkt ->bruges til at sortere array
        LocalTime time = now();

        System.out.println("Skal bestillingen afhentes på et bestemt tidspunkt?\nTast 1 for ja\nTast 2 for nej");
        int whatTime = scan.nextInt();

        if (whatTime != 2) {
            System.out.println("Indtast tidspunkt:");
            deliveryTime = LocalTime.parse(scan.next());
        }else {
            deliveryTime = time.plusMinutes(15);
        }
        System.out.println("Skal bestillingen leveres?\nTast 1 for ja\nTast 2 for nej");
        int beDelivered = scan.nextInt();

        if (beDelivered != 2) {
            System.out.println("Indtast leveringsaddressen:");
            deliveryAddress = scan.next();
            Order currentOrder = new Order(orderList.size() + 1, deliveryAddress, deliveryTime.withNano(0), totalPrice, Pizzas);
            orderList.add((currentOrder));
        } else {
            Order currentOrder = new Order(orderList.size() + 1, deliveryTime.withNano(0), totalPrice, Pizzas);
            orderList.add((currentOrder));
        }
    }
    public static void editOrder() {
        System.out.println("Indtast ordrenummeret du ønsker at redigere:");
        int orderNumber = scan.nextInt()-1;

        if (orderNumber >= 0 && orderNumber < orderList.size()) {
            System.out.println("Rediger ordre:");
            addOrder();
            orderList.remove(orderNumber);
           //for at sikre at orderNumber starter på 1, fremfor 0.
            orderNumber += 1;

            System.out.println("Ordrernummer " + orderNumber + " er ændret.");
        } else {
            System.out.println("Ugyldigt ordrenummer.");
        }
    }

    public static void PrintRevenueAndTopFive ()    {
        System.out.println("Oversigt over omsætning samt Top 5 Pizzaer:");
        System.out.printf("Omsætning: %15.2f kr.", Statistics.showStatistics());
        System.out.println();
        System.out.print("Top 5 mest solgte: ");
        System.out.println(Statistics.showTopFive());
        System.out.println();
    }

    public static ArrayList<Pizza> readMenu() throws FileNotFoundException {
        Scanner readReceipts;
        readReceipts = new Scanner (new File("src/menu.txt"));
        String pizzaToppings = "";
        while(readReceipts.hasNextLine()) {
            String line =   readReceipts.nextLine();
            Scanner lineReader = new Scanner(line);
            int pizzaId = lineReader.nextInt();
            String pizzaName = lineReader.next();
            while (lineReader.hasNext() && !lineReader.hasNextDouble()){
                pizzaToppings = lineReader.next();
            }
            double pizzaPrice = lineReader.nextDouble();
            Pizza tempPizza = new Pizza(pizzaId,pizzaName,pizzaToppings,pizzaPrice);
            allPizzaList.add(tempPizza);
        }
        readReceipts.close();
        return allPizzaList;
    }
}

