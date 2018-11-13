package worldofzuul;

import java.util.ArrayList;

/*
Skal denne klasse bruges??
Ellers sletter vi den bare, synes nemlig vi skal fokuser på andre ting før vi adder "nice to have" ting.
*/

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
