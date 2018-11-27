/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.interfaces;

import javafx.collections.ObservableList;
import worldofzuul.logic.Consumable;
import worldofzuul.logic.Item;
import worldofzuul.logic.Player;

/**
 *
 * @author SteamyBlizzard
 */
public interface IShop {
    public ObservableList<IItem> getBuyableList();
    public ObservableList<IConsumable> getBuyableConsumeList();
    public void buyWare(Item item, Player player);
    public void buyConsumable(Consumable consumable, Player player);
    public void sellWare(Item item, Player player);
    public void sellConsumable(Consumable consumable, Player player);
    public boolean goldCheck(int value, Player player);
}
