package worldofzuul.interfaces;

import worldofzuul.logic.Player;

public interface IHighscore {

    public void addScore(int score);

    public void setScore(Player p1);

    public void saveScore();

    public String getSavedScore();

}
