import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void play(Player p, Scanner input) {
        if (p.health <= 0) {
            System.out.println("You don't have a profile, please restart game and actually create one.");
            return;
        }

        int count = 0;
        Random rand = new Random();
        int enemyHP = rand.nextInt(5) + 6;
        int enemyDM = rand.nextInt(5) + 1;
        boolean isActionSuccess = false;
        Enemy e = new Enemy(enemyHP, enemyDM);

        System.out.println("Your enemy has " + enemyHP + " HP and " + enemyDM + " DMG.");


        while (p.health > 0 && e.HP > 0) {

            p.showProfile();

            if (count % 2 == 0) {
                System.out.println("Select an action:");
                System.out.println("1- Fight (" + p.getDamage() + " Damage)");
                System.out.println("2- Heal (+1HP)");
                int action = input.nextInt();

                switch (action) {
                    case 1: isActionSuccess = p.attack(e); break;
                    case 2: isActionSuccess = p.heal(); break;
                    default: System.out.println("Invalid input"); break;
                }
                count++;
                if (!isActionSuccess) count--;
            } else {
                e.attack(p);
                count++;
                }
            }
        if (p.health <= 0 && count > 0) System.out.println("Your HP is "+ p.health + ", you lost the fight.");
        else if (e.HP <= 0 && count > 0) System.out.println("You win! You defeated enemy.");
    }
}
