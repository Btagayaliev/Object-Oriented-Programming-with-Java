/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bakhtovar
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Storehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;
    
    public Storehouse(){
        this.prices = new HashMap<String, Integer>();
        this.stocks = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stocks.put(product, stock);
    }
    
    public int price(String product) {
        for(String item : this.prices.keySet()){
            if(item.equals(product)){
                return this.prices.get(item);
            }
        }
        return -99;
    }
    
    public int stock(String product) {
        for(String item: this.stocks.keySet()) {
            if(item.equals(product)) {
                return this.stocks.get(item);
            }
        }
        
        return 0;
    }
    
    public boolean take(String product) {
        for(String item: this.stocks.keySet()) {
            if(item.equals(product)) {
                int stock = stock(item);
                if(stock > 0) {
                    this.stocks.put(item, this.stock(item) - 1);
                    return true;
                }
            }
        }
        return false;
    }
    
    public Set<String> products() {
        Set<String> products = new HashSet<String>();
        for(String s : this.prices.keySet()){
            products.add(s);
        }
        return products;
    }
}
