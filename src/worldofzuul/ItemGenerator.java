package worldofzuul;

import java.util.ArrayList;

public class ItemGenerator {

    ArrayList<String> firstWord;
    ArrayList<String> middleWord;
    ArrayList<String> lastWord;

    public ItemGenerator() {
        this.firstWord = new ArrayList<>();
        this.middleWord = new ArrayList<>();
        this.lastWord = new ArrayList<>();

        firstWord.add("Sword");
        firstWord.add("Staff");
        firstWord.add("Club");
        firstWord.add("Dagger");
        firstWord.add("Spear");
        firstWord.add("Bow");
        firstWord.add("Book");
        firstWord.add("Scroll");
        firstWord.add("Fish");
        firstWord.add("Scepter");
        firstWord.add("Glasses");

        middleWord.add("of");

        lastWord.add("The Champion");
        lastWord.add("Math");
        lastWord.add("Addition");
        lastWord.add("Subtraction");
        lastWord.add("Division");
        lastWord.add("Multiplication");
        lastWord.add("The Mighty Dragonslayer");
        lastWord.add("The Nerd");
        lastWord.add("Stars");
        lastWord.add("Spirits");
    }

    public Item generateItem() {
        Item item = new Item();
        item.setName(generateName());
        Stats stats = generateStats();
        item.setStats(stats);
        return item;
    }

    private Stats generateStats() {
        return new Stats(generateStat(), generateStat(), generateStat(), generateStat());
    }

    private int generateStat() {
        return (int) Math.floor(Math.random() * 11);
    }

    private String generateName() {
        int i = (int) Math.floor(Math.random() * firstWord.size());
        int k = (int) Math.floor(Math.random() * lastWord.size());
        String name = (firstWord.get(i) + " " + middleWord.get(0) + " " + lastWord.get(k));
        return name;
    }
}
