package org.example;

import java.util.Scanner;

public class CoordinatesHandler {
    private final Scanner scanner = new Scanner(System.in);

    public double[] getCoordinatesFromUser() {
        System.out.print("Inserisci latitudine: (esempio: 43,234)\n");
        double latitude = scanner.nextDouble();

        System.out.print("Inserisci longitudine: (esempio: 13,234)\n");
        double longitude = scanner.nextDouble();

        return new double[]{latitude, longitude};
    }

    public double[] getEndCoordinatesFromUser() {
        System.out.print("Inserisci latitudine di destinazione: (esempio: 43,234)\n");
        double latitude = scanner.nextDouble();

        System.out.print("Inserisci longitudine di destinazione: (esempio: 13,234)\n");
        double longitude = scanner.nextDouble();

        return new double[]{latitude, longitude};
    }

    public String getAddressFromUser() {
        System.out.println("Inserisci indirizzo: (esempio: Via Madonna delle Carceri 9 Camerino)");
        scanner.next();
        return scanner.nextLine();
    }

}

