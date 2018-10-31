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
public class Strength {
    
    
    public int strength, strengthIncrease, strengthDecrease, strengthtMaximum;
    private final int strengthMaximum;
    public Strength(int strength, int strengthIncrease, int strengthDecrease, int strengthMaximum) {
        this.strength = strength; 
        this.strengthIncrease = strengthIncrease;
        this.strengthDecrease= strengthDecrease;
        this.strengthMaximum = strengthMaximum;     
    }
    public int getStrength(){//Lave getvalue til alle de andre a
        return strength;
    }
 public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setStrengthIncrease(int strengthIncrease) {
        this.strengthIncrease = strengthIncrease;
    }

    public void setStrengthDecrease(int strengthDecrease) {
        this.strengthDecrease = strengthDecrease;
    }

    public void setStrengthtMaximum(int strengthtMaximum) {
        this.strengthtMaximum = strengthtMaximum;
    }
    
    public int getStrengthIncrease() {
        return strengthIncrease;
    }

    public int getStrengthDecrease() {
        return strengthDecrease;
    }

    public int getStrengthtMaximum() {
        return strengthtMaximum;
    }

    public int getStrengthMaximum() {
        return strengthMaximum;
    }
    


}
