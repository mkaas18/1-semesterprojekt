package worldofzuul;

public class Game {

    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
        createItems();
    }

    public void createItems() {
        
        ItemDatabase itemDatabase = new ItemDatabase();
        
//        Items TEST = new Items(itemName, int intelligence, int endurance, int strength, int agility)

        Item mightyPen = new Item("Mighty Pen of Math", 10, 10, 10, 10);
        Item bookOfAddition = new Item("Book of Addition", 5, 5, 5, 5);
        Item bookOfSubtraction = new Item("Book of Subtraction", 5, 5, 5, 5);
        Item bookOfMultication = new Item("Book of Multication", 5, 5, 5, 5);
        Item bookOfDivision = new Item("Book ofDivision ", 5, 5, 5, 5);
        Item coffeMug = new Item("Coffe Mug", 0, 0, 0, 10);
        Item cake = new Item("Cake", 0, 10, 0, 0);
        Item teacherBook = new Item("The teacher's book", 10, 10, 10, 10);
        Item powerfulNerdGlasses = new Item("Glasses of the Nerd", 100, 100, 100, 100);
        
        itemDatabase.addItem(new Item("Coffine", 2, 50, 2, 10));
        
        itemDatabase.addItem(mightyPen);
        itemDatabase.addItem(bookOfAddition);
        itemDatabase.addItem(bookOfSubtraction);
        itemDatabase.addItem(bookOfMultication);
        itemDatabase.addItem(bookOfDivision);
        itemDatabase.addItem(coffeMug);
        itemDatabase.addItem(cake);
        itemDatabase.addItem(teacherBook);
        itemDatabase.addItem(powerfulNerdGlasses);
    }

    private void createRooms() {
        Room outside, theatre, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;
    }

    public void play() {
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

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
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
