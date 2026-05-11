public class HPBuff extends PlayerDecorator {
    public HPBuff(Player p) {
        super(p);
        this.wrappedPlayer.health += 3;
        this.health = maxHealth;
        this.className = this.wrappedPlayer.className + "HPBuff";
    }
}
