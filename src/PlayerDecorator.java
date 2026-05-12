public abstract class PlayerDecorator extends Player {
    protected Player wrappedPlayer;

    public PlayerDecorator(Player p) {
        super(p.nickname);
        this.wrappedPlayer = p;

        this.className = p.className;
        this.health = p.health;
        this.maxHealth = p.maxHealth;
        this.damage = p.damage;
    }

    @Override
    public int getDamage() {
        return wrappedPlayer.getDamage();
    }
    @Override
    public int getHealth() { return wrappedPlayer.getHealth(); }

    @Override
    public void setHealth(int health) { wrappedPlayer.setHealth(health); }

    @Override
    public int getMaxHealth() { return wrappedPlayer.getMaxHealth(); }

    @Override
    public boolean attack(Enemy enemy) {
        return wrappedPlayer.attack(enemy);
    }

    @Override
    public boolean heal() {
        return wrappedPlayer.heal();
    }

    @Override
    public void getHit(Enemy enemy) {
        wrappedPlayer.getHit(enemy);
    }

    @Override
    public void showProfile() {
        wrappedPlayer.showProfile();
    }

    @Override
    public boolean specialAbility(Enemy enemy) {
        return wrappedPlayer.specialAbility(enemy);
    }
}
