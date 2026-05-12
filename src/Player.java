public abstract class Player {
    public String nickname;
    public String className;
    public int damage;
    public int maxHealth;
    public int health;
    public int ultimateCooldown = 0;

    public Player(String nickname) {
       this.nickname = nickname;
    }

    public int getDamage() {
        return this.damage;
    }
    public int getHealth() { return this.health; }
    public void setHealth(int health) { this.health = health; }
    public int getMaxHealth() { return this.maxHealth; }

    public abstract boolean attack(Enemy enemy);
    public abstract boolean heal();
    public abstract void showProfile();
    public abstract void getHit(Enemy enemy);
    public abstract boolean specialAbility(Enemy enemy);
}
