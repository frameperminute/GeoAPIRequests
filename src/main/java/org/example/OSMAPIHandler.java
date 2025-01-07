package org.example;

public class OSMAPIHandler extends GeoAPIHandler {
    @Override
    public String getGeoData(double latitude, double longitude) {
        try {
            String apiUrl = "https://nominatim.openstreetmap.org/reverse?format=json&lat="
                    + latitude + "&lon=" + longitude;
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    @Override
    public String getNearbyAmenities(double latitude, double longitude) {
        try {
            String apiUrl = "https://overpass-api.de/api/interpreter?data=[out:json];node(around:500,"
                    + latitude + "," + longitude + ")[amenity];out%2010;";
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    @Override
    public String searchAddress(String address) {
        try {
            String apiUrl = "https://nominatim.openstreetmap.org/search?q="
                    + address.replace(" ", "+") + "&format=json";
            return fetchData(apiUrl);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}
