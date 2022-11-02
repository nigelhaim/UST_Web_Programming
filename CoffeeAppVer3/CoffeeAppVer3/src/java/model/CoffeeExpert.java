/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lawrence
 */
public class CoffeeExpert {
    public List<String> getCoffee(String type) {
        List<String> drinks = new ArrayList<String>();
        if (type.equals("Coffee/Espresso")) {
            drinks.add("Espresso");
            drinks.add("Barako");
            drinks.add("Caffe Americano");
            drinks.add("Caffe Mocha");
            drinks.add("Cappuccino");
        } else if (type.equals("Non-Coffee/Cream")) {
            drinks.add("Strawberry Cream Frappe");
            drinks.add("Green Tea Cream Blended Frappe");
            drinks.add("Caramel Blended Frappe ");
        } else if (type.equals("Frappe")) {
            drinks.add("Mocha Frappe");
            drinks.add("Java Chip Frappe");
            drinks.add("White Cholocate Mocha Frappe");
        } else if (type.equals("Tea-based")) {
            drinks.add("Iced Chai Latte");
            drinks.add("Chai Tea Latte");
            drinks.add("Green Tea Latte");
        } else {
            drinks = null;
        }
        return drinks;
    }
}
