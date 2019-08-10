
package Lesson2;

import java.io.Serializable;

public class TV implements ElectronicDevice, Serializable{
    // Serializeable are markers which doesn't need to be implemented
    @Override
    public void turnOf() {
        
    }

    @Override
    public void turnOn() {

    }
    
    public void changeChannel(int channel) {
        System.out.println("It's initialized");
    }
    private void initializeScreen() {}

    @Override
    public void startShow() {

    }
}
