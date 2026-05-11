public class Archer extends Player{
    int leftArrow;

    public Archer(String nickname) {
        super(nickname);
        this.className = "Archer";
        this.maxHealth = 12;
        this.health = this.maxHealth;
        this.damage = 4;
        this.leftArrow = 6;
    }

    public boolean attack(Enemy enemy){
        if (this.leftArrow == 0) {
            enemy.HP--;
            System.out.println("You have 0 arrows left so you grabbed your knife.\n" +
                    "You hit enemy 1 damage, Enemy HP left is: " + enemy.HP);
        }
        if (this.leftArrow > 0) {
            this.leftArrow--;
            enemy.HP -= this.damage;
            System.out.println("You have " + this.leftArrow + " arrows left.");
            System.out.println("You hit enemy " + this.damage + " damage," +
                    " Enemy HP left is:" + enemy.HP);

        }
        return true;
    }

    @Override
    public boolean heal() {
        if (this.health < this.maxHealth) {
            this.health += 2;
            if (this.health > this.maxHealth) this.health = this.maxHealth;
            this.leftArrow += 2;
            System.out.println("You tactically retreated! Your health has been restored by +2 and you found 2 arrows around. Total Arrows: " + this.leftArrow);
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

    public void showProfile(){
        System.out.println("\nProfile: " + this.nickname + " " + this.className + " HP|"
                + this.health + " DMG|" + this.damage + " A|" + this.leftArrow + "\n");
    }

    @Override
    public boolean specialAbility(Enemy enemy) {
        if (this.ultimateCooldown == 0 && this.leftArrow > 0) {
            int totalDamage = this.leftArrow * this.damage;
            enemy.takeDamage(totalDamage);
            System.out.println("ULTIMATE: Arrow Rain! You shoot your " + this.leftArrow + " arrow at the same time: " + totalDamage + " damage!");
            this.leftArrow = 0;
            this.ultimateCooldown = 5;
            return true;
        }
        System.out.println("You don't have any arrow or your ability is in cooldown!");
        return false;
    }
}
