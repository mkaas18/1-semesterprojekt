
/*
 make le items le Mikkelo

 */


package worldofzuul;

import java.util.ArrayList;

public class Player {

    private String name;
    private int maxHP = 100;
    private int damagetaken = 0;
    private Stats stats;
    private ArrayList<Item> inventory = new ArrayList(5);

    public Player(String name, int maxHP, int damagetaken) {
        this.name = name;
        this.maxHP = maxHP;
        this.stats = new Stats();
        this.damagetaken = damagetaken;
    }

    public String getName(String name) {
        return this.name;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public void addmaxHP(int amount) {
        this.maxHP += amount;
    }

    public int damagetaken() {
        return this.damagetaken;
    }

    public int adddamagetaken(int amount) {
        return this.maxHP -= amount;

    }

    public int getEndurance() {
        return this.stats.getEndurance();
    }

    public void addEndurance(int amount) {
        this.stats.setEndurance(this.stats.getEndurance() + amount);
    }

    public int getStrength() {
        return this.stats.getStrength();
    }

    public void addStrength(int amount) {
        this.stats.setStrength(this.stats.getStrength() + amount);
    }

    public int getAgility() {
        return this.stats.getAgility();
    }

    public void addAgility(int amount) {
        this.stats.setAgility(this.stats.getAgility() + amount);
    }

    public int getIntelligence() {
        return this.stats.getIntelligence();
    }

    public void addIntelligence(int amount) {
        this.stats.setIntelligence(this.stats.getIntelligence() + amount);
    }
    @Override
    public String toString() {
        String statSummary = "Stats:";
        statSummary += "\n\tHP: " + getMaxHP();
        statSummary += "\n\tAgility: " + getAgility();
        statSummary += "\n\tStrength: " + getStrength();
        statSummary += "\n\tIntelligence: " + getIntelligence();
        statSummary += "\n\tEndurance: " + getEndurance();
        return statSummary;
    }
    
     public void pickupItem(Item item) {
        inventory.add(item);
        addAgility(item.getStats().getAgility());
        addStrength(item.getStats().getStrength());
        addIntelligence(item.getStats().getIntelligence());
        addEndurance(item.getStats().getEndurance());
    }
    
    public void dropItem(Item item) {
        inventory.remove(item);
        addAgility(-item.getStats().getAgility());
        addStrength(-item.getStats().getStrength());
        addIntelligence(-item.getStats().getIntelligence());
        addEndurance(-item.getStats().getEndurance());
    }

}

//Methods for øge og minke de forskellige variabler 
// Ikke kommet dertil endnu lel
// Og de forskellige ting, stats skal lave kunne ?? 

