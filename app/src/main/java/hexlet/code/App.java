package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;

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
            case 2, 3:
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
        if (choice == 2) {
            Even.startEvenGame(username);
        } else {
            Calc.startCalcGame(username);
        }
    }

    public static int chooseMenuOption() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                0 - Exit
                Your choice:\s""");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
