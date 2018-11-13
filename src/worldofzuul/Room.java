package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    private final String description;
    private final HashMap<String, Room> exits;
    private boolean isShop = false;
    private Shop shop;

    public boolean isShop() {
        return isShop;
    }
    public Shop getShop(){
        return shop;
    }
    public void setShop(boolean isShop) {
        this.isShop = isShop;
        shop = this.isShop ? new Shop() : null;
    }

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    @Override
    public String toString(){
        return this.description;
    }
}

