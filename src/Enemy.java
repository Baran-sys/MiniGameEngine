public class Enemy {
    int HP;
    int DMG;

    public Enemy(int hp, int damage) {
        this.HP = hp;
        this.DMG = damage;
    }

    public void takeDamage(int amount) {
        this.HP -= amount;
        if (this.HP < 0) this.HP = 0;
    }

    public void attack(Player p) {
        p.getHit(this);
    }
}