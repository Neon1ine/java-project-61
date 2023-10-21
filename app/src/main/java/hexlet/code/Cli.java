package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String username;
    public static void greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\n"
                + "May I have your name? ");
        username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");
    }

    public static String getUsername() {
        return username;
    }
}
