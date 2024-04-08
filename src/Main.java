import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Order> orderList = new ArrayList();
    public static void main(String[] args) throws FileNotFoundException {
        mainMenu();
    }

    public static void showList() {
        System.out.println("Bestillingsliste:");
        for (Order Order : orderList) {
            System.out.println(Order);
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
                    //editOrder();
                    break;

                case 3:
                    System.out.println("Slet ordre");
                    //deleteOrder();

                case 4:
                    System.out.println("Her er Mario's menukort:");
                    showMenu();

                    break;
                case 5:
                    System.out.println("Oversigt over omsætning samt Top 5 Pizzaer:");
                    //showStatistics();
                    break;

                case 0:
                    System.out.println("Tak for denne gang.");
                    System.exit(0);

                default:
                    System.out.println("Ugyldig valgmulighed, vælg venligst enten 1, 2 eller 3.");
            }
        } while (answer != 0);

    }

    public static String showMenu() throws FileNotFoundException {
        Scanner menuFile = new Scanner(new File("src/menu.txt"));
        while (menuFile.hasNextLine()) {
            System.out.println(menuFile.nextLine());
        }
        menuFile.close();
        return menuFile.toString();
    }
    public static void addOrder(){
        ArrayList<Pizza> Pizzas = new ArrayList<>();
            int answer;
            do {
                System.out.println("Hvilken pizza er blevet bestitl? Indtast nummeret på pizzaen og evt. kommentar");
                Pizza first = new Pizza(scan.nextInt(), scan.nextLine());
                Pizzas.add(first);
                System.out.println("Vil du tilføje flere pizza'er?\nTast 1 for ja\nTast 2 for nej");
                answer= scan.nextInt();
            } while (answer != 2);
        LocalTime time = LocalTime.now();
        LocalTime deliverTime = time.plusMinutes(15);
        System.out.println("Skal bestillingen levers?\nTast 1 for ja\nTast 2 for nej");
        int beDelivered = scan.nextInt();
        if(beDelivered != 2){
            System.out.println("Hvad er leverings addressen?");
            String deliveryAddress = scan.next();
            Order currentOrder = new Order(deliveryAddress,deliverTime.withNano(0),60,Pizzas);
            orderList.add((currentOrder));
        } else {
            Order currentOrder = new Order(deliverTime.withNano(0), 60, Pizzas);
            orderList.add((currentOrder));
        }
    }

    /*public static void editOrder() {
        System.out.println("Indtast det ordrenummeret du ønsker at redigere");
        int orderNumber = scan.nextint();
        if (orderNumber >= 0 && orderNumber < orderList.size()){
            System.out.println

        }
        Order editOrder = orderList().get(orderList.size())-1);*/
    }


