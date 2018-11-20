/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.interfaces;

import worldofzuul.logic.Item;
import worldofzuul.logic.Player;
import worldofzuul.logic.Room;

/**
 *
 * @author SteamyBlizzard
 */
public interface IGame {
    public String printWelcome();
    public String printHelp();
    public String goRoom(String direction);
    public Room getCurrentRoom();
    public Player getPlayer();
    public Item giveItem();
}
