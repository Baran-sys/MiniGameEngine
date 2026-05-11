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


}
