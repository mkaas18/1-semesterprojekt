package worldofzuul.interfaces;

import java.util.ArrayList;
import worldofzuul.logic.Highscore;

public interface IFileWriter {

    public void writeFile(String input);
    public void writeFile(ArrayList<String> highscoreList);
}

