package worldofzuul.logic;
import java.util.ArrayList;
import worldofzuul.interfaces.IFileReader;
import worldofzuul.persistence.FileReader;

public class Map {

    Room startingRoom = new Room("in the starting area", 0);
    Room stairRoom = new Room("in a room with a winding staircase", 0);
    Room stairRoom2 = new Room("in a room with a winding staircase", 0);
    Room stairRoom3 = new Room("in a room with a winding staircase", 0);
    Room stairRoom4 = new Room("in a room with a winding staircase", 0);
    Room levelOneShop = new Room("dwarfs shopping room, you see a tiny dwarf standing behind the counter", 1);
    Room levelTwoShop = new Room("high elfs shopping quarters, he looks unusually clean in comparison to the rest of the room", 2);
    Room levelThreeShop = new Room("wyverns store, it pretty cold in here!", 3);
    ArrayList<Room> levelOneRoomList = new ArrayList<>();
    ArrayList<Room> levelTwoRoomList = new ArrayList<>();
    ArrayList<Room> levelThreeRoomList = new ArrayList<>();
    Room[][] levelOne;
    Room[][] levelTwo;
    Room[][] levelThree;
    IFileReader fileReader;

    public Map(int levelSize) {

        //Import rooms from txt files
        fileReader = new FileReader("levelOneRooms.txt");
        importRooms(fileReader.readFile(), levelOneRoomList, 1);
        fileReader = new FileReader("levelTwoRooms.txt");
        importRooms(fileReader.readFile(), levelTwoRoomList, 2);
        fileReader = new FileReader("levelThreeRooms.txt");
        importRooms(fileReader.readFile(), levelThreeRoomList, 3);

        //Add stair & shop rooms
        this.levelOneRoomList.add(levelOneShop);
        this.levelOneShop.setShop(true);
        this.levelTwoRoomList.add(levelTwoShop);
        this.levelTwoShop.setShop(true);
        this.levelThreeRoomList.add(levelThreeShop);
        this.levelThreeShop.setShop(true);
        this.levelOneRoomList.add(stairRoom);
        this.levelTwoRoomList.add(stairRoom3);

        //Set grid size to desired map size
        this.levelOne = new Room[levelSize][levelSize];
        this.levelTwo = new Room[levelSize][levelSize];
        this.levelThree = new Room[levelSize][levelSize];

        //Define the starting rooms for each layer
        int startingRoomPos = levelSize / 2;
        this.levelOne[startingRoomPos][startingRoomPos] = startingRoom;
        this.levelTwo[startingRoomPos][startingRoomPos] = stairRoom2;
        this.levelThree[startingRoomPos][startingRoomPos] = stairRoom4;

        //Generate leves using genLevel method
        this.levelOne = genLevel(this.levelOne, this.levelOneRoomList);
        this.levelTwo = genLevel(this.levelTwo, this.levelTwoRoomList);
        this.levelThree = genLevel(this.levelThree, this.levelThreeRoomList);

        //Generate exits using the genExits method
        this.levelOne = genExits(this.levelOne);
        this.levelTwo = genExits(this.levelTwo);
        this.levelThree = genExits(this.levelThree);

        //Connect the levels
        this.stairRoom.setExit("down", stairRoom2);
        this.stairRoom2.setExit("up", stairRoom);
        this.stairRoom3.setExit("down", stairRoom4);
        this.stairRoom4.setExit("up", stairRoom3);
    }

    public static Room[][] genNeighbours(Room[][] map, int x, int y, ArrayList<Room> roomList) {

        //Check north, if no room exists, create random room
        //If room exists, create no room
        if (y - 1 >= 0 && map[y - 1][x] == null && roomList.size() > 0) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y - 1][x] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        //Check west, if no room exists, create random room
        //If room exists, create no room
        if (x - 1 >= 0 && map[y][x - 1] == null && roomList.size() > 0) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y][x - 1] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        //Check east, if no room exists, create random room
        //If room exists, create no room
        if (x + 1 < map[y].length && map[y][x + 1] == null && roomList.size() > 0) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y][x + 1] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        //Check south, if no room exists, create random room
        //If room exists, create no room
        if (y + 1 < map.length && map[y + 1][x] == null && roomList.size() > 0) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y + 1][x] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        return map;
    }

    public static Room[][] genLevel(Room[][] grid, ArrayList<Room> roomList) {
        while (roomList.size() > 0) {
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[y].length; x++) {
                    if (grid[y][x] != null && Math.random() < 0.75) {
                        grid = genNeighbours(grid, x, y, roomList);

                        if (roomList.size() <= 0) {
                            break;
                        }
                    }
                    if (roomList.size() <= 0) {
                        break;
                    }
                }

            }

        }
        return grid;
    }

    public static Room[][] genExits(Room[][] level) {
        for (int y = 0; y < level.length; y++) {

            for (int x = 0; x < level[y].length; x++) {

                //Check for location north of room, if a room exsists there, and links up the room with an exit/entrance if it does
                if (y - 1 >= 0 && level[y - 1][x] != null && level[y][x] != null) {
                    level[y][x].setExit("north", level[y - 1][x]);
                }
                //Check for location west of room, if a room exsists there, and links up the room with an exit/entrance if it does
                if (x - 1 >= 0 && level[y][x - 1] != null && level[y][x] != null) {
                    level[y][x].setExit("west", level[y][x - 1]);
                }
                //Check for location east of room, if a room exsists there, and links up the room with an exit/entrance if it does
                if (x + 1 < level[y].length && level[y][x + 1] != null && level[y][x] != null) {
                    level[y][x].setExit("east", level[y][x + 1]);
                }
                //Check for location south of room, if a room exsists there, and links up the room with an exit/entrance if it does
                if (y + 1 < level.length && level[y + 1][x] != null && level[y][x] != null) {
                    level[y][x].setExit("south", level[y + 1][x]);
                }
            }
        }
        return level;
    }

    public void printMap() {
        //Prints a visualisation of each layer in grid form
        System.out.println("Level one:");
        for (int y = 0; y < this.levelOne.length; y++) {
            for (int x = 0; x < this.levelOne[y].length; x++) {
                if (this.levelOne[y][x] != null) {
                    if (this.levelOne[y][x].getShortDescription() == "in the starting area") {
                        System.out.print(" ■");
                    } else {
                        System.out.print(" □");
                    }
                }
            }
            System.out.println("");
        }
        System.out.println("Level two:");
        for (int y = 0; y < this.levelTwo.length; y++) {
            for (int x = 0; x < this.levelTwo[y].length; x++) {
                if (this.levelTwo[y][x] != null) {
                    if (this.levelTwo[y][x].getShortDescription() == "in the starting area") {
                        System.out.print(" ■");
                    } else {
                        System.out.print(" □");
                    }
                }
            }
            System.out.println("");
        }
        System.out.println("Level three");
        for (int y = 0; y < this.levelThree.length; y++) {
            for (int x = 0; x < this.levelThree[y].length; x++) {
                if (this.levelThree[y][x] != null) {
                    if (this.levelThree[y][x].getShortDescription() == "in the starting area") {
                        System.out.print(" ■");
                    } else {
                        System.out.print(" □");
                    }
                }
            }
            System.out.println("");
        }
    }

    public static void importRooms(ArrayList<String> stringArray, ArrayList<Room> levelRoomList, int difficulty) {
        for (String string : stringArray) {
            levelRoomList.add(new Room(string, difficulty));
        }
    }

    public Room getStartingRoom() {
        return this.startingRoom;
    }

}
