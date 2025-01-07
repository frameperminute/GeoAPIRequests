package org.example;

public class HereAPIHandler extends GeoAPIHandler {
    private final String apiKey;

    public HereAPIHandler(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String getGeoData(double latitude, double longitude) {
        try {
            String apiUrl = "https://revgeocode.search.hereapi.com/v1/revgeocode" +
                    "?at=" + latitude + "%2C" + longitude + "&lang=en-US&apiKey=" + apiKey + "&pretty";
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    @Override
    public String getNearbyAmenities(double latitude, double longitude) {
        try {
            String apiUrl = "https://browse.search.hereapi.com/v1/browse?at="
                    + latitude + "," + longitude + "&limit=10&apiKey=" + apiKey + "&pretty";
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    @Override
    public String searchAddress(String address) {
        try {
            String apiUrl = "https://geocode.search.hereapi.com/v1/geocode?q="
                    + address.replace(" ", "+") + "&apiKey=" + apiKey + "&pretty";
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

}
