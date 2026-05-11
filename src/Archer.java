public class Archer extends Player{
    int leftArrow;

    public Archer(String nickname) {
        super(nickname);
        this.className = "Archer";
        this.maxHealth = 8;
        this.health = this.maxHealth;
        this.damage = 4;
        this.leftArrow = 5;
    }

}
