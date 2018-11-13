<<<<<<< HEAD

/*
 make le items le Mikkelo

 */


package worldofzuul;

public class Player {

    private String name;
    private int maxHP = 100;
    private int damagetaken = 0;
    private Stats stats;

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

    public void strength(int amount) {
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

}

//Methods for øge og minke de forskellige variabler 
// Ikke kommet dertil endnu lel
// Og de forskellige ting, stats skal lave kunne ?? 

=======
package worldofzuul;

import java.util.ArrayList;

public class Player {

    private String name;
    private int HP = 100;
    private Stats stats;
    private ArrayList<Item> inventory = new ArrayList(5);
    private ArrayList<Consumable> potInventory = new ArrayList(10);

    public Player(String name) {
        this.name = name;
        this.stats = new Stats();
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.HP;
    }

    public void addHP(int amount) {
        this.HP += amount;
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

    public void getInventory() {
        if (inventory.isEmpty()) {
            System.out.println("You haven't collected any items yet, go defeat math monster to get some");
        } else {
            for (Item item : inventory) {
                System.out.print(inventory.indexOf(item));
                System.out.println(" " + item);
                System.out.println(item.getStats());
            }
        }
        if (potInventory.isEmpty()) {
            System.out.println("You have 0 healing potions");
        } else {
            for (Consumable pot : potInventory) {
                System.out.println("You have " + potInventory.size() + " healing potions");
            }
        }
    }

    public ArrayList<Consumable> getPotInventory() {
        return potInventory;
    }

    @Override
    public String toString() {
        String statSummary = getName() + "'s Stats:";
        statSummary += "\n\tHealth: " + getHP();
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

    public void pickupPot(Consumable healingPot) {
        potInventory.add(healingPot);
    }

    public void dropItem(Item item) {
        inventory.remove(item);
        addAgility(-item.getStats().getAgility());
        addStrength(-item.getStats().getStrength());
        addIntelligence(-item.getStats().getIntelligence());
        addEndurance(-item.getStats().getEndurance());
    }

    public void useHealing() {
        addHP(getPotInventory().get(0).getHealing());
        System.out.println("You healed for 30 Hp");
        System.out.println("Your current health is: " + getHP());
        getPotInventory().remove(0);
    }

}
>>>>>>> origin/Items
