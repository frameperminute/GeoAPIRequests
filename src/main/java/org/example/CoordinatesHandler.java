package org.example;

import java.util.Scanner;

public class CoordinatesHandler {
    private final Scanner scanner = new Scanner(System.in);

    public double[] getCoordinatesFromUser() {
        System.out.print("Inserisci latitudine: \n");
        double latitude = scanner.nextDouble();

        System.out.print("Inserisci longitudine: \n");
        double longitude = scanner.nextDouble();

        return new double[]{latitude, longitude};
    }

    public double[] getEndCoordinatesFromUser() {
        System.out.print("Inserisci latitudine di destinazione: \n");
        double latitude = scanner.nextDouble();

        System.out.print("Inserisci longitudine di destinazione: \n");
        double longitude = scanner.nextDouble();

        return new double[]{latitude, longitude};
    }

    public String getAddressFromUser() {
        System.out.println("Inserisci indirizzo: ");
        scanner.next();
        return scanner.nextLine();
    }

}

