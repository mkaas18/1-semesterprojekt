/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.interfaces;

import javafx.collections.ObservableList;
import worldofzuul.logic.Consumable;
import worldofzuul.logic.Item;

/**
 *
 * @author SteamyBlizzard
 */
public interface IPlayer {
    public ObservableList<IItem> getInventory();
    public ObservableList<IConsumable> getPotInventory();
    public void addHp(int amount);
    public int getHp();
    public int getMaxHp();
    public void setMaxHp(int maxHp);
    public void pickupItem(Item item);
    public void dropItem(Item item);
    public int getGold();
    public void useHealing(Consumable pot);
    public void setKillCounter();
    public void setGold(int difficulty);
}
