package worldofzuul.logic;


import java.util.ArrayList;
import java.util.Random;


public class Stats {

    private int intelligence = 0;
    private int endurance = 0;
    private int strength = 0;
    private int agility = 0;

    private int value = 0;

    public Stats() {
    }

    public Stats(int intelligence, int endurance, int strength, int agility, int value) {
        this.intelligence = intelligence;
        this.endurance = endurance;
        this.strength = strength;
        this.agility = agility;
        this.value = value;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

     public int getEndurance() {
        return (int) (endurance * 1.01);
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
        return (int) (agility * 1.01);
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String statSummary = "Stats:";
        statSummary += "\n\tAgility: " + agility;
        statSummary += "\n\tStrength: " + strength;
        statSummary += "\n\tIntelligence: " + intelligence;
        statSummary += "\n\tEndurance: " + endurance;
        statSummary += "\n\tValue: " + value;
        return statSummary;
    }

}
