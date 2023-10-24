package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\n"
                + "May I have your name? ");
        String username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");
        return username;
    }
}
