public class Enemy {
    int HP;
    int DMG;
    public String name;

    public Enemy(String name, int hp, int damage) {
        this.name = name;
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