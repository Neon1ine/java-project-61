package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        drawMenu();
    }

    private static void drawMenu() {
        int userChoice = chooseMenuOption();
        switch (userChoice) {
            case 1:
                Cli.greeting();
                break;
            case 2, 3, 4, 5:
                setupGameStart(userChoice);
                break;
            case 0:
                break;
            default:
                System.out.println("Wrong menu option!");
                drawMenu();
                break;
        }

    }

    private static void setupGameStart(int choice) {
        String username = Cli.greeting();
        switch (choice) {
            case 2:
                Even.startEvenGame(username);
                break;
            case 3:
                Calc.startCalcGame(username);
                break;
            case 4:
                GCD.startGCDGame(username);
                break;
            case 5:
                Progression.startProgressionGame(username);
                break;
            default:
                System.out.println("Error in setupGameStart: choice " + choice);
                break;
        }
    }

    public static int chooseMenuOption() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                0 - Exit
                Your choice:\s""");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
