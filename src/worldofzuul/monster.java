package worldofzuul;
public class monster {
    private String name;
    private int difficulty;
    private int damage;
    
    public monster(String name, int difficulty){
        this.name = name;
        this.difficulty = difficulty;
    }
    int getDifficulty(){
        return this.difficulty;
}
    public int getDamage(){
        int temp = this.getDifficulty();
        switch(temp){
            case 0:
                return 5;
            case 1:
                return 20;
            case 2:
                return 40;
            default:
                return -1;
        }
    }
}