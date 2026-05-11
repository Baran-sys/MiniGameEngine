public class Archer extends Player{
    int leftArrow;

    public Archer(String nickname) {
        super(nickname);
        this.className = "Archer";
        this.maxHealth = 10;
        this.health = this.maxHealth;
        this.damage = 4;
        this.leftArrow = 5;
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

    public boolean heal(){
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

    public void showProfile(){
        System.out.println("\nProfile: " + this.nickname + " " + this.className + " HP|"
                + this.health + " DMG|" + this.damage + " A|" + this.leftArrow + "\n");
    }

}
