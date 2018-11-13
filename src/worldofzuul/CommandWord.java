package worldofzuul;

public enum CommandWord
{
<<<<<<< HEAD
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), SHOWSTATS("showstats"), SHOWMAP("showmap") ;
=======
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), SHOWSTATS("showstats"), SHOWINVENTORY("showinventory"), USEHEALING("usehealing");
>>>>>>> origin/Items
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
