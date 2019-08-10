/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3Collections.exercise3;
import java.util.Comparator;

/**
 *
 * @author Azargul Nazari (1414322)
 */
public // Sort the shirt according the the description
class SortShirtByDesc implements Comparator<Shirt>{

    @Override
    public int compare(Shirt o1, Shirt o2) {
        return o1.getDescription().compareTo(o2.getDescription());
    }

}

