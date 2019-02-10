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

public class ShoppingBasket {
    private Map<String, Purchase> basket;
    
    
    public ShoppingBasket() {
        basket = new HashMap <String, Purchase>();
    }
    
    public void add(String product, int price) {
         if(this.basket.containsKey(product)){
            this.basket.get(product).increaseAmount();
        }else{
            Purchase newItem = new Purchase(product, 1, price);
            this.basket.put(product, newItem);
        }
    }
    
     public int price(){
        int basketPrice = 0;
        for(Purchase purchase : this.basket.values()){
            basketPrice += purchase.price();
        }
        return basketPrice;
    }
     
      public void print(){
        for(Purchase purchase : this.basket.values()){
            System.out.println(purchase.toString());
        }
    }
      
}