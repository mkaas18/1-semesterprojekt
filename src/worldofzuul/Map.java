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

        while (roomList.size() > 0) {
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

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] != null) {
                    System.out.print(" " + grid[y][x]);
                }
                System.out.print(" \t");
            }
            System.out.println("");
        }

        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * levelSize));
        }
    }

    public Room[][] genNeighbours(Room[][] map, int x, int y) {
        System.out.println(map[x][y]);

        //Check north, if no room exists, create random room
        //If room exists, create no room
        if (map[y - 1][x] == null && y - 1 >= 0) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y - 1][x] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        //Check west, if no room exists, create random room
        //If room exists, create no room
        if (map[y][x - 1] == null && x - 1 >= 0) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y][x - 1] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        //Check east, if no room exists, create random room
        //If room exists, create no room
        if (map[y][x + 1] == null && x + 1 < map[y].length) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y][x + 1] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        //Check south, if no room exists, create random room
        //If room exists, create no room
        if (map[y + 1][x] == null && y + 1 < map.length) {
            int roomIndex = (int) (Math.random() * roomList.size());
            map[y + 1][x] = roomList.get(roomIndex);
            roomList.remove(roomIndex);
        }
        return map;
    }

}
