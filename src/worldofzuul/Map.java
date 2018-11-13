package worldofzuul;

<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
=======
import java.util.ArrayList;
>>>>>>> origin/Items

public class Map {

    Room startingRoom = new Room("in the starting area");
<<<<<<< HEAD
    Room stairRoom = new Room("in a room with a winding staircase");
    Room stairRoom2 = new Room("in a room with a winding staircase");
    Room stairRoom3 = new Room("in a room with a winding staircase");
    Room stairRoom4 = new Room("in a room with a winding staircase");
    ArrayList<Room> levelOneRoomList = new ArrayList<>();
    ArrayList<Room> levelTwoRoomList = new ArrayList<>();
    ArrayList<Room> levelThreeRoomList = new ArrayList<>();
    Room[][] levelOne;
    Room[][] levelTwo;
    Room[][] levelThree;

    public Map(int levelSize) {

        //TODO relative pathing for files
        File levelOneRoomDescriptions = new File("levelOneRooms.txt");
        File levelTwoRoomDescriptions = new File("levelTwoRooms.txt");
        File levelThreeRoomDescriptions = new File("levelThreeRooms.txt");
            String basePath = new File("").getAbsolutePath();
    System.out.println(basePath);

        importRooms(levelOneRoomDescriptions, levelOneRoomList);
        importRooms(levelTwoRoomDescriptions, levelTwoRoomList);
        importRooms(levelThreeRoomDescriptions, levelThreeRoomList);

        this.levelOne = new Room[levelSize][levelSize];
        this.levelTwo = new Room[levelSize][levelSize];
        this.levelThree = new Room[levelSize][levelSize];
        System.out.println("Map Initialised");

        int startingRoomPos = levelSize / 2;
        this.levelOne[startingRoomPos][startingRoomPos] = startingRoom;
        this.levelTwo[startingRoomPos][startingRoomPos] = stairRoom2;
        this.levelThree[startingRoomPos][startingRoomPos] = stairRoom4;

        this.levelOne = genLevel(this.levelOne, this.levelOneRoomList);
        this.levelTwo = genLevel(this.levelTwo, this.levelTwoRoomList);
        this.levelThree = genLevel(this.levelThree, this.levelThreeRoomList);

        this.levelOne = genExits(this.levelOne);
        this.levelTwo = genExits(this.levelTwo);
        this.levelThree = genExits(this.levelThree);

=======
    Room wineCellar = new Room("1");
    Room armoury = new Room("2");
    Room tortureRoom = new Room("3");
    Room jailRoom = new Room("4");
    Room roomRoom = new Room("5");
    Room stairRoom = new Room("in a room with a winding staircase that connects starting level to level 1 ");
    Room wineCellar2 = new Room("6");
    Room armoury2 = new Room("7");
    Room tortureRoom2 = new Room("8");
    Room jailRoom2 = new Room("9");
    Room roomRoom2 = new Room("10");
    Room stairRoom2 = new Room("in a room with a winding staircase that connect level 2 and 3");
    Room wineCellar3 = new Room("11");
    Room armoury3 = new Room("12");
    Room tortureRoom3 = new Room("13");
    Room jailRoom3 = new Room("14");
    Room roomRoom3 = new Room("15");
    Room stairRoom3 = new Room("in a room with a winding staircase that connects level 2 and 3");
    Room stairRoom4 = new Room("in a room with a winding staircase that connects level 3 and Boss room");
    ArrayList<Room> levelOneRoomList = new ArrayList<>();
    ArrayList<Room> levelTwoRoomList = new ArrayList<>();
    ArrayList<Room> levelThreeRoomList = new ArrayList<>();

    public Map(int levelSize) {

        this.levelOneRoomList.add(wineCellar);
        this.levelOneRoomList.add(armoury);
        this.levelOneRoomList.add(tortureRoom);
        this.levelOneRoomList.add(jailRoom);
        this.levelOneRoomList.add(roomRoom);
        this.levelOneRoomList.add(stairRoom);
        this.levelTwoRoomList.add(wineCellar2);
        this.levelTwoRoomList.add(armoury2);
        this.levelTwoRoomList.add(tortureRoom2);
        this.levelTwoRoomList.add(jailRoom2);
        this.levelTwoRoomList.add(roomRoom2);
        this.levelTwoRoomList.add(stairRoom3);
        this.levelThreeRoomList.add(wineCellar3);
        this.levelThreeRoomList.add(armoury3);
        this.levelThreeRoomList.add(tortureRoom3);
        this.levelThreeRoomList.add(jailRoom3);
        this.levelThreeRoomList.add(roomRoom3);
        
        Room[][] levelOne = new Room[levelSize][levelSize];
        Room[][] levelTwo = new Room[levelSize][levelSize];
        Room[][] levelThree = new Room[levelSize][levelSize];
        System.out.println("Map Initialised");

        int startingRoomPos = levelSize / 2;
        levelOne[startingRoomPos][startingRoomPos] = startingRoom;
        levelTwo[startingRoomPos][startingRoomPos] = stairRoom2;
        levelThree[startingRoomPos][startingRoomPos] = stairRoom4;

        levelOne = genLevel(levelOne, levelOneRoomList);
        levelTwo = genLevel(levelTwo, levelTwoRoomList);
        levelThree = genLevel(levelThree, levelThreeRoomList);

        levelOne = genExits(levelOne);
        levelTwo = genExits(levelTwo);
        levelThree = genExits(levelThree);
        
>>>>>>> origin/Items
        this.stairRoom.setExit("down", stairRoom2);
        this.stairRoom2.setExit("up", stairRoom);
        this.stairRoom3.setExit("down", stairRoom4);
        this.stairRoom4.setExit("up", stairRoom3);
<<<<<<< HEAD

        System.out.println("Map generated!");
        //Prints a visualisation of each layer in grid form
        printMap();
=======
        
        //Prints a visualisation of each layer in grid form
        for (int y = 0; y < levelOne.length; y++) {
            for (int x = 0; x < levelOne[y].length; x++) {
                if (levelOne[y][x] != null) {
                    System.out.print(" " + levelOne[y][x]);
                }
                System.out.print(" \t");
            }
            System.out.println("");
        }

        for (int y = 0; y < levelTwo.length; y++) {
            for (int x = 0; x < levelTwo[y].length; x++) {
                if (levelTwo[y][x] != null) {
                    System.out.print(" " + levelTwo[y][x]);
                }
                System.out.print(" \t");
            }
            System.out.println("");
        }

        for (int y = 0; y < levelThree.length; y++) {
            for (int x = 0; x < levelThree[y].length; x++) {
                if (levelThree[y][x] != null) {
                    System.out.print(" " + levelThree[y][x]);
                }
                System.out.print(" \t");
            }
            System.out.println("");
        }
>>>>>>> origin/Items
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

<<<<<<< HEAD
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

    public static void importRooms(File roomFile, ArrayList<Room> levelRoomList) {
        try {
            Scanner sc = new Scanner(roomFile);
            while (sc.hasNext()) {
                levelRoomList.add(new Room(sc.nextLine()));
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found, shutting down");
        }
    }

=======
>>>>>>> origin/Items
    public Room getStartingRoom() {
        return this.startingRoom;
    }

}
