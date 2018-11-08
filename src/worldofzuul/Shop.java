/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fredd
 */
public class Shop {
    ArrayList<Item> buyable;
    ItemGenerator itemGen;
    Item dummyItem = new Item();
    Scanner input = new Scanner(System.in);
    
    Shop(){
        buyable.add(itemGen.generateItem(1));
        buyable.add(itemGen.generateItem(1));
        buyable.add(itemGen.generateItem(1));
    }
    
    public void startShop(Player player){
        System.out.println("You have arrived at a shop\n"
                + "Would you like to take a look?\nYes/No");
        while(true){
            if(input.next().toLowerCase().equals("yes")){
                System.out.println("Feel free to browse!");
                while(true){
                    int i = 1;
                    for(Item item : buyable){
                        System.out.println(item.getName() + "(" + i + ")");
                        i++;
                    }
                    System.out.println("Please choose an item based on their numbering");
                    try {

                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                
                
            } else if(input.next().toLowerCase().equals("no")){
                System.out.println("Alright, have a good day!");
                break;
            } else {
                System.out.println("What do you mean?");
            }
        }
    }
    
}
