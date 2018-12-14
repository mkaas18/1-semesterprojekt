package worldofzuul.logic;

/*
Sort the highscores, so the best highscore is highest on the list.
*/

import java.util.Comparator;

public class ScoreComparator implements Comparator<String> {

    @Override
    public int compare(String score1, String score2) {
        String[] array1 = score1.split(":");
        String[] array2 = score2.split(":");

        int sc1 = Integer.parseInt(array1[1]);
        int sc2 = Integer.parseInt(array2[1]);

        if (sc1 > sc2) {
            return -1;
        } else if (sc1 < sc2) {
            return +1;
        } else {
            return 0;
        }
    }
}
