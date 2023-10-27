package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Menu {

    public static final int GREET_OPTION = 1;
    public static final int EVEN_GAME_OPTION = 2;
    public static final int CALC_GAME_OPTION = 3;
    public static final int GCD_GAME_OPTION = 4;
    public static final int PROGRESS_GAME_OPTION = 5;
    public static final int PRIME_GAME_OPTION = 6;
    public static final int EXIT_OPTION = 0;

    public static void drawMenu() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case GREET_OPTION:
                Cli.greeting();
                break;
            case EVEN_GAME_OPTION:
                Engine.startGame(new Even());
                break;
            case CALC_GAME_OPTION:
                Engine.startGame(new Calc());
                break;
            case GCD_GAME_OPTION:
                Engine.startGame(new GCD());
                break;
            case PROGRESS_GAME_OPTION:
                Engine.startGame(new Progression());
                break;
            case PRIME_GAME_OPTION:
                Engine.startGame(new Prime());
                break;
            case EXIT_OPTION:
                break;
            default:
                System.out.println("Wrong menu option!");
                break;
        }
    }
}
