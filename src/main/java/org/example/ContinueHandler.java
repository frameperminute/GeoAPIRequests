package org.example;

import java.util.Scanner;

public class ContinueHandler {
    private final Scanner scanner = new Scanner(System.in);

    public boolean askToContinue() {
        System.out.print("Vuoi effettuare un'altra query? (si/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("si");
    }
}

