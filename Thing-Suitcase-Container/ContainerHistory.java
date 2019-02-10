/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Bakhtovar
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerHistory {
    private List<Double> history;
    
    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        this.history.add(situation);
    }
    
    public void reset() {
        this.history.clear();
    }
    
    public double maxValue() {
        return Collections.max(this.history);
    }
    
    public double minValue() {
        return Collections.min(this.history);
    }
    
    public double average() {
        double total = 0;
        for (Double element : this.history) {
            total += element;
        }
        return total / this.history.size();
    }
    
    public double greatestFluctuation() {
        double maxFluctuation = 0;
        
        for (int i = 0; i < this.history.size()-1; i++) {
            double current = this.history.get(i) - this.history.get(i+1);
            current = Math.abs(current);
            
            if (current > maxFluctuation) {
                maxFluctuation = current;
            }
        }
        return maxFluctuation;
    }
    
    public double variance() {
        Double temp = 0.0;
        Double average = this.average();
        
        for (Double element : this.history) {
            temp += Math.pow(element - average, 2);
        }
        return temp / (this.history.size() - 1);
    }
    
    @Override
    public String toString() {
        return this.history.toString();
    }
}
