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
import javafx.scene.layout.Pane;
import worldofzuul.interfaces.IConsumable;
import worldofzuul.interfaces.IItem;
import worldofzuul.interfaces.IItemGenerator;
import worldofzuul.interfaces.IPlayer;
import worldofzuul.logic.Consumable;
import worldofzuul.logic.Item;
import worldofzuul.logic.ItemGenerator;

/**
 *
 * @author SteamyBlizzard
 */
public class InventoryWindow {

    IItem selectedItem;
    IItemGenerator itemGenerator = new ItemGenerator();
    IConsumable selectedConsumable;
    IPlayer player;

    public InventoryWindow(IPlayer player) {
        this.player = player;
    }

    public void inventoryHandler(ListView playerItemList, ListView playerConsumeList, TextArea itemDescript) {
        playerItemList.setItems(player.getInventory());
        playerItemList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<IItem>() {
            @Override
            public void changed(ObservableValue<? extends IItem> observable, IItem oldValue, IItem newValue) {
                itemDescript.clear();
                if (newValue != null) {
                    itemDescript.appendText(newValue.getStats().toString());
                }

                selectedItem = newValue;
            }
        });
        playerConsumeList.setItems(player.getPotInventory());
        playerConsumeList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<IConsumable>() {
            @Override
            public void changed(ObservableValue<? extends IConsumable> observable, IConsumable oldValue, IConsumable newValue) {
                itemDescript.clear();
                if (newValue != null) {
                    itemDescript.appendText(newValue.getDescription());
                }
                selectedConsumable = newValue;
            }
        });
    }
    public void useConsumable(){
        player.useHealing((Consumable)selectedConsumable);
    }
    public void removeItem() {
        player.dropItem((Item) selectedItem);
    }

    public IItem getSelectedItem() {
        return selectedItem;
    }

    public IConsumable getSelectedConsumable() {
        return selectedConsumable;
    }

    public void addItem() {
        player.pickupItem(itemGenerator.generateItem(1));
    }

   

}
