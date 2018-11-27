package worldofzuul.logic;

import java.io.File;
import java.io.Serializable;
import worldofzuul.interfaces.IFileReader;
import worldofzuul.interfaces.IFileWriter;
import worldofzuul.interfaces.IHighscore;
import worldofzuul.persistence.FileReader;
import worldofzuul.persistence.FileWriter;

public class Highscore implements Serializable, IHighscore {

    private int score;
    private String name;
    IFileWriter fw = new FileWriter("highscore.txt");
    IFileReader fr = new FileReader("highscore.txt");

    public Highscore(String name) {
        this.name = name;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void setScore(Player p1) {
        this.score = p1.getKillCounter() * p1.getQuestionsCorrectAnswered();
    }

    public String getName() {
        return name;
    }

    public void setName(Player p1) {
        this.name = p1.getName();
    }

    @Override
    public String toString() {
        return getName() + " " + getScore();
    }

    @Override
    public void saveScore() {
        fw.writeFile(this);
    }
    
    @Override
    public void addScore(int score) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSavedScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
