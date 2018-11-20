package worldofzuul.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import worldofzuul.interfaces.IGame;

public class Game implements IGame{

//    private Parser parser;
    private Room currentRoom;
    private Question questions;
    private Player player;
    private Map map = new Map(7);
    private RandomEvent events = new RandomEvent();

    public Game() {
//        parser = new Parser();
//        System.out.println("Hallo and Welcome to our textbased game.");
//        System.out.println("Type in your awesome player name:");
//        Scanner userName = new Scanner(System.in);
        player = new Player("Hej");
        currentRoom = map.getStartingRoom();
        events.createEvents();
    }

//    public void play() {
//        while (!pickDifficulty()) {
//        }
//        printWelcome();
//        boolean finished = false;
//        while (!finished) {
//            Command command = parser.getCommand();
//            finished = processCommand(command);
//        }
//        System.out.println("Thank you for playing.  Good bye.");
//    }

    @Override
    public String printWelcome() {
        String output = "";
        output += "--  Welcome to the Wrath of the Mathknight  --\n";
        output += "Wrath of the Mathknight is a new, incredibly exciting adventure game.\n";
        output += "Type 'help' if you need help.\n\n";
        output += currentRoom.getLongDescription() + "\n";
        return output;
    }

//    private boolean processCommand(Command command) {
//        boolean wantToQuit = false;
//
//        CommandWord commandWord = command.getCommandWord();
//
//        if (commandWord == CommandWord.UNKNOWN) {
//            System.out.println("I don't know what you mean...");
//            return false;
//        }
//        if (commandWord == CommandWord.HELP) {
//            
//            printHelp();
//        } else if (commandWord == CommandWord.GO) {
//            wantToQuit = goRoom(command);
//        } else if (commandWord == CommandWord.QUIT) {
//            wantToQuit = quit(command);
//        } else if (commandWord == CommandWord.SHOWMAP) {
//            map.printMap();
//        } else if (commandWord == CommandWord.SHOWSTATS) {
//            System.out.println(player);
//        } else if (commandWord == CommandWord.SHOWINVENTORY) {
//            player.getInventory();
//        } else if (commandWord == commandWord.USEHEALING) {
//            if (player.getPotInventory().isEmpty()) {
//                System.out.println("You dont have any healing potions - Defeat math monsters to get more.");
//            } else {
//                player.useHealing();
//            }
//        } else if (commandWord == CommandWord.SHOP) {
////            if (currentRoom.isShop()) {
////                currentRoom.getShop().startShop(player);
////            }
//            new Shop().startShop(player);
//        }
//
//        return wantToQuit;
//    }

    @Override
    public String printHelp() {
        String output = "";
        output += "You are lost. You are alone. You wander\n";
        output += "around at the Dungeon.\n\n";
        output += "Your command words are:\n";
        output += "Help: \t\tShows your commands.\n";
        output += "Usehealing: \tUse healing potions\n";
        output += "Shop: \t\tIf there is a shop in your room, your can type shop to enter the shop\n";
        output += "Showmap: \tShows the map.\n";
        output += "Go: \t\tGo the direction you like.\n";
        output += "Quit: \t\tQuits the game.\n";
        output += "Showinventory: \tShows your inventory.\n";
        output += "Showstats \tShows your stats.\n";
        return output;
    }

    @Override
    public String goRoom(String direction) {
        String output = "";
        Room nextRoom = currentRoom.getExit(direction);
//        if ((int) (Math.floor(Math.random() * 100)+1) > 80 && nextRoom != null) {
//            new MonsterGenerator().generateMonster(currentRoom.getDifficulty()).combatInitiate(questions, player);
//        } else if((int) (Math.floor(Math.random() * 100)+1) > 95 && nextRoom != null){
//            events.triggerEvent();
//        }
        if (nextRoom == null) {
            output = "There is no door!";
        } else {
            currentRoom = nextRoom;
            output = currentRoom.getLongDescription() + "\n";
            if (currentRoom.isShop()) {
                output += "There is a shop here!\n";
            }
        }
        return output;
    }
    @Override
    public Room getCurrentRoom() {
        return this.currentRoom;
    }
    @Override
    public Player getPlayer(){
        return this.player;
    }
    @Override
    public Item giveItem(){
        System.out.println("hej");
        return new ItemGenerator().generateItem(1);
    }

//    private boolean pickDifficulty() {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Please pick a difficulty:\nEasy\nNormal\nHard");
//        switch (scan.next().toLowerCase()) {
//            case "easy":
//                questions = new QuestionEasy();
//                System.out.println("You've picked 'Easy'");
//                return true;
//            case "normal":
//                questions = new QuestionNormal();
//                System.out.println("You've picked 'Normal'");
//                return true;
//            case "hard":
//                questions = new QuestionHard();
//                System.out.println("You've picked 'Hard'");
//                return true;
//            default:
//                System.out.println("Not a difficulty");
//                return false;
//        }
//    }

//    private boolean quit(Command command) {
//        if (command.hasSecondWord()) {
//            System.out.println("Quit what?");
//            return false;
//        } else {
//            return true;
//        }
//    }

    

    
}
