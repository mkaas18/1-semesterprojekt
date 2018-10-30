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
public class Intellect {
    
    
    
    public int intellect, intellectIncrease, intellectDecrease, intellectMaximum;
    public Intellect(int intellect, int intellectIncrease, int intellectDecrease, int intellectMaximum) {
        this.intellect = intellect; 
        this.intellectIncrease = intellectIncrease;
        this.intellectDecrease= intellectDecrease;
        this.intellectMaximum = intellectMaximum;     
    }
    public int getIntellect(){//Lave getvalue til alle de andre a
        return intellect;
    }

    public int getIntellectIncrease() {
        return intellectIncrease;
    }

    public int getIntellectDecrease() {
        return intellectDecrease;
    }

    public int getIntellectMaximum() {
        return intellectMaximum;
    }
    

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void setIntellectIncrease(int intellectIncrease) {
        this.intellectIncrease = intellectIncrease;
    }

    public void setIntellectDecrease(int intellectDecrease) {
        this.intellectDecrease = intellectDecrease;
    }

    public void setIntellectMaximum(int intellectMaximum) {
        this.intellectMaximum = intellectMaximum;
    }
    
}
