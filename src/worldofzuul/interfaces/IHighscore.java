package worldofzuul.interfaces;

import javafx.collections.ObservableList;
import worldofzuul.logic.Player;

public interface IHighscore {

    public void setScore(Player p1);

    public void writeHighscoreList();
    
    public String readHighscoreList();
    
    public void setName(Player player);
    
    public ObservableList<String> getObsHighscoreList();

}
