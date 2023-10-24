package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Menu {

    public static final int FIRST_OPTION = 1;
    public static final int SECOND_OPTION = 2;
    public static final int THIRD_OPTION = 3;
    public static final int FOURTH_OPTION = 4;
    public static final int FIFTH_OPTION = 5;
    public static final int SIXTH_OPTION = 6;
    public static final int ZERO_OPTION = 0;

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
            case FIRST_OPTION:
                Cli.greeting();
                break;
            case SECOND_OPTION:
                Even.start();
                break;
            case THIRD_OPTION:
                Calc.start();
                break;
            case FOURTH_OPTION:
                GCD.start();
                break;
            case FIFTH_OPTION:
                Progression.start();
                break;
            case SIXTH_OPTION:
                Prime.start();
                break;
            case ZERO_OPTION:
                break;
            default:
                System.out.println("Wrong menu option!");
                break;
        }
    }
}
