public abstract class Player {
    String nickname;
    String className;
    int damage;
    int maxHealth;
    int health;

    public Player(String nickname) {
       this.nickname = nickname;
    }

    public int getDamage() {
        return this.damage;
    }

    public abstract boolean attack(Enemy enemy);
    public abstract boolean heal();
    public abstract void showProfile();
    public abstract void getHit(Enemy enemy);
}
