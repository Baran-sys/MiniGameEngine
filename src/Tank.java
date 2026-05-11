public class Tank extends Player{
    int maxShield;
    int shield;
    int invincibilityTurns = 0;

    public Tank(String nickname) {
        super(nickname);
        this.className = "Tank";
        this.maxHealth = 20;
        this.health = this.maxHealth;
        this.damage = 2;
        this.maxShield = 8;
        this.shield = this.maxShield;
    }

    public boolean attack(Enemy enemy){
        enemy.HP -= this.damage;
        System.out.println("You hit enemy " + this.damage + " damage," +
                " Enemy HP left is:" + enemy.HP);
        return true;
    }

    @Override
    public boolean heal() {
        if (this.health < this.maxHealth || this.shield < this.maxShield) {
            this.health += 2;
            if (this.health > this.maxHealth) this.health = this.maxHealth;

            this.shield = this.maxShield;

            System.out.println("You've reforged your shield! Your health has increased by +2 and your shield is completely renewed. (S:" + this.shield + ").");
            return true;
        } else {
            System.out.println("Your health and shield are already at full capacity.");
            return false;
        }
    }

    @Override
    public void getHit(Enemy enemy) {
        if (this.invincibilityTurns > 0) {
            System.out.println("INDESTRUCTIBLE WALL ACTIVE! Enemy's " + enemy.DMG + " damage attack didnt' bother you a little.");
            this.invincibilityTurns--;
            return;
        }

        if (this.shield >= enemy.DMG) {
            this.shield -= enemy.DMG;
            System.out.println("Enemy hit you! Your new S is: " + this.shield);
        } else {
            int remain = enemy.DMG - this.shield;
            this.shield = 0;
            this.health -= remain;
            System.out.println("Enemy hit you! Your new HP is: " + this.health);
        }
    }

    public void showProfile(){
        System.out.println("\nProfile: " + this.nickname + " " + this.className + " HP|"
                + this.health + " DMG|" + this.damage + " S|" + this.shield + "\n");
    }

    @Override
    public boolean specialAbility(Enemy enemy) {
        if (this.ultimateCooldown == 0) {
            this.invincibilityTurns = 3;
            this.shield = this.maxShield;
            this.ultimateCooldown = 6;
            System.out.println("ULTIMATE: INDESTRUCTIBLE WALL! Your shields have been renewed and you will be invulnerable to damage for 2 turns.");
            return true;
        }
        System.out.println("The ability isn't ready yet! The remaining round: " + this.ultimateCooldown);
        return false;
    }
}
