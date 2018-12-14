package worldofzuul.logic;

import java.util.ArrayList;
import worldofzuul.interfaces.IMonsterGenerator;

public class MonsterGenerator implements IMonsterGenerator{

    ArrayList<String> firstWord;
    ArrayList<String> middleWord;
    ArrayList<String> lastWord;
    ArrayList<String> bossWord;
    ArrayList<String> bossWordtwo;

    public MonsterGenerator(){
        this.firstWord = new ArrayList<>();
        this.middleWord = new ArrayList<>();
        this.lastWord = new ArrayList<>();
        this.bossWord = new ArrayList<>();
        this.bossWordtwo = new ArrayList<>();

        firstWord.add("Orc");
        firstWord.add("Troll");
        firstWord.add("Leper Gnome");
        firstWord.add("Giant");
        firstWord.add("Goblin");

        bossWord.add("King");

        middleWord.add("of");

        lastWord.add("Mordor");
        lastWord.add("the Shire");
        lastWord.add("Elwynn Forest");
        lastWord.add("the Blasted Lands");
        lastWord.add("Math");
        lastWord.add("the Dragons");
        lastWord.add("the Windseers");

        bossWordtwo.add("the Andees");
        bossWordtwo.add("the Mountains");
        bossWordtwo.add("the E-tivitet");
        bossWordtwo.add("Southern university of Denmark");
    }

    @Override
    public Monster generateMonster(int difficulty) {
        Monster monster = new Monster(generateMonsterName(), difficulty);
        monster.setName(generateMonsterName());
        return monster;
    }

    public Monster generateBoss() {
        Monster boss = new Monster(generateBossName(), 4);
        boss.setName(generateBossName());
        return boss;
    }

    public String generateMonsterName() {
        int i = (int) Math.floor(Math.random() * firstWord.size());
        int k = (int) Math.floor(Math.random() * lastWord.size());
        String name = (firstWord.get(i) + " " + middleWord.get(0) + " " + lastWord.get(k));
        return name;
    }

    public String generateBossName() {
        int i = (int) Math.floor(Math.random() * bossWord.size());
        int k = (int) Math.floor(Math.random() * bossWordtwo.size());
        String name = (bossWord.get(i) + " " + middleWord.get(0) + " " + bossWordtwo.get(k));
        return name;
    }
}
