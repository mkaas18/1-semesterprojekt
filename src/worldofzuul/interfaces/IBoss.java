/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.interfaces;

import worldofzuul.logic.Player;
import worldofzuul.logic.QuestionResults;

/**
 *
 * @author fredd
 */
public interface IBoss {
    public QuestionResults questionPicker();
    public String answerChecker(QuestionResults results, double input, Player player);
    public int getMAX_HP();
    public int getHp();
    public String getBossName();
}
