import java.util.Scanner;
import java.util.Random;

public class Game {
    public static Player createPlayer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Write your nickname..");
        String nickname = input.nextLine();
        System.out.println("Write your player class.. (Knight / Archer / Tank)");
        String Class = input.nextLine();
        Player p = new Player(nickname, Class);
        return p;
    }

    public static void play(Player p){
        if (p.health <= 0) {
            System.out.println("You don't have a profile, please restart game and actually create one.");
            return;
        }

        int count = 0;

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int enemyHP = rand.nextInt(5)+6;
        int enemyDM = rand.nextInt(5)+1;

        System.out.println("Your enemy has " + enemyHP + " HP and " + enemyDM + " DMG.");


        while(p.health > 0 && enemyHP > 0){
            System.out.println("\nProfile: " + p.nickname + " " + p.Class + " HP|"
                    + p.health + " DMG|" + p.damage + " S|" + p.shield + " A|" + p.leftArrow + "\n");
            if (count % 2 == 0){
                System.out.println("Write an action:");
                System.out.println("Fight (" + p.damage + " Damage)");
                System.out.println("Heal (+1HP)");
                String action = input.nextLine();


                if (action.equals("Fight")) {
                    enemyHP -= p.damage;
                    if (p.Class.equals("Archer") && p.leftArrow > 0) {
                        p.leftArrow--;
                        System.out.println("You have " + p.leftArrow + " arrows left.");
                        System.out.println("You hit enemy " + p.damage + " damage," +
                                " Enemy HP left is:" + enemyHP);

                    }
                    else {
                        System.out.println("You hit enemy " + p.damage + " damage," +
                                " Enemy HP left is:" + enemyHP);
                        if (p.Class.equals("Knight")){
                            p.damage++;
                            System.out.println("You sharpened your sword and your DMG up by 1");
                        }
                    }
                }
                else if (action.equals("Heal")){
                    if (p.health < p.maxHealth) {
                        p.health += 1;
                        System.out.println("You healed; Your new HP is: " + p.health);
                        if (p.Class.equals("Tank")){
                            p.damage++;
                            System.out.println("You reforge your shield and your S up by 1");
                        }
                    }
                    else {
                        System.out.println("Your HP is already max, you cannot heal more than that.");
                        count--;
                    }

                }
                else System.out.println("Wrong action input..");
            }
            else{
                if (p.Class.equals("Tank") && p.shield >= enemyDM){
                    p.shield -= enemyDM;
                    System.out.println("Enemy hit you! Your new S is: " + p.shield);
                }
                else{ p.health -= enemyDM;
                System.out.println("Enemy hit you! Your new HP is: " + p.health);
                }
            }
            count++;
        }
        if (p.health <= 0 && count > 0) System.out.println("Your HP is 0, you lost the fight.");
        else if (enemyHP <= 0 && count > 0) System.out.println("You win! You defeated enemy.");
    }
}
