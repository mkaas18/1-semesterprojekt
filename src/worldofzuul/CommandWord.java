package worldofzuul;

public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), SHOWSTATS("showstats"), SHOWINVENTORY("showinventory"), USEHEALING("usehealing"), SHOWMAP("showmap"), SHOP("shop");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
