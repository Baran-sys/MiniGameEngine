import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void play(Player p) {
        if (p.health <= 0) {
            System.out.println("You don't have a profile, please restart game and actually create one.");
            return;
        }

        int count = 0;

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int enemyHP = rand.nextInt(5) + 6;
        int enemyDM = rand.nextInt(5) + 1;

        System.out.println("Your enemy has " + enemyHP + " HP and " + enemyDM + " DMG.");


        while (p.health > 0 && enemyHP > 0) {

            switch (p.className) {
                case "Knight":
                    System.out.println("\nProfile: " + p.nickname + " " + p.className + " HP|"
                            + p.health + " DMG|" + p.damage + "\n"); break;
                case "Archer":
                    System.out.println("\nProfile: " + p.nickname + " " + p.className + " HP|"
                            + p.health + " DMG|" + p.damage + " A|" + ((Archer)p).leftArrow + "\n"); break;
                case "Tank":
                    System.out.println("\nProfile: " + p.nickname + " " + p.className + " HP|"
                            + p.health + " DMG|" + p.damage + " S|" + ((Tank)p).shield + "\n"); break;
            }

            if (count % 2 == 0) {
                System.out.println("Select an action:");
                System.out.println("1- Fight (" + p.damage + " Damage)");
                System.out.println("2- Heal (+1HP)");
                int action = input.nextInt();


                if (action == 1) {
                    enemyHP -= p.damage;
                    if (p.className.equals("Archer") && ((Archer)p).leftArrow == 0) {
                        enemyHP--;
                        enemyHP+= p.damage;
                        System.out.println("You have 0 arrows left so you grabbed your knife.\n" +
                                "You hit enemy 1 damage, Enemy HP left is: " + enemyHP);
                    }
                    if (p.className.equals("Archer") && ((Archer)p).leftArrow > 0) {
                        ((Archer)p).leftArrow--;
                        System.out.println("You have " + ((Archer)p).leftArrow + " arrows left.");
                        System.out.println("You hit enemy " + p.damage + " damage," +
                                " Enemy HP left is:" + enemyHP);

                    } else if(!p.className.equals("Archer")){
                        System.out.println("You hit enemy " + p.damage + " damage," +
                                " Enemy HP left is:" + enemyHP);
                        if (p.className.equals("Knight")) {
                            p.damage++;
                            System.out.println("You sharpened your sword and your DMG up by 1");
                        }
                    }
                } else if (action == 1) {
                    if (p.health < p.maxHealth) {
                        p.health += 1;
                        System.out.println("You healed; Your new HP is: " + p.health);
                        if (p.className.equals("Tank")) {
                            p.damage++;
                            System.out.println("You reforge your shield and your S up by 1");
                        }
                    } else {
                        System.out.println("Your HP is already max, you cannot heal more than that.");
                        count--;
                    }

                } else System.out.println("Wrong action input..");
            } else {
                if (p.className.equals("Tank") && ((Tank)p).shield >= enemyDM) {
                    ((Tank)p).shield -= enemyDM;
                    System.out.println("Enemy hit you! Your new S is: " + ((Tank)p).shield);
                } else {
                    p.health -= enemyDM;
                    System.out.println("Enemy hit you! Your new HP is: " + p.health);
                }
            }
            count++;
        }
        if (p.health <= 0 && count > 0) System.out.println("Your HP is 0, you lost the fight.");
        else if (enemyHP <= 0 && count > 0) System.out.println("You win! You defeated enemy.");
    }
}
