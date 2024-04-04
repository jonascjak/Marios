import java.time.LocalTime;

public class Pizza {
    int pizzaNumber;
    int orderNumber;
    String comments;
    String deliveryAddress;
    LocalTime time;

    public Pizza(int pizzaNumber, LocalTime time){
        this.pizzaNumber = pizzaNumber;
        this.time = time;
    }

    public String toString() {
        return "number "+pizzaNumber+" "+time.withNano(0);
    }
}
