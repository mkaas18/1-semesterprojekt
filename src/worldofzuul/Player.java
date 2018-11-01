
/*
 make le items le Mikkelo

 */
package worldofzuul;

import java.util.ArrayList;

/**
 *
 * @author Karla
 */
public class Player {
    private String name;
    private int maxHP = 100;
    private int endurance = 0;
    private int strength = 0;
    private int agility = 0;
    private int intellect = 0;
    private int damagetaken = 0;
    private ArrayList inventory;
    
    public Player(String name, int maxHP, int endurance, int strength, int agility, int intellect, int damagetaken){
        this.name = name;
        this.maxHP = maxHP;
        this.endurance = endurance;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.damagetaken = damagetaken;
    }
    public String getName(String name){
    return this.name;
    }

    public int getMaxHP(){
    return this.maxHP;
    }

    public void addmaxHP(int amount){
    this.maxHP += amount;
    }
    public int damagetaken(){
        return this.damagetaken;
    }
    
    public int adddamagetaken(int amount){
        return this.maxHP -= amount;
    
    }
    public int getEndurance(){
    return this.endurance;
    }

    public void addEndurance(int amount){
    this.endurance += amount;
    }
    public int getStrength(){
    return this.strength;
    }

    public void strength(int amount){
    this.strength += amount;
    }
    public int getAgility(){
    return this.agility;
    }

    public void addAgility(int amount){
    this.agility += amount;
    }
    public int getIntellect(){
    return this.intellect;
    }

    public void addIntellect(int amount){
    this.intellect += amount;
    }
    }
    
  
    
    
    
    
    //Methods for øge og minke de forskellige variabler 
    // Ikke kommet dertil endnu lel
    // Og de forskellige ting, stats skal lave kunne ?? 
      
    
    
