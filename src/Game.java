import java.util.Scanner;
import java.util.Random;

public class Game {

    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";

    public static void play(Player p, Scanner input, Random rand) {
        if (p.health <= 0) {
            System.out.println("You don't have a profile, please restart game and actually create one.");
            return;
        }

        int stage = 1;
        boolean playing = true;

        while (playing && p.health > 0) {

            int enemyHP = 12 + (stage * 4);
            int enemyDMG = 2 + (stage * 1);

            String[] enemyNames = {p.nickname, "Goblin", "Skeleton", "Dark Mage", "Necromancer", "Shadow Assassin",
                    "Gargoyle", "Wraith", "Banshee", "Orc Warrior", "Vampire Lord",
                    "Troll", "Lich", "Death Knight", "Abyssal Demon", "Goblin", "Skeleton", "Dark Mage", "Necromancer", "Shadow Assassin",
                    "Gargoyle", "Wraith", "Banshee", "Orc Warrior", "Vampire Lord",
                    "Troll", "Death Knight", "Abyssal Demon", "Panzer Soldat", "Avogadro", "Hellhound", "Brutus", "Nova Crawler",
                    "Flesh Golem", "Plague Bearer", "Ballas Marauder", "Vagos Thug", "Corrupt Guard", "Street Rogue", "Mercenary"};

            String randomName = enemyNames[rand.nextInt(enemyNames.length)];
            Enemy e = new Enemy(randomName, enemyHP, enemyDMG);

            System.out.println("\n==================================");
            System.out.println("STAGE " + stage + " BEGINS!");
            System.out.println("Your enemy " + e.name + " has " + enemyHP + " HP and " + enemyDMG + " DMG.");
            System.out.println("==================================");

            int count = 0;

            while (p.getHealth()> 0 && e.HP > 0) {
                p.showProfile();

                if (count % 2 == 0) {
                    System.out.println("Select an action:");
                    System.out.println("1- Fight (" + p.getDamage() + " Damage)");
                    System.out.println("2- Heal (Class Special)");
                    System.out.println("3- Special Ability");

                    int action = input.nextInt();
                    boolean isActionSuccess = false;

                    switch (action) {
                        case 1: isActionSuccess = p.attack(e); break;
                        case 2: isActionSuccess = p.heal(); break;
                        case 3: isActionSuccess = p.specialAbility(e); break;
                        default: System.out.println("Invalid input"); break;
                    }

                    if (isActionSuccess) {
                        count++;
                    }
                } else {
                    e.attack(p);
                    count++;
                }
            }

                if (p.getHealth() <= 0) {
                    System.out.println(RED + "\n __   __  _______  __   __    ______   ___   _______  ______  ");
                    System.out.println("|  | |  ||       ||  | |  |  |      | |   | |       ||      | ");
                    System.out.println("|  |_|  ||   _   ||  | |  |  |  _    ||   | |    ___||  _    |");
                    System.out.println("|       ||  | |  ||  |_|  |  | | |   ||   | |   |___ | | |   |");
                    System.out.println("|_     _||  |_|  ||       |  | |_|   ||   | |    ___|| |_|   |");
                    System.out.println("  |   |  |       ||       |  |       ||   | |   |___ |       |");
                    System.out.println("  |___|  |_______||_______|  |______| |___| |_______||______| \n" + RESET);

                    System.out.println("Your journey ends here. You died at Stage " + stage + ".");
                    playing = false;
            } else if (e.HP <= 0) {
                System.out.println("\nYou defeated" + e.name + "!");
                System.out.println("Do you want to proceed to the next stage? (1- Yes / 2- No)");
                int choice = input.nextInt();

                if (choice == 1) {
                    stage++;
                    p.health += 3;
                    if (p.getHealth() < p.getMaxHealth()) p.setHealth(p.getHealth() + 3);
                    System.out.println("You rested for a moment. HP restored by 3.");
                } else {
                    System.out.println("You retired as a legendary hero at Stage " + stage + "!");
                    playing = false;
                }
            }
        }
    }
}
