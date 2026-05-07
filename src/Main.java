public class Main {
    public static void main(String[] args) {
    Game game = new Game();

    Player p1 = game.createPlayer();
    game.play(p1);
    }
}
