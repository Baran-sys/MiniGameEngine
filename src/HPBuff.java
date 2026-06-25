public class HPBuff extends PlayerDecorator {
    public HPBuff(Player p) {
        super(p);
        this.wrappedPlayer.maxHealth += 3;
        this.wrappedPlayer.health += 3;
        this.wrappedPlayer.className = p.className + " (HP Buff)";
    }
}