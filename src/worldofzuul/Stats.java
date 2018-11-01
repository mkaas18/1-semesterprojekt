package worldofzuul;

import java.util.ArrayList;

public class Stats {

    ArrayList<Integer> randomInelligence = new ArrayList<>();
    ArrayList<Integer> randomEndurance = new ArrayList<>();
    ArrayList<Integer> randomStrength = new ArrayList<>();
    ArrayList<Integer> randomAgility = new ArrayList<>();

    private int intelligence = 0;
    private int endurance = 0;
    private int strength = 0;
    private int agility = 0;
    // andre?

    public Stats() {
    }

    public Stats(int intelligence, int endurance, int strength, int agility) {
        this.intelligence = intelligence;
        this.endurance = endurance;
        this.strength = strength;
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    @Override
    public String toString() {
        String statSummary = "Stats:";
        statSummary += "\n\tAgility: " + agility;
        statSummary += "\n\tStrength: " + strength;
        statSummary += "\n\tIntelligence: " + intelligence;
        statSummary += "\n\tEndurance: " + endurance;
        return statSummary;
    }

}
