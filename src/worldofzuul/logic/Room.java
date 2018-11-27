package worldofzuul.logic;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Room {

    private final String description;
    private int difficulty;
    private final HashMap<String, Room> exits;
    private boolean isShop = false;
    private Shop shop;

    public Room(String description, int difficulty) {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.difficulty = difficulty;
    }

    public boolean isShop() {
        return isShop;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(boolean isShop) {
        this.isShop = isShop;
        shop = this.isShop ? new Shop(difficulty) : null;
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return "You are in the " + description + ".\n" + getExitString();
    }

    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    public Set<String> getExits(){
        return exits.keySet();
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
