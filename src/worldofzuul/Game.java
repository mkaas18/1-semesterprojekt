package worldofzuul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private Question questions;
    private Player player;
<<<<<<< HEAD
    private MonsterDatabase monsterDatabase;
    private Map map = new Map(7);
    private RandomEvent events = new RandomEvent();

    public Game() {
        System.out.println("Hallo and Welcome to our textbased game.");
        System.out.println("Type in your awesome player name:");
        Scanner userName = new Scanner(System.in);
        player = new Player(userName.next());
        userName.close();
        events.createEvents();
    }

=======


    public Game() 
    {
        parser = new Parser();
        createWorld();
    }
    public void createWorld(){
        Map map = new Map(7);
        currentRoom = map.getStartingRoom();
        createItems();
        player = new Player("Boii", 4, 7, 5, 4);
    }

    public void createItems() {

        ItemDatabase itemDatabase = new ItemDatabase();
        ItemGenerator itemGenerator = new ItemGenerator();

        for (int i = 0; i < 10; i++) {

            Item item = itemGenerator.generateItem();
//            System.out.println(item.getName());
//            System.out.println(item.getStats().toString());
//            System.out.println();   
            itemDatabase.addItem(item);
        }

    }
// Original createMonsters method.
// Creates a series of monsters when the game launches, using the monsterGenerator name arraylist
//    public void createMonsters() {
//        
//        monsterDatabase = new MonsterDatabase();
//        MonsterGenerator monsterGenerator = new MonsterGenerator();
//        
//        for (int i = 0; i < 10; i++) {
//            
//            Monster monster = new Monster(monsterGenerator.generateMonster(), 1);
//            monsterDatabase.addMonster(monster);
//        }
//    }
//    
>>>>>>> Monster2.0
    public void play() {
        while (!pickDifficulty()) {
        }
        printWelcome();
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("--  Welcome to the Wrath of the Mathknight  --");
        System.out.println("Wrath of the Mathknight is a new, incredibly exciting adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        if (commandWord == CommandWord.HELP) {
            printHelp();
            events.triggerEvent();
        } else if (commandWord == CommandWord.GO) {
            wantToQuit = goRoom(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.SHOWMAP) {
            map.printMap();
        } else if (commandWord == CommandWord.SHOWSTATS) {
            System.out.println(player);
        } else if (commandWord == CommandWord.SHOWINVENTORY) {
            player.getInventory();
        } else if (commandWord == commandWord.USEHEALING) {
            if (player.getPotInventory().isEmpty()) {
                System.out.println("You dont have any healing potions - Defeat math monsters to get more.");
            } else {
                player.useHealing();
            }
        } else if (commandWord == CommandWord.SHOP) {
            if (currentRoom.isShop()) {
                currentRoom.getShop().startShop(player);
            }
        }

        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the Dungeon.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private boolean goRoom(Command command) {
        boolean exitGame = false;
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return false;
        }
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);
        if ((int) (Math.floor(Math.random() * 10)) > 7 && nextRoom != null) {
            new Monster(new MonsterGenerator().generateMonster(), 1).combatInitiate(questions, player);
        }
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            if (currentRoom.isShop()) {
                System.out.println("There is a shop here!");;
            }
        }
        return exitGame;
    }

    private boolean pickDifficulty() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please pick a difficulty:\nEasy\nNormal\nHard");
        switch (scan.next().toLowerCase()) {
            case "easy":
                questions = new QuestionEasy();
                System.out.println("You've picked 'Easy'");
                return true;
            case "normal":
                questions = new QuestionNormal();
                System.out.println("You've picked 'Normal'");
                return true;
            case "hard":
                questions = new QuestionHard();
                System.out.println("You've picked 'Hard'");
                return true;
            default:
                System.out.println("Not a difficulty");
                return false;
        }
    }
<<<<<<< HEAD

=======
    
>>>>>>> Monster2.0
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
