package worldofzuul.logic;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import worldofzuul.interfaces.IQuestionTimer;

public class QuestionTimer extends Thread implements IQuestionTimer {

    static int interval;
    static Timer timer;
    int s = 2;
    int timeLeft;
    int normalTime = 20;
    int maxTimeLeft;

    public QuestionTimer() {
    }

    @Override
    public void stopTimer() {
        timer.cancel();

    }

    @Override
    public void startTimer() {
        timeLeft = maxTimeLeft;
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = maxTimeLeft;
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                timeLeft = setInterval();
            }
        }, delay, period);
    }

    private static final int setInterval() {
        if (interval == 1) {
            timer.cancel();
        }
        return --interval;
    }

    @Override
    public int getTime() {
        return timeLeft;
    }

    @Override
    public Timer getTimer() {
        return timer;
    }
    @Override
    public void setTime(Player player){
        this.maxTimeLeft = (int) (normalTime + (player.getIntelligence() * 0.2));
    }

    public int getMaxTime() {
        return maxTimeLeft;
    }
}
