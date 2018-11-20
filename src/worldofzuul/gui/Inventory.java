/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import worldofzuul.interfaces.IItem;
import worldofzuul.interfaces.IPlayer;
import worldofzuul.logic.Item;

/**
 *
 * @author SteamyBlizzard
 */
public class Inventory {
    IItem item;
    IPlayer player;
   
    public Inventory(IPlayer player){
        this.player = player;
    }
//    public ObservableList<IItem> getInventory(){
//        for(Item item : player.getInventory()){
//            
//        }
//        return contacts;
//    }
}
