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

    public static void mainMenu() throws FileNotFoundException {
        int answer;

        do {
            System.out.println("**Velkommen til Mario's Pizzabar**\nVælg en af de følgende muligheder for at fortsætte");
            System.out.println("Tast 1 for at Oprette Bestilling");
            System.out.println("Tast 2 for at Vise Menukort");
            System.out.println("Tast 3 for at Vise Statistik");
            System.out.println("Tast 0 for at afslutte Hovedmenu");
            answer = scan.nextInt();

            switch (answer) {
                case 1:
                    System.out.println("Opret ny bestilling");
                    addOrder();

                    break;


                case 2:
                    System.out.println("Her er Mario's menukort:");
                    showMenu();

                    break;
                case 3:
                    System.out.println("Oversigt over omsætning samt Top 5 Pizzaer:");
                    //showStatistics();

                    break;

                case 0:
                    System.out.println("Tak for denne gang.");

                default:
                    System.out.println("Ugyldig valgmulighed, vælg venligst enten 1, 2 eller 3.");
            }
        } while (answer != 0);

    }

    public static String showMenu() throws FileNotFoundException {
        Scanner menuFile = new Scanner(new File("C:\\Users\\PC\\IdeaProjects\\projekt test\\src\\menu"));

        while (menuFile.hasNextLine()) {
            System.out.println(menuFile.nextLine());

        }
        menuFile.close();
        return menuFile.toString();

    }
    public static void addOrder(){
        ArrayList<Pizza> Pizzas = new ArrayList<>();
        System.out.println("Skal bestillingen levers?");
        String delivery = scan.next();
        try {
            int answer;
            do {
                System.out.println("Hvilken pizza er blevet bestitl?");
                Pizza first = new Pizza(scan.nextInt(), scan.nextLine());
                Pizzas.add(first);
                System.out.println("Vil du tilføje flere pizza'er?");
                answer= scan.nextInt();
            } while (answer != 0);
        } catch (Exception e){

        }
        LocalTime time = LocalTime.now();
        //time.plusMinutes(15);
        Order currentOrder = new Order(time,60,Pizzas);
        System.out.printf(currentOrder.toString());
        orderList.add((currentOrder));
        orderList.toString();
    }
}
