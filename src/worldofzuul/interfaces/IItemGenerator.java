/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.interfaces;

import worldofzuul.logic.Item;

/**
 *
 * @author SteamyBlizzard
 */
public interface IItemGenerator {
    public Item generateItem(int difficulty);
}
