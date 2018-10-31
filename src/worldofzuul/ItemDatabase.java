package worldofzuul;

import java.util.ArrayList;

public class ItemDatabase {

    ArrayList<Item> itemList = new ArrayList<>();

    public ItemDatabase() {
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

}
