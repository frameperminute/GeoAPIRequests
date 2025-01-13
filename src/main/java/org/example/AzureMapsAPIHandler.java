package org.example;

public class AzureMapsAPIHandler extends GeoAPIHandler {
    private static final String APIKEY = "pQdXz2MWdpxKqi1qosNcJp6ITd8JNlnBjCC3IKosK4xGnGJruX" +
            "C1JQQJ99BAAC5RqLJ5KN6gAAAgAZMP1eyJ";

    @Override
    public String getGeoData(double latitude, double longitude) {
        try {
            String apiUrl = "https://atlas.microsoft.com/reverseGeocode?api-version=2023-06-01&coordinates="
                    + longitude + "," + latitude + "&subscription-key=" + APIKEY;
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    @Override
    public String searchAddress(String address) {
        try {
            String apiUrl = "https://atlas.microsoft.com/geocode?api-version=2023-06-01&addressLine="
                    + address.replace(" ", "%20") + "&subscription-key=" + APIKEY;
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    public String getOptimizedRoute(double startLat, double startLon, double endLat, double endLon) {
        try {
            String apiUrl = "https://atlas.microsoft.com/route/directions/json?api-version=1.0"
                    + "&query=" + startLat + "," + startLon + ":" + endLat + "," + endLon +
                    "&report=effectiveSettings" + "&instructionsType=tagged&language=it-IT" +
                    "&subscription-key=" + APIKEY;
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    public String getTimezoneByCoordinates(double latitude, double longitude) {
        try {
            String apiUrl = "https://atlas.microsoft.com/timezone/byCoordinates/json?api-version=1.0"
                    + "&query=" + latitude + "," + longitude + "&options=all" +
                    "&instructionsType=tagged&language=it-IT" + "&subscription-key=" + APIKEY;
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    public String getTrafficFlowSegment(double latitude, double longitude) {
        try {
            String apiUrl = "https://atlas.microsoft.com/traffic/flow/segment/json?api-version=1.0" +
                    "&style=relative&zoom=10&unit=KMPH&query=" + latitude + ","
                    + longitude + "&subscription-key=" + APIKEY;
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    public String getAirQualityDailyForecasts(double latitude, double longitude) {
        try {
            String apiUrl = "https://atlas.microsoft.com/weather/airQuality/forecasts/" +
                    "daily/json?api-version=1.1&language=it-IT&query=" + latitude + ","
                    + longitude + "&duration=3&subscription-key=" + APIKEY;
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }
}