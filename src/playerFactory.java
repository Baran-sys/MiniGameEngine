public class playerFactory {
    public static Player createPlayer(String nickname, int playerClass) {
        if (playerClass == 1) return new Knight(nickname);
        else if (playerClass == 2) return new Archer(nickname);
        else if (playerClass == 3) return new Tank(nickname);

        return null;
    }
}