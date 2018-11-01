
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
    private int hp = maxHP;
    private int endurance = 0;
    private int strength = 0;
    private int agility = 0;
    private int intellect = 0;
    private int damagetaken = 0;
    private ArrayList<Item> inventory = new ArrayList<>();
    
    public Player(String name, int endurance, int strength, int agility, int intellect){
        this.name = name;
        this.endurance = endurance;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
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
    
    public int getHp(){
        return hp;
    }
    
    public void addHp(int hp){
        this.hp += hp;
    }
    public int damagetaken(){
        return this.damagetaken;
    }
    
    public int addDamagetaken(int amount){
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
      
    
    
