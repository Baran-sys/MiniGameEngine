public class Tank extends Player{
    int maxShield;
    int shield;

    public Tank(String nickname) {
        super(nickname);
        this.className = "Tank";
        this.maxHealth = 12;
        this.health = this.maxHealth;
        this.damage = 1;
        this.maxShield = 5;
        this.shield = this.maxShield;
    }
}
