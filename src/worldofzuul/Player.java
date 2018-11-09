package worldofzuul;

import java.util.ArrayList;

public class Player {

    private String name;
    private int HP = 100;
    private Stats stats;
    private ArrayList<Item> inventory = new ArrayList(5);

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
        for (Item item : inventory) {
            System.out.print(inventory.indexOf(item));
            System.out.println(" " + item);
            System.out.println(item.getStats());
        }
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

    public void dropItem(Item item) {
        inventory.remove(item);
        addAgility(-item.getStats().getAgility());
        addStrength(-item.getStats().getStrength());
        addIntelligence(-item.getStats().getIntelligence());
        addEndurance(-item.getStats().getEndurance());
    }
}
