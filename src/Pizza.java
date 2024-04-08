import java.io.File;
import java.time.LocalTime;

public class Pizza {
    File menu = new File("menu.txt");
    int pizzaNumber;
    String comments;

    public Pizza(int pizzaNumber){
        this.pizzaNumber = pizzaNumber;
    }
    public Pizza(int pizzaNumber, String comments){
        this.pizzaNumber = pizzaNumber;
        this.comments = comments;
    }
    public String toString() {
        return "\nNumber: "+pizzaNumber+"\nComments: "+comments+"\n";
    }
}
