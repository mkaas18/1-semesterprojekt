package worldofzuul.logic;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuestionTimer extends Thread {

    private int interval;
    static Timer timer;
    int s = 2;
    Player player;
    int normalTime = 21;

    public QuestionTimer(Player player) {
        this.player = player;

    }

    public void stopTimer() {
        timer.cancel();
    }

    public void run() {

        int delay = 1000;
        int period = 1000;
        
        interval = (int) (normalTime + (player.getIntelligence() * 0.2));
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());

            }
        }, delay, period);
    }

    private int setInterval() {
        if (interval == 1) {
            timer.cancel();
        }
        return --interval;
    }

    public int getInterval() {
        return this.interval;

    }
}
