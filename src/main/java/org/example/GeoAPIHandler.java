package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class GeoAPIHandler {
    // Restituisce dati geografici di una determinata coordinata
    public abstract String getGeoData(double latitude, double longitude);

    // Restituisce informazioni relative a un determinato indirizzo
    public abstract String searchAddress(String address);

    // Raccoglie dati dalla query in formato String
    protected String fetchData(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection)
                url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        connection.disconnect();
        return content.toString();
    }

}
