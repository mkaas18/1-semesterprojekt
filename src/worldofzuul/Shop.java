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
public class Shop {

    ArrayList<Item> buyable = new ArrayList<>();
    ItemGenerator itemGen = new ItemGenerator();
    Scanner input = new Scanner(System.in);

    Shop() {
        buyable.add(itemGen.generateItem(1));
        buyable.add(itemGen.generateItem(1));
        buyable.add(itemGen.generateItem(1));
    }

    public void startShop(Player player) {
        System.out.println("You have arrived at a shop!");
        int i = printWares();
        while (true) {
            String request = input.next();
            if (request.equals("quit")) {
                System.out.println("Thank you for shopping!");
                break;
            } else {
                try {
                    i = (Integer.parseInt(request) - 1);
                } catch (NumberFormatException e) {
                    System.out.println("What do you mean?");
                    continue;
                }
                try {
                    if (!buyable.get(i).getName().equals("Sold out!")) {
                        System.out.println("You bought " + buyable.get(i).getName());
                        player.pickupItem(buyable.get(i));
                        buyable.set(i, new Item("Sold out!"));
                        System.out.println("Thank you for your service. Anything else?");
                        boolean buyMore = false;
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
