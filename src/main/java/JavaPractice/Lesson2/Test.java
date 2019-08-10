
package Lesson2;

import java.io.Serializable;

public class Test {
    
    public static void main(String[] args) {
        
        ElectronicDevice tv = new TV();
        tv.turnOf();
        tv.turnOn();
        tv.changeChannel(123);  // fails
        
        if(tv instanceof TV){
            System.out.println("It's TV");
        }
        
        if(tv instanceof Serializable){
            System.out.println("It's a serializable");
        }
    }
    
    
}
