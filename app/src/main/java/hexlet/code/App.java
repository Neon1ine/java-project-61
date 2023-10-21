package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    protected static String username;
    public static void main(String[] args) {
        drawMenu();
    }

    private static void drawMenu() {
        int userChoice = chooseMenuOption();
        switch (userChoice) {
            case 1:
                Cli.greeting();
                break;
            case 2, 3, 4, 5, 6:
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
        username = Cli.greeting();
        switch (choice) {
            case 2:
                Even.startEvenGame();
                break;
            case 3:
                Calc.startCalcGame();
                break;
            case 4:
                GCD.startGCDGame();
                break;
            case 5:
                Progression.startProgressionGame();
                break;
            case 6:
                Prime.startPrimeGame();
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
                6 - Prime
                0 - Exit
                Your choice:\s""");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
