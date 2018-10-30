/*
 make le items le Mikkelo

 */
package Player;

/**
 *
 * @author Karla
 */
public class Player {
    private String name;
    
    
    // Jeg ved ikke om det skal være private fields eller måske public fields
    public int hp, hpDecrease, hpIncrease, maxHP;
    
    public int intellect, intellectIncrease, intellectDecrease, intellectMaximum;
    
    public int endurance, enduranceIncrease, enduranceDecrease, enduranceMaximum;
    
    public int strength, strengthIncrease, strengthDecrease, strengthtMaximum;
    
    public int agility, agiliyIncrease, agilityIncrease, agilityMaximum;
  
    // Constructor for navnet på playeren
    public Player(String name){
        this.name = name;
    }
    // klasser til de forskellige stats 
    class HealthPoints(int hp, int hpIncrease, int hpDecrease, int maxHP) {
        this.hp = hp; 
        this.hpIncrease = hpIncrease;
        this.hpDecrease= hpDecrease;
        this.maxHP = maxHP;     
    }
    
    public int getHP(){
        return hp;
    }
    class Intellect(int intellect, int intellectIncrease, int intellectDecrease, int intellectMaximum) {
        this.intellect = intellect; 
        this.intellectIncrease = intellectIncrease;
        this.intellectDecrease= intellectDecrease;
        this.intellectMaximum = intellectMaximum;     
    }
    public int getIntellect(){//Lave getvalue til alle de andre a
        return intellect;
    }
    class Endurance(int endurance, int enduranceIncrease, int enduranceDecrease, int enduranceMaximum) {
        this.endurance = endurance; 
        this.enduranceIncrease = enduranceIncrease;
        this.enduranceDecrease= enduranceDecrease;
        this.enduranceMaximum = enduranceMaximum;     
    }
    public int getEndurance(){//Lave getvalue til alle de andre a
        return endurance;
    }
    class Strength(int strength, int strengthIncrease, int strengthDecrease, int strengthMaximum) {
        this.strength = strength; 
        this.strengthIncrease = strengthIncrease;
        this.strengthDecrease= strengthDecrease;
        this.strengthMaximum = strengthMaximum;     
    }
    public int getStrength(){//Lave getvalue til alle de andre a
        return strength;
    }
    class Agility(int agility, int agilityIncrease, int agilityDecrease, int agilityMaximum) {
        this.agility = agility; 
        this.agilityIncrease = agilityIncrease;
        this.agilityDecrease= agilityDecrease;
        this.agilityMaximum = agilityhMaximum;     
    }
    public int getAgility(){//Lave getvalue til alle de andre a
        return agility;
    }
}
    
    
    
    
    //Methods for øge og minke de forskellige variabler 
    // Ikke kommet dertil endnu lel
    // Og de forskellige ting, stats skal lave kunne ?? 
      
    
    
