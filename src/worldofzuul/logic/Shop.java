/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.logic;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import worldofzuul.interfaces.IConsumable;
import worldofzuul.interfaces.IItem;
import worldofzuul.interfaces.IShop;

/**
 *
 * @author fredd
 */
public class Shop implements IShop {

    ObservableList<IItem> buyable = FXCollections.observableArrayList();
    ObservableList<IConsumable> buyableConsumable = FXCollections.observableArrayList();
    ItemGenerator itemGen = new ItemGenerator();
    Scanner input = new Scanner(System.in);
    String output;

    Shop(int difficulty) {
        buyable.add(itemGen.generateItem(difficulty));
        buyable.add(itemGen.generateItem(difficulty));
        buyable.add(itemGen.generateItem(difficulty));
        buyableConsumable.add(new Consumable(30));
        buyableConsumable.add(new Consumable(30));
        buyableConsumable.add(new Consumable(30));
    }

    @Override
    public ObservableList<IItem> getBuyableList() {
        return buyable;
    }

    @Override
    public ObservableList<IConsumable> getBuyableConsumeList() {
        return buyableConsumable;
    }

//    public void startShop(Player player) {
//        output = "You have arrived at a shop!";
//        int i;
//        output = "\n" + printWares();
//        System.out.println(output);
//        while (true) {
//            String request = input.next();
//            if (request.equals("quit")) {
//                System.out.println("Thank you for shopping!");
//                break;
//            } else {
//                try {
//                    i = (Integer.parseInt(request) - 1);
//                } catch (NumberFormatException e) {
//                    System.out.println("What do you mean?");
//                    continue;
//                }
//                try {
//                    if (!buyable.get(i).getName().equals("Sold out!")) {
//                        System.out.println("You bought " + buyable.get(i).getName());
////                        player.pickupItem(buyable.get(i));
//                        buyable.set(i, new Item("Sold out!"));
//                        System.out.println("Thank you for your service. Anything else?");
//                        boolean buyMore = false;
//                        while (true) {
//                            request = input.next();
//                            if (request.toLowerCase().equals("yes")) {
//                                System.out.println(printWares());
//                                break;
//                            } else if (request.toLowerCase().equals("no")) {
//                                buyMore = true;
//                                break;
//                            } else {
//                                System.out.println("Dont understand what you mean");
//                            }
//                        }
//                        if (buyMore) {
//                            break;
//                        }
//                    } else {
//                        System.out.println("Item is sold out!");
//                    }
//                } catch (IndexOutOfBoundsException e) {
//                    System.out.println("Dont have such item!");
//                }
//            }
//
//        }
//        System.out.println("Thank you for your patronage!");
//    }
//
//    public String printWares() {
//        output = "";
//        int i = 1;
//        for (IItem item : buyable) {
//            if (!item.getName().equals("Sold out!")) {
//                output += item.getStats();
//            } else {
//                output += item.getName() + "\n";
//            }
//            i++;
//        }
//        output += "Please choose an item based on their numbering";
//        return output;
//    }
    @Override
    public void buyWare(Item item, Player player) {
        if (!item.getName().equals("Sold out!")) {
            player.pickupItem(item);
            player.setGold(player.getGold() - item.getStats().getValue());
            buyable.set(buyable.indexOf(item), new Item("Sold out!"));

        }

    }

    @Override
    public void buyConsumable(Consumable consumable, Player player) {
        if (!consumable.getName().equals("Sold out!")) {
            player.pickupPot(consumable);
            player.setGold(player.getGold() - consumable.getValue());
            buyableConsumable.set(buyableConsumable.indexOf(consumable), new Consumable("Sold out!"));
        }

    }

    public boolean goldCheck(int value, Player player) {
        return value <= player.getGold();
    }

    @Override
    public void sellWare(Item item, Player player) {
        player.dropItem(item);
        player.setGold(player.getGold() + (int) (item.getStats().getValue() / 1.5));
    }

    @Override
    public void sellConsumable(Consumable consumable, Player player) {
        player.dropPot(consumable);
        player.setGold(player.getGold() + (int) (consumable.getValue() / 1.5));
        System.out.println(player.getGold());
    }
}
