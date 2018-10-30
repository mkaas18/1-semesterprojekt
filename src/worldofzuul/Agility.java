/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author Khadar
 */
public class Agility {
    
    
    
     public int agility, agilityIncrease, agilityDecrease, agilityMaximum;
     
     Agility(int agility, int agilityIncrease, int agilityDecrease, int agilityMaximum) {
        this.agility = agility; 
        this.agilityIncrease = agilityIncrease;
        this.agilityDecrease= agilityDecrease;
        this.agilityMaximum = agilityMaximum;     
    }
    public int getAgility(){//Lave getvalue til alle de andre a
        return agility;
    }
     public int getAgilityIncrease() {
        return agilityIncrease;
    }

    public int getAgilityDecrease() {
        return agilityDecrease;
    }

    public int getAgilityMaximum() {
        return agilityMaximum;
    }
    

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setAgilityIncrease(int agilityIncrease) {
        this.agilityIncrease = agilityIncrease;
    }

    public void setAgilityDecrease(int agilityDecrease) {
        this.agilityDecrease = agilityDecrease;
    }

    public void setAgilityMaximum(int agilityMaximum) {
        this.agilityMaximum = agilityMaximum;
    }

    
}
