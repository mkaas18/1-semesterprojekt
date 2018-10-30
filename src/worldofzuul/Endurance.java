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
public class Endurance {
 
    public int endurance, enduranceIncrease, enduranceDecrease, enduranceMaximum;
 public Endurance(int endurance, int enduranceIncrease, int enduranceDecrease, int enduranceMaximum) {
        this.endurance = endurance; 
        this.enduranceIncrease = enduranceIncrease;
        this.enduranceDecrease= enduranceDecrease;
        this.enduranceMaximum = enduranceMaximum;     
    
    
}
  public int getEndurance(){//Lave getvalue til alle de andre a
        return endurance;
 
}

    public int getEnduranceIncrease() {
        return enduranceIncrease;
    }

    public int getEnduranceDecrease() {
        return enduranceDecrease;
    }

    public int getEnduranceMaximum() {
        return enduranceMaximum;
    }
  

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setEnduranceIncrease(int enduranceIncrease) {
        this.enduranceIncrease = enduranceIncrease;
    }

    public void setEnduranceDecrease(int enduranceDecrease) {
        this.enduranceDecrease = enduranceDecrease;
    }

    public void setEnduranceMaximum(int enduranceMaximum) {
        this.enduranceMaximum = enduranceMaximum;
    }
  
}

