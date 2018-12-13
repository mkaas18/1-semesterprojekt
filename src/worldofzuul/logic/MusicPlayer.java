/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.logic;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author Karla
 */
public class MusicPlayer {
    
     public void playMusic (String musicLocation){
        
        try{
            File musicPath = new File(musicLocation);
            
            if(musicPath.exists()){
               AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
               Clip clip = AudioSystem.getClip();
               clip.open(audioInput);
               clip.start();
               clip.loop(Clip.LOOP_CONTINUOUSLY);
               
          
            }
            else{
                System.out.println("can't find file");
            }
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}

