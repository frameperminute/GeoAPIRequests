package org.example;
import java.util.Scanner;

public class ChoiceHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int showInputMenu() {
        System.out.println("""
                Scegli il tipo di input:
                1. Coordinate
                2. Indirizzo\

                3. Coppia di coordinate
                4. Tutti e tre""");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}

