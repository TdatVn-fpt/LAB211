/**
 * tao 1 class khac de test protect chi can thua ke la goi ra duoc
 */
package Shape;

import Testacess_modifer.Hinhnon;


public class Magric_modifier extends Hinhnon{

    public Magric_modifier(double radius) {
        super(radius);
    }
     
    public void testProtected(){
        System.out.println("Hien thi hinhnon c/m protect: " + this.radius);
    }
}
