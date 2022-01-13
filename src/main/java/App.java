import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the player1: ");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name);

        System.out.print("Enter the name of the player2: ");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name);

        TennisGame game = new TennisGame(player1,player2);
        game.play();

    }
}
