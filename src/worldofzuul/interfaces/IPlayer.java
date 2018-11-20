/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.interfaces;

import javafx.collections.ObservableList;
import worldofzuul.logic.Item;

/**
 *
 * @author SteamyBlizzard
 */
public interface IPlayer {
    public ObservableList<Item> getInventory();
    public void addHP(int amount);
    public int getHP();
    public void pickupItem(Item item);
}
