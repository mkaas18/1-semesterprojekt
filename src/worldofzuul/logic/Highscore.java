package worldofzuul.logic;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import worldofzuul.interfaces.IFileReader;
import worldofzuul.interfaces.IFileWriter;
import worldofzuul.interfaces.IHighscore;
import worldofzuul.persistence.FileReader;
import worldofzuul.persistence.FileWriter;

public class Highscore implements Serializable, IHighscore {

    private int score;
    private String name;
    IFileWriter fileW = new FileWriter("highscore.txt");
    IFileReader fileR = new FileReader("highscore.txt");
    ArrayList<String> highscoreList = new ArrayList<String>();

    public Highscore(String name) {
        this.name = name;
        this.score = 0;
        loadHighscoreList();
    }

    public int getScore() {
        return score;
    }

    @Override
    public void setScore(Player player) {
        this.score = player.getKillCounter() * player.calculateStats();
    }

    public String getName() {
        return name;
    }

    public void setName(Player player) {
        this.name = player.getName();
    }

    @Override
    public String toString() {
        return getName() + ":" + getScore();
    }

    @Override
    public String readHighscoreList() {
        String highscore = "";
        for (String highscoreString : highscoreList) {
            highscore += highscoreString + "\n";
        }
        return highscore;
    }

    public void loadHighscoreList() {
        for (String highscoreString : fileR.readFile()) {
            highscoreList.add(highscoreString);
        }
    }

    @Override
    public void writeHighscoreList() {
        highscoreList.add(this.toString());
        sort();
        fileW.writeFile(highscoreList);
    }

    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(highscoreList, comparator);
    }
}
