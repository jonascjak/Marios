import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    Scanner scan;

    {
        try {
            scan = new Scanner(new File("menu.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
