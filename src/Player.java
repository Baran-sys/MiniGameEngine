public class Player {
    String nickname;
    String Class;
    int damage;
    int maxHealth;
    int health;
    int leftArrow;
    int shield;
    int maxShield;

    public Player(String nickname, String Class) {
        this.nickname = nickname;
        this.Class = Class;

        if(Class.equals("Knight")){
            this.health = 12;
            this.maxHealth = health;
            this.damage = 3;
            this.leftArrow = 0;
            this.shield = 0;
            this.maxShield = shield;
        } else if (Class.equals("Archer")) {
            this.health = 8;
            this.maxHealth = health;
            this.damage = 4;
            this.leftArrow = 5;
            this.shield = 0;
            this.maxShield = shield;
        } else if (Class.equals("Tank")) {
            this.health = 12;
            this.maxHealth = health;
            this.damage = 1;
            this.leftArrow = 0;
            this.shield = 5;
            this.maxShield = shield;
        }
        else {
            System.out.println("Wrong class name input..");
            return;
        }
    }
}
