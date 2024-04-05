import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        ArrayList<Pizza> Pizzas = new ArrayList<>();
        Pizza first = new Pizza(scan.nextInt(),scan.nextLine());
        Pizza second= new Pizza(scan.nextInt(),scan.nextLine());
        Pizzas.add(first);
        Pizzas.add(second);
        LocalTime time = LocalTime.now();
        time.plusMinutes(15);
        Order currentOrder = new Order(time.withNano(0),60,Pizzas);
        System.out.printf(currentOrder.toString());
    }
}
