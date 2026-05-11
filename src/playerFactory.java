import java.util.Scanner;

public class playerFactory {

    public static Player createPlayer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write your nickname..");
        String nickname = input.nextLine();
        System.out.println("Write your player class.. (Knight(1) / Archer(2) / Tank(3)");
        int Class = input.nextInt();

        if (Class == 1) return new Knight(nickname);
        else if (Class == 2) return new Archer(nickname);
        else if (Class == 3) return new Tank(nickname);

        return null;
    }
}