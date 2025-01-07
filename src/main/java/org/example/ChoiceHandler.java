package org.example;
import java.util.Scanner;

public class ChoiceHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int showInputMenu() {
        System.out.println("Scegli il tipo di input:\n1. Coordinate\n2. Indirizzo\n3. Entrambi");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}

