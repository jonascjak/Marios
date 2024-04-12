import java.io.File;
import java.time.LocalTime;

public class Pizza {
    int pizzaNumber;
    String pizzaName;
    String toppings;
    double pizzaPrice;

    public Pizza(int pizzaNumber, String pizzaName, String toppings, double pizzaPrice) {
        this.pizzaNumber = pizzaNumber;
        this.pizzaName = pizzaName;
        this.toppings = toppings;
        this.pizzaPrice = pizzaPrice;
    }
    public String toString() {
        return pizzaNumber+" "+pizzaName+" "+toppings+" "+pizzaPrice + " KR";
    }
}
