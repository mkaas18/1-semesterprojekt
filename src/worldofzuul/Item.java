package worldofzuul;

public class Item {

    /*
    Kunne man lave et HashMap for hvert item? Så det har et name som key, value er en description?
     */
    private String itemName;
    private String itemDescription;
    private Stats stats;

    public Item() {
    }

    public Item(String itemName, Stats stats) {
        this.itemName = itemName;
        this.stats = stats;
    }

    public Item(String itemName, Stats stats, String itemDescription) {
        this.itemName = itemName;
        this.stats = stats;
        this.itemDescription = itemDescription;
    }

    public String getName() {
        return itemName;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

}
