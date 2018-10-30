/*
 make le items le Mikkelo

 */
package worldofzuul;

/**
 *
 * @author Karla
 */
public class Player {
    private String name;
    
    
    // Jeg ved ikke om det skal være private fields eller måske public fields
    public int hp, hpDecrease, hpIncrease, maxHP;   
// Constructor for navnet på playeren
    public Player(String name){
        this.name = name;
    }
    // Vi laver ny klasse for hver stats. derfra henter vi statsne i den enkelte klasse.

public Player(int hp, int hpIncrease, int hpDecrease, int maxHP) {
        this.hp = hp; 
        this.hpIncrease = hpIncrease;
        this.hpDecrease= hpDecrease;
        this.maxHP = maxHP;     
    }
    
    public int getHP(){
        return hp;
    }

    public int getHpDecrease() {
        return hpDecrease;
    }

    public int getHpIncrease() {
        return hpIncrease;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setHpDecrease(int hpDecrease) {
        this.hpDecrease = hpDecrease;
    }

    public void setHpIncrease(int hpIncrease) {
        this.hpIncrease = hpIncrease;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    
    
}
    
    
    
    
    //Methods for øge og minke de forskellige variabler 
    // Ikke kommet dertil endnu lel
    // Og de forskellige ting, stats skal lave kunne ?? 
      
    
    
