import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
    int orderNumber;
boolean delivery;
String deliveryAddress;
LocalTime orderTime;
ArrayList<Pizza> order;
double totalPrice;
    public Order(int orderNumber,String deliveryAddress, LocalTime orderTime, double totalPrice, ArrayList<Pizza> order){
        this.deliveryAddress = deliveryAddress;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.order = order;
        this.delivery = true;
        this.orderNumber = orderNumber;
    }

    public Order(int orderNumber,LocalTime orderTime, double totalPrice,ArrayList<Pizza> order){
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.order = order;
        this.delivery = false;
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return !delivery ? orderNumber+"\nPickup time: "+orderTime+"\nTotal price: "+totalPrice+"\n"+order.toString() : orderNumber+"\nDelivery time: "+orderTime+"\nDelivery address: "+deliveryAddress+"\nTotal price: "+totalPrice+"\n"+order.toString();
    }
}
