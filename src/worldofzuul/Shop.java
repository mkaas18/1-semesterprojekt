/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author fredd
 */
//This class controls the shop
public class Shop {

    ArrayList<Item> buyable = new ArrayList<>();
    ItemGenerator itemGen = new ItemGenerator();
    Scanner input = new Scanner(System.in);
    //When the shop is instantialized, three random items is added to the buyable list
    Shop() {
        buyable.add(itemGen.generateItem(1));
        buyable.add(itemGen.generateItem(1));
        buyable.add(itemGen.generateItem(1));
    }
    //This method handles the shop. It takes the player object so it can add the items the player buy to its inventory
    public void startShop(Player player) {
        System.out.println("You have arrived at a shop!");
        //Prints out the wares in the shop
        int i = printWares();
        //This while loop keeps the shop open, until the player types quit
        while (true) {
            String request = input.next();
            if (request.equals("quit")) {
                System.out.println("Thank you for shopping!");
                break;
            } else {
                try {
                    //Tries to parse a integer from the string. If unsuccessful, prints out an error message,
                    //and continues the loop
                    i = (Integer.parseInt(request) - 1);
                } catch (NumberFormatException e) {
                    System.out.println("What do you mean?");
                    continue;
                }
                //If the parse is successful, it checks that the int is within the bounds of the buyable list
                try {
                    //Checks if the item is itemslot is equal to the special "sold out" item. If not, buy the item in that slot.
                    if (!buyable.get(i).getName().equals("Sold out!")) {
                        System.out.println("You bought " + buyable.get(i).getName());
                        //The item is added to the players inventory
                        player.pickupItem(buyable.get(i));
                        //Changes the item in that array index to a special instance of Item, that only has a name
                        //This special item instance is checked for each time to check if the item that was on this spot
                        //is sold out.
                        buyable.set(i, new Item("Sold out!"));
                        System.out.println("Thank you for your service. Anything else?");
                        boolean buyMore = false;
                        //A while loop that asks the player if they want to buy more
                        //The while loop is broken either way, but if the player says no, buyMore is set to true, 
                        //which breaks the outer while loop and shuts down the method.
                        while (true) {
                            request = input.next();
                            if (request.toLowerCase().equals("yes")) {
                                printWares();
                                break;
                            } else if (request.toLowerCase().equals("no")) {
                                buyMore = true;
                                break;
                            } else {
                                System.out.println("Dont understand what you mean");
                            }
                        }
                        if (buyMore) {
                            break;
                        }
                    } else {
                        System.out.println("Item is sold out!");
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Dont have such item!");
                }
            }

        }
        System.out.println("Thank you for your patronage!");
    }
    //This prints the items, the shop has to offer. Just as the RandomEvents method
    //each item has a corresponding index, of which the player must type in to buy.
    public int printWares() {
        int i = 1;
        for (Item item : buyable) {
            if (!item.getName().equals("Sold out!")) {
                System.out.println(item.getName() + "(" + i + ")");
            } else {
                System.out.println(item.getName());
            }
            i++;

        }
        System.out.println("Please choose an item based on their numbering");
        return i;
    }
}
