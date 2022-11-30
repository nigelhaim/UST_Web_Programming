/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

/**
 *
 * @author araza
 */
public class Storage {
    
    HashMap<String, Product> stock;

    public Storage() {
        stock = new HashMap<>();
        stock.put("sun", new Product("Mission to the Sun", "GOLDEN YELLO idk bro im only guessing", 234));
        stock.put("mercury", new Product("Mission to Mercury", "DEEP GREY COLOR", 228.80));
        stock.put("venus", new Product("Mission to Venus", "LIGHT PINK", 252.20));
        stock.put("earth", new Product("Mission on Earth", "MATCHA GREEN", 215.80));
        stock.put("moon", new Product("Mission to the Moon", "STEEL GRAY", 221));
        stock.put("mars", new Product("Mission to Mars", "WATERMELON RED", 241.80));
        stock.put("jupiter", new Product("Mission to Jupiter", "MOCHA BROWN", 228.80));
        stock.put("saturn", new Product("Mission to Saturn", "BEIGE", 247));
        stock.put("uranus", new Product("Mission to Uranus", "PALE BLUE", 239.20));
        stock.put("neptune", new Product("Mission to Neptune", "FREEZING DEEP BLUE", 236.60));
        stock.put("pluto", new Product("Mission to Pluto", "GRAY AND BURGUNDY", 208));
    }

    public HashMap<String, Product> getStock() {
        return stock;
    }
}
