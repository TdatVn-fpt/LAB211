
package main;

import controller.Manager;
import util.Validate;
import view.ShowMenu;

/**
 *
 * @author dotha
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Validate vld = new Validate();
        Manager mng = new Manager();
        ShowMenu show = new ShowMenu(vld, mng);
        show.menuMain();
    }
    
}
