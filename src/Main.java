import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Write your nickname..");
        String nickname = input.nextLine();

        System.out.println("Write your player class.. (Knight(1) / Archer(2) / Tank(3))");
        int classChoice = input.nextInt();

        Player p = playerFactory.createPlayer(nickname, classChoice);
        if (p == null) {
            System.out.println("Invalid class selection!");
            return;
        }

        System.out.println("Choose your buff..(0- Nothing / 1- +2DMG / 2- +3HP)");
        int buffChoice = input.nextInt();

        switch (buffChoice) {
            case 0: break;
            case 1: p = new DMGBuff(p); break;
            case 2: p = new HPBuff(p); break;
        }

        Game.play(p, input);
    }
}
