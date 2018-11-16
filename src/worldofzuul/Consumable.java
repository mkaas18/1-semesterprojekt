package worldofzuul;

public class Consumable {

    private String name;
    private int healing = 30;

    public Consumable() {
        this.name = "Healing potion";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    @Override
    public String toString() {
        String toText = "Healing potion - heals for " + getHealing();
        return toText;
    }

}
