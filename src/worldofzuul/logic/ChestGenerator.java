package worldofzuul.logic;

import java.util.ArrayList;

// Didnt have time to implement this.

public class ChestGenerator {

    ArrayList<Item> chestList = new ArrayList<>();

    public ChestGenerator() {
    }

    public ChestGenerator(Item item) {
        chestList.add(item);
    }

    public ArrayList<Item> getChestList() {
        return chestList;
    }

    public void setChestList(ArrayList<Item> chestList) {
        this.chestList = chestList;
    }
}
