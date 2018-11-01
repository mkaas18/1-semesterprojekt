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
    ArrayList<Room> roomList = new ArrayList<>();
    
    private Room startingRoom;

    public Map(int levelSize) {

        this.roomList.add(wineCellar);
        this.roomList.add(armoury);
        this.roomList.add(tortureRoom);
        this.roomList.add(jailRoom);
        this.roomList.add(roomRoom);
        this.roomList.add(wineCellar2);
        this.roomList.add(armoury2);
        this.roomList.add(tortureRoom2);
        this.roomList.add(jailRoom2);
        this.roomList.add(roomRoom2);
        this.roomList.add(wineCellar3);
        this.roomList.add(armoury3);
        this.roomList.add(tortureRoom3);
        this.roomList.add(jailRoom3);
        this.roomList.add(roomRoom3);
        Room[][] grid = new Room[levelSize][levelSize];
        System.out.println("Map Initialised");

        int startingRoom = (int) (Math.random() * roomList.size());
        int startingRoomPos = levelSize / 2;
        grid[startingRoomPos][startingRoomPos] = roomList.get(startingRoom);
        roomList.remove(startingRoom);

        grid = genNeighbours(grid, startingRoomPos, startingRoomPos);

        //Iterates through 2 dimensional array "grid", and generates rooms with genNeighbours method
        while(roomList.size() > 0){
            for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] != null) {
                    genNeighbours(grid, y, x);
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
        
        //Iterate through the map, setting up exits
        for (int y = 0; y < grid.length; y++) {
            
            for (int x = 0; x < grid[y].length; x++) {
                
                //Check for location north of room, if a room exsists there, and links up the room with an exit/entrance if it does
                 if (y - 1 >= 0 && grid[y - 1][x] != null && grid[y][x] != null) {
                    grid[y][x].setExit("north", grid[y - 1][x]);
                }
                //Check for location west of room, if a room exsists there, and links up the room with an exit/entrance if it does
                if (x - 1 >= 0 && grid[y][x - 1] != null && grid[y][x] != null) {
                    grid[y][x].setExit("west", grid[y][x - 1]);
                }
                //Check for location east of room, if a room exsists there, and links up the room with an exit/entrance if it does
                if (x + 1 < grid[y].length && grid[y][x + 1] != null && grid[y][x] != null) {
                    grid[y][x].setExit("east", grid[y][x + 1]);
                }
                //Check for location south of room, if a room exsists there, and links up the room with an exit/entrance if it does
                if (y + 1 < grid.length && grid[y + 1][x] != null && grid[y][x] != null) {
                    grid[y][x].setExit("south", grid[y + 1][x]);
                }
            }
        }

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
        this.startingRoom = grid[startingRoomPos][startingRoomPos];
    }

    public Room[][] genNeighbours(Room[][] map, int x, int y) {

        //Check north, if no room exists, create random room
        //If room exists, create no room
        if (y - 1 >= 0 && map[y - 1][x] == null && Math.random() < 0.75) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y - 1][x] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        //Check west, if no room exists, create random room
        //If room exists, create no room
        if (x - 1 >= 0 && map[y][x - 1] == null && Math.random() < 0.75) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y][x - 1] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        //Check east, if no room exists, create random room
        //If room exists, create no room
        if (x + 1 < map[y].length && map[y][x + 1] == null && Math.random() < 0.75) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y][x + 1] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        //Check south, if no room exists, create random room
        //If room exists, create no room
        if (y + 1 < map.length && map[y + 1][x] == null && Math.random() < 0.75) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y + 1][x] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        return map;
    }
    
    public Room getStartingRoom(){
        return this.startingRoom;
    }

}
