package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class OutputHandler {
    private final StringBuilder results = new StringBuilder();
    private final ObjectWriter prettyPrinter;

    public OutputHandler() {
        ObjectMapper mapper = new ObjectMapper();
        this.prettyPrinter = mapper.writerWithDefaultPrettyPrinter();
    }

    public void addResult(String source, String data) {
        try {
            Object json = new ObjectMapper().readValue(data, Object.class);
            String formattedData = prettyPrinter.writeValueAsString(json);
            results.append("Risposta ").append(source).append(":\n").append(formattedData).append("\n\n");
        } catch (Exception e) {
            results.append("Risposta ").append(source).append(":\n")
                    .append("Errore di formattazione: ").append(e.getMessage()).append("\n\n");
        }

    }

    public void printResults() {
        System.out.println("\n************ Risultati della query ************\n");
        System.out.println(results);
        System.out.println("***************************************\n");
        results.setLength(0); // Cancella i risultati una volta stampati
    }

}
