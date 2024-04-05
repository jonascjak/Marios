import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
boolean delivery;
String deliveryAddress;
LocalTime orderTime;
ArrayList<Pizza> order;
double totalPrice;
    public Order(String deliveryAddress, LocalTime orderTime, double totalPrice, ArrayList<Pizza> order){
        this.deliveryAddress = deliveryAddress;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.order = order;
    }

    public Order(LocalTime orderTime, double totalPrice,ArrayList<Pizza> order){
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.order = order;
    }

    @Override
    public String toString() {
        return !delivery ? "\nPickup time: "+orderTime+"\nTotal price: "+totalPrice+"\n"+order.toString() : "\nDelivery time: "+orderTime+"\nDelivery address: "+deliveryAddress+"\nTotal price: "+totalPrice;
    }
}
