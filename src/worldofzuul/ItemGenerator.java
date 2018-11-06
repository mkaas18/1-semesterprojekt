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
        firstWord.add("Pen");
        firstWord.add("Crown");

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
        lastWord.add("Sparta");
        lastWord.add("Zeus");
        lastWord.add("The Teacher");
    }

    public Item generateItem(int difficulty) {
        Item item = new Item();
        item.setName(generateName());
        Stats stats = generateStats(difficulty);
        item.setStats(stats);
        return item;
    }

    private Stats generateStats(int difficulty) {
        return new Stats(generateStat(difficulty), generateStat(difficulty), generateStat(difficulty), generateStat(difficulty), generateValue(difficulty));
    }

    private int generateStat(int difficulty) {
        return (int) Math.floor(Math.random() * 11) * difficulty;
    }

    private int generateValue(int diffculty) {
        return (int) Math.floor(Math.random() * 101) * diffculty;
    }

    private String generateName() {
        int i = (int) Math.floor(Math.random() * firstWord.size());
        int k = (int) Math.floor(Math.random() * lastWord.size());
        String name = (firstWord.get(i) + " " + middleWord.get(0) + " " + lastWord.get(k));
        return name;
    }
}
