package worldofzuul.logic;

/*
This class should read, write and sort the highsocre the player gets playing the game.
*/

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ObservableList<String> ObsHighscoreList = FXCollections.observableArrayList();

    public Highscore(String name) {
        this.name = name;
        this.score = 0;
        loadHighscoreList();
    }

    public int getScore() {
        return score;
    }

    // Calculate the score the player gets.
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

    // Reads the highscore arraylist
    @Override
    public String readHighscoreList() {
        String highscore = "";
        for (String highscoreString : highscoreList) {
            highscore += highscoreString + "\n";
        }
        return highscore;
    }

    // Read the highscore file and add the strings to an array and observerblelist.
    public void loadHighscoreList() {
        for (String highscoreString : fileR.readFile()) {
            highscoreList.add(highscoreString);
            String formattedHighscore = "";
            String[] splittedString = highscoreString.split(":");
            formattedHighscore = splittedString[0] + "\t" + splittedString[1];
            ObsHighscoreList.add(formattedHighscore);
        }
    }

    // Write the current highscore gets playing the game and write the hole list to the file.
    @Override
    public void writeHighscoreList() {
        highscoreList.add(this.toString());
        sort();
        fileW.writeFile(highscoreList);
    }

    // Sorts the highscore list
    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(highscoreList, comparator);
    }

    public ObservableList<String> getObsHighscoreList() {
        return ObsHighscoreList;
    }
}
