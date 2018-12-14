
package worldofzuul.logic;

import worldofzuul.interfaces.IConsumable;


/*
This class makes comsumable(healing potions).
It should heal the player when the player uses them.
*/

public class Consumable implements IConsumable{
    
    private String name;
    private int healing;
    private int value;

    public Consumable(int healing) {
        this.healing = healing;
        this.name = "Healing potion";
        this.value = 30;
    }
    public Consumable(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }
    
    @Override
    public String getDescription(){
        String toText = "Healing potion:\n\theals for " + getHealing();
        return toText;
    }
    @Override
    public String toString() {
        return this.name;
    }
    

}
