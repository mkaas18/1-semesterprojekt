/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import worldofzuul.interfaces.IConsumable;
import worldofzuul.interfaces.IItem;
import worldofzuul.interfaces.IPlayer;
import worldofzuul.interfaces.IShop;
import worldofzuul.logic.Consumable;
import worldofzuul.logic.Item;
import worldofzuul.logic.Player;

/**
 *
 * @author SteamyBlizzard
 */
public class ShopWindow {

    IItem item;
    IConsumable consumable;
    IShop shop;
    IPlayer player;
    ChangeListener<IItem> waresListener;
    ChangeListener<IConsumable> consumableListener;

    public ShopWindow(IShop shop, IPlayer player) {
        this.shop = shop;
        this.player = player;
    }

    public void shopHandler(ListView waresList, ListView consumablesList, TextArea itemDescript) {
        waresList.setItems(shop.getBuyableList());
        waresList.getSelectionModel().selectedItemProperty().addListener(waresListener = new ChangeListener<IItem>() {
            @Override
            public void changed(ObservableValue<? extends IItem> observable, IItem oldValue, IItem newValue) {
                itemDescript.clear();
                if (!newValue.getName().equals("Sold out!")) {
                    itemDescript.appendText(newValue.getStats().toString());
                }
                item = newValue;
            }
        });
        consumablesList.setItems(shop.getBuyableConsumeList());
        consumablesList.getSelectionModel().selectedItemProperty().addListener(consumableListener = new ChangeListener<IConsumable>() {
            @Override
            public void changed(ObservableValue<? extends IConsumable> observable, IConsumable oldValue, IConsumable newValue) {
                itemDescript.clear();
                if (!newValue.getName().equals("Sold out!")) {
                    itemDescript.appendText(newValue.getDescription());
                }
                consumable = newValue;
            }
        });

    }

    public void stopShopHandler(ListView waresList, ListView consumablesList) {
        waresList.getSelectionModel().selectedItemProperty().removeListener(waresListener);
        consumablesList.getSelectionModel().selectedItemProperty().removeListener(consumableListener);
    }

    public void buyItem() {
        if (shop.goldCheck(item.getStats().getValue(), (Player) player)) {
            shop.buyWare((Item) item, (Player) player);
        }
    }

    public void buyConsumable() {
        if (shop.goldCheck(consumable.getValue(), (Player) player)) {
            shop.buyConsumable((Consumable) consumable, (Player) player);
        }
    }

    public void sellConsumable(InventoryWindow inventory) {
        shop.sellConsumable((Consumable) inventory.getSelectedConsumable(), (Player) player);
    }

    public void sellItem(InventoryWindow inventory) {
        shop.sellWare((Item) inventory.getSelectedItem(), (Player) player);
    }
}
