public class Knight extends Player {
    public Knight(String nickname) {
        super(nickname);
        this.className = "Knight";
        this.maxHealth = 15;
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

    @Override
    public boolean heal() {
        if (this.health < this.maxHealth) {
            this.health += 4;
            if (this.health > this.maxHealth) this.health = this.maxHealth;
            System.out.println("You took a deep breath (Second Wind)! Your health was restored by +4. New HP: " + this.health);
            return true;
        } else {
            System.out.println("Your HP is already full, you can't heal more.");
            return false;
        }
    }

    public void getHit(Enemy enemy){
        this.health -= enemy.DMG;
        System.out.println("Enemy hit you! Your new HP is: " + this.health);
    }

    public void showProfile() {
        System.out.println("\nProfile: " + this.nickname + " " + this.className + " HP|"
                + this.health + " DMG|" + this.damage + "\n");
    }

    @Override
    public boolean specialAbility(Enemy enemy) {
        if (this.ultimateCooldown == 0) {
            int ultimateDamage = this.damage * 3;
            enemy.takeDamage(ultimateDamage);
            this.ultimateCooldown = 3;
            System.out.println("ULTIMATE: You hit " + ultimateDamage + " damage with HOLY SWROD! (3 round cooldown)");
            return true;
        }
        System.out.println("The ability isn't ready yet! The remaining round: " + this.ultimateCooldown);
        return false;
    }
}