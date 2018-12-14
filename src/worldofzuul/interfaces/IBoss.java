package worldofzuul.interfaces;

import worldofzuul.logic.Player;
import worldofzuul.logic.QuestionResults;

public interface IBoss {

    public QuestionResults questionPicker();

    public String answerChecker(QuestionResults results, double input, Player player);

    public int getMAX_HP();

    public int getHp();

    public String getBossName();
}
