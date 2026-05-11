public class CheatBuff extends PlayerDecorator {
    public CheatBuff(Player p) {
        super(p);
        this.wrappedPlayer.maxHealth += 50;
        this.wrappedPlayer.health += 50;
        this.wrappedPlayer.damage += 15;
        this.wrappedPlayer.className = p.className + " (GOD MODE)";
    }
}