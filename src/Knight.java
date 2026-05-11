public class Knight extends Player{
    public Knight(String nickname) {
        super(nickname);
        this.className = "Knight";
        this.maxHealth = 12;
        this.health = this.maxHealth;
        this.damage = 3;
    }
}
