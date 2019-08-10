
package Lesson2;
public interface ElectronicDevice extends Show{
    String warning = "Do Not Watch It";
    void turnOf();
    void turnOn();
}

interface Show{
    void startShow();
}