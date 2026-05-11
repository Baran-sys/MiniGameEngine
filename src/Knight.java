public class Knight extends Player {
    public Knight(String nickname) {
        super(nickname);
        this.className = "Knight";
        this.maxHealth = 12;
        this.health = this.maxHealth;
        this.damage = 3;
    }

    public boolean attack(Enemy enemy) {
        enemy.HP -= this.damage;
        System.out.println("You hit enemy " + this.damage + " damage," +
                " Enemy HP left is:" + enemy.HP);
        this.damage++;
        System.out.println("You sharpened your sword and your DMG up by 1");
        return true;
    }

    public boolean heal() {
        if (this.health < this.maxHealth) {
            this.health += 1;
            System.out.println("You healed; Your new HP is: " + this.health);
        } else {
            System.out.println("Your HP is already max, you cannot heal more than that.");
            return false;
        }
        return true;
    }

    public void getHit(Enemy enemy){
        this.health -= enemy.DMG;
        System.out.println("Enemy hit you! Your new HP is: " + this.health);
    }

    public void showProfile() {
        System.out.println("\nProfile: " + this.nickname + " " + this.className + " HP|"
                + this.health + " DMG|" + this.damage + "\n");
    }
}