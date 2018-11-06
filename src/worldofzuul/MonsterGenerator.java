package worldofzuul;

import java.util.ArrayList;

public class MonsterGenerator {

    ArrayList<String> firstWord;
    ArrayList<String> middleWord;
    ArrayList<String> lastWord;
/*    ArrayList<String> bossWord;
    ArrayList<String> bossWordtwo;
    */

    public MonsterGenerator() {
        this.firstWord = new ArrayList<>();
        this.middleWord = new ArrayList<>();
        this.lastWord = new ArrayList<>();
        /*
        this.bossWord = new ArrayList<>();
        this.bossWordtwo = new ArrayList<>();
*/

        firstWord.add("Orc");
        firstWord.add("Undead");
        firstWord.add("Troll");
        firstWord.add("Leper Gnome");
        firstWord.add("Giant");
        firstWord.add("Wolf");
        firstWord.add("Gnome");
        firstWord.add("Thief");
        firstWord.add("Bandit");
        /*
        bossWord.add("King");
        bossWord.add("Queen");
*/

        middleWord.add("of");

        lastWord.add("Mordor");
        lastWord.add("the Shire");
        lastWord.add("Elwynn Forest");
        lastWord.add("the Blasted Lands");
        lastWord.add("Math");
        lastWord.add("the Dragons");
        lastWord.add("the Windseers");
        
        /*
        bossWordtwo.add("of the Andees");
        bossWordtwo.add("of England");
*/
    }


    
    public String generateMonster() {
        int i = (int) Math.floor(Math.random() * firstWord.size());
        int k = (int) Math.floor(Math.random() * lastWord.size());
        String name = (firstWord.get(i) + " " + middleWord.get(0) + " " + lastWord.get(k));
        return name;
    }
}