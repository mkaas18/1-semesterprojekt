package worldofzuul;


import java.util.Scanner;


public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Questions questions;
    private Player player;


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
    public void play() {
        while(!pickDifficulty()){}
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
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
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
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);
        if((int)(Math.floor(Math.random()*10)) > 7){
            getRandomMonster().combatInitiate(questions, player);
        }
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    private boolean pickDifficulty(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please pick a difficulty:\nEasy\nNormal\nHard");
        switch(scan.next()){
            case "easy":
                questions = new EasyQuestion();
                System.out.println("You've picked 'Easy'");
                return true;
            case "normal":
                questions = new NormalQuestion();
                System.out.println("You've picked 'Normal'");
                return true;
            case "hard":
                questions = new HardQuestion();
                System.out.println("You've picked 'Hard'");
                return true;
            default:
                System.out.println("Not a difficulty");
                return false;
        }
    }
    
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
