package org.example;

public class Main {
    public static void main(String[] args) {
        CoordinatesHandler coordinatesHandler = new CoordinatesHandler();
        ChoiceHandler choiceHandler = new ChoiceHandler();
        OutputHandler outputHandler = new OutputHandler();
        QueryHandler queryHandler = new QueryHandler(outputHandler, coordinatesHandler);
        ContinueHandler continueHandler = new ContinueHandler();
        do {
            int choice = choiceHandler.showInputMenu();
            if (choice < 1 || choice > 4) {
                System.out.println("Scelta non valida. Per favore, riprova.");
                continue;
            }
            queryHandler.handleQuery(choice);
            outputHandler.printResults();
        } while (continueHandler.askToContinue());
        System.out.println("Grazie per aver usato GeoAPIQuery!");
    }
}
