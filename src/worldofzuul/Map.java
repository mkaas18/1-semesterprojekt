package worldofzuul;

import java.util.ArrayList;

public class Map {

    Room wineCellar = new Room("1");
    Room armoury = new Room("2");
    Room tortureRoom = new Room("3");
    Room jailRoom = new Room("4");
    Room roomRoom = new Room("5");
    Room wineCellar2 = new Room("6");
    Room armoury2 = new Room("7");
    Room tortureRoom2 = new Room("8");
    Room jailRoom2 = new Room("9");
    Room roomRoom2 = new Room("10");
    Room wineCellar3 = new Room("11");
    Room armoury3 = new Room("12");
    Room tortureRoom3 = new Room("13");
    Room jailRoom3 = new Room("14");
    Room roomRoom3 = new Room("15");
    ArrayList<Room> levelOneRoomList = new ArrayList<>();

    private Room startingRoom;

    public Map(int levelSize) {

        this.levelOneRoomList.add(wineCellar);
        this.levelOneRoomList.add(armoury);
        this.levelOneRoomList.add(tortureRoom);
        this.levelOneRoomList.add(jailRoom);
        this.levelOneRoomList.add(roomRoom);
        this.levelOneRoomList.add(wineCellar2);
        this.levelOneRoomList.add(armoury2);
        this.levelOneRoomList.add(tortureRoom2);
        this.levelOneRoomList.add(jailRoom2);
        this.levelOneRoomList.add(roomRoom2);
        this.levelOneRoomList.add(wineCellar3);
        this.levelOneRoomList.add(armoury3);
        this.levelOneRoomList.add(tortureRoom3);
        this.levelOneRoomList.add(jailRoom3);
        this.levelOneRoomList.add(roomRoom3);
        Room[][] grid = new Room[levelSize][levelSize];
        Room[][] levelOne = new Room[levelSize][levelSize];
        System.out.println("Map Initialised");

        int startingRoom = (int) (Math.random() * levelOneRoomList.size());
        int startingRoomPos = levelSize / 2;
        levelOne[startingRoomPos][startingRoomPos] = levelOneRoomList.get(startingRoom);
        levelOneRoomList.remove(startingRoom);

        //Iterates through 2 dimensional array "grid", and generates rooms with genNeighbours method
        levelOne = genLevel(grid, levelOneRoomList);

        //Iterate through the map, setting up exits
        
        levelOne = genExits(levelOne);

        //Prints a visualisation of the map in grid form
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] != null) {
                    System.out.print(" " + grid[y][x]);
                }
                System.out.print(" \t");
            }
            System.out.println("");
        }
        this.startingRoom = levelOne[startingRoomPos][startingRoomPos];
    }

    public Room[][] genNeighbours(Room[][] map, int x, int y, ArrayList<Room> roomList) {

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

    public Room[][] genLevel(Room[][] grid, ArrayList<Room> roomList) {
        
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[y].length; x++) {
                    if (grid[y][x] != null && Math.random() < 0.75) {
                        grid = genNeighbours(grid, x, y, roomList);

                        //Prints a visualisation of the map in grid form
                        for (int y1 = 0; y1 < grid.length; y1++) {
                            for (int x1 = 0; x1 < grid[y1].length; x1++) {
                                if (grid[y1][x1] != null) {
                                    System.out.print(" " + grid[y1][x1]);
                                }
                                System.out.print(" \t");
                            }
                            System.out.println("");
                        }

                        if (roomList.size() <= 0) {
                            break;
                        }
                    }
                    if (roomList.size() <= 0) {
                        break;
                    }
                }

            }
        
        return grid;
    }

    public Room[][] genExits(Room[][] level) {
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

    public Room getStartingRoom() {
        return this.startingRoom;
    }

}
