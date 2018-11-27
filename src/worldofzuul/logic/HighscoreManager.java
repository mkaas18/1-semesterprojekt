package worldofzuul.logic;

import java.util.ArrayList;

public class HighscoreManager {

    private ArrayList<Highscore> scores;

    // The file where the Highscore will be saved
    private static final String HIGHSCORE_FILE = "scores.dat";

    public HighscoreManager(ArrayList<Highscore> scores) {
        this.scores = scores;
    }

    public HighscoreManager() {
        //initialising the scores-arraylist
        scores = new ArrayList<Highscore>();
    }

}
