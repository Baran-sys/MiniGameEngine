public class Tank extends Player{
    int maxShield;
    int shield;

    public Tank(String nickname) {
        super(nickname);
        this.className = "Tank";
        this.maxHealth = 12;
        this.health = this.maxHealth;
        this.damage = 1;
        this.maxShield = 5;
        this.shield = this.maxShield;
    }

    public boolean attack(Enemy enemy){
        enemy.HP -= this.damage;
        System.out.println("You hit enemy " + this.damage + " damage," +
                " Enemy HP left is:" + enemy.HP);
        return true;
    }

    public boolean heal(){
        if (this.health < this.maxHealth) {
            this.health += 1;
            System.out.println("You healed; Your new HP is: " + this.health);

                this.shield++;
                System.out.println("You reforge your shield and your S up by 1");

        } else {
            System.out.println("Your HP is already max, you cannot heal more than that.");
            return false;
        }
        return true;
    }

    public void getHit(Enemy enemy) {
        if (this.shield >= enemy.DMG) {
            this.shield -= enemy.DMG;
            System.out.println("Enemy hit you! Your new S is: " + this.shield);
        } else {
            int remain = enemy.DMG -  this.shield;
            this.shield = 0;
            this.health -= remain;
            System.out.println("Enemy hit you! Your new HP is: " + this.health);
        }
    }

    public void showProfile(){
        System.out.println("\nProfile: " + this.nickname + " " + this.className + " HP|"
                + this.health + " DMG|" + this.damage + " S|" + this.shield + "\n");
    }
}
