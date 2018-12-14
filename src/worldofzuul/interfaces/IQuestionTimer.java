/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.interfaces;

import java.util.Timer;
import worldofzuul.logic.Player;

/**
 *
 * @author fredd
 */
public interface IQuestionTimer {
    public int getTime();
    public void startTimer();
    public void stopTimer();
    public Timer getTimer();
    public int getMaxTime();
    public void setTime(Player player);
}
