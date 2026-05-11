public class DMGBuff extends PlayerDecorator {
    public DMGBuff(Player p) {
        super(p);
        this.damage = this.wrappedPlayer.damage + 2;
        this.className = this.wrappedPlayer.className + "DMGBuff";
    }
}
