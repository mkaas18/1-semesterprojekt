package worldofzuul.interfaces;

import worldofzuul.logic.Player;

public interface IHighscore {

    public void setScore(Player p1);

    public void writeHighscoreList();
    
    public String readHighscoreList();

}
