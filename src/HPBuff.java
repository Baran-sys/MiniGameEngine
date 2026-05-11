public class HPBuff extends PlayerDecorator {
    public HPBuff(Player p) {
        super(p);
        this.maxHealth = wrappedPlayer.maxHealth +3;
        this.health = maxHealth;
        this.className = this.wrappedPlayer.className + "HPBuff";
    }
}
