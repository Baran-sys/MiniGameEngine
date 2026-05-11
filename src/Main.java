import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println(CYAN + "  _____  _____  _____ ");
        System.out.println(" |  _  ||  _  ||  ___|");
        System.out.println(" | |_| || |_| || | __ ");
        System.out.println(" |  _  /|  ___/| ||_ |");
        System.out.println(" | | \\ \\| |    | |__||");
        System.out.println(" \\_|  \\_\\_|    \\_____|" + RESET);
        System.out.println(YELLOW + "--- Welcome to the Ultimate Terminal RPG ---\n" + RESET);

        System.out.println("Write your nickname..");
        String nickname = input.nextLine();

        System.out.println("Write your player class.. (Knight(1) / Archer(2) / Tank(3))");
        int classChoice = input.nextInt();

        Player p = playerFactory.createPlayer(nickname, classChoice);
        if (p == null) {
            System.out.println("Invalid class selection!");
            return;
        }

        if (nickname.equalsIgnoreCase("HESOYAM")) {
            System.out.println(GREEN + "Cheat Activated: +50 HP, +15 DMG. Welcome to God Mode." + RESET);
            p = new CheatBuff(p);
        }

        System.out.println("Choose your buff..(0- Nothing / 1- +2DMG / 2- +3HP)");
        int buffChoice = input.nextInt();

        switch (buffChoice) {
            case 0: break;
            case 1: p = new DMGBuff(p); break;
            case 2: p = new HPBuff(p); break;
        }

        Game.play(p, input, rand);
    }
}
