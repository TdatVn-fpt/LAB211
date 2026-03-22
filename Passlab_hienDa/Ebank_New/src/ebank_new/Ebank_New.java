
package ebank_new;

import java.util.Locale;

/**
 *
 * @author ADMIN
 */
public class Ebank_New {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ebank bank = new Ebank();
        
        while (true) {

            System.out.println("-------Login Program-------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");

            int choice = Validation.getInterger(
                    "Please choice one option: ", 1, 3);

            switch (choice) {
                case 1:
                    bank.logginfuction(Locale.forLanguageTag("vi"));
                    break;

                case 2:
                    bank.logginfuction(new Locale("en"));
                    break;

                case 3:
                    System.out.println("Bye!");
                    return;
            }
        }

    }

}
