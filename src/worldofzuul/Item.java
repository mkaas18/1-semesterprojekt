package worldofzuul;

public class Item {

    /*
    Kunne man lave et HashMap for hvert item? Så det har et name som key, value er en description?
     */
    private String itemName;
    private String itemDescription;

    public Item() {
    }

    public Item(String itemName, int intelligence, int endurance, int strenght, int agility) {
        this.itemName = itemName;
        /* 
        Some code that add intelligence to the current player's stats // player.class.stats. += intelligence
        Some code that add endurance to the current player's stats // player.class.stats. += endurance
        Some code that add strenght to the current player's stats // player.class.stats. += strength
        Some code that add agility to the current player's stats // player.class.stats. += agility
        */
    }

    public String getName() {
        return itemName;
    }

    // Ved ikke 
    public void setName(String itemName) {
        this.itemName = itemName;
    }

}
