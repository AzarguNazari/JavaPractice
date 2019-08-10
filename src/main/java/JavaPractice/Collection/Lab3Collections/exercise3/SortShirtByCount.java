/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3Collections.exercise3;
import java.util.Comparator;

/**
 *
 * @author Azargul Nazari (144322)
 */
public // sort the shirts by the count number
class SortShirtByCount implements Comparator<Shirt>{

    @Override
    public int compare(Shirt o1, Shirt o2) {
        Long c1 = o1.getCount();
        Long c2 = o2.getCount();
        return c1.compareTo(c2);
    }

}


