package worldofzuul.gui;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


/**
 *
 * @author magnuskaas
 */

public class MovementAnimation{
    TranslateTransition tt;
    public void MovementAnimation(Circle player, ImageView sprite){
        tt = new TranslateTransition(Duration.millis(60), sprite);
        tt.setByY(5f);
        tt.setCycleCount(Timeline.INDEFINITE);
        tt.setAutoReverse(true);
    }
    
    public void AnimationStart(){
        tt.play();
    }
    
    public void AnimationStop(){
        tt.pause();
    }
    
}
