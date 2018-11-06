package worldofzuul;

import java.util.ArrayList;

public class MonsterDatabase {

    ArrayList<Monster> MonsterList = new ArrayList<>();

    public MonsterDatabase() {
    }

    public void addMonster(Monster Monster) {
        MonsterList.add(Monster);
    }

    public void removeMonster(Monster Monster) {
        MonsterList.remove(Monster);
    }

    public Monster getMonster(int i) {
        return MonsterList.get(i);
    }
}
