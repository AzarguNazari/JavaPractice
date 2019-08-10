/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasketMarket;

import java.io.Serializable;

public class Bakery extends Item implements Serializable{
    private static final long serialVersionUID = 28L;
    public Bakery(String name,String description, double price, int stock) {
        super(name, description, price, stock);
    }
}
