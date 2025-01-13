package org.example;

public class HereAPIHandler extends GeoAPIHandler {
    private final String APIKEY = "7oAxXCg3bVyWB6RjQkbi9m65pdsqY5Qx1KtfRolTbB4";

    @Override
    public String getGeoData(double latitude, double longitude) {
        try {
            String apiUrl = "https://revgeocode.search.hereapi.com/v1/revgeocode" +
                    "?at=" + latitude + "%2C" + longitude + "&lang=en-US&apiKey=" + APIKEY + "&pretty";
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    public String getNearbyAmenities(double latitude, double longitude) {
        try {
            String apiUrl = "https://browse.search.hereapi.com/v1/browse?at="
                    + latitude + "," + longitude + "&limit=10&apiKey=" + APIKEY + "&pretty";
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    @Override
    public String searchAddress(String address) {
        try {
            String apiUrl = "https://geocode.search.hereapi.com/v1/geocode?q="
                    + address.replace(" ", "+") + "&apiKey=" + APIKEY + "&pretty";
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    public String getOptimizedRoute(double startLat, double startLon, double endLat, double endLon) {
        try {
            String apiUrl = "https://router.hereapi.com/v8/routes?transportMode=car&origin="
                    + startLat + "," + startLon + "&destination=" + endLat + "," + endLon
                    + "&return=polyline,actions&apikey=" + APIKEY;
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

}
