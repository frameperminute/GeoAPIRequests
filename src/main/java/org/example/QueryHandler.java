package org.example;

public class QueryHandler {
    private final OutputHandler outputHandler;
    private final OSMAPIHandler osmHandler;
    private final HereAPIHandler hereHandler;
    private final CoordinatesHandler coordinatesHandler;

    public QueryHandler(OutputHandler outputHandler, OSMAPIHandler osmHandler,
                        HereAPIHandler hereHandler, CoordinatesHandler coordinatesHandler) {
        this.outputHandler = outputHandler;
        this.osmHandler = osmHandler;
        this.hereHandler = hereHandler;
        this.coordinatesHandler = coordinatesHandler;
    }

    public void handleQuery(int choice) {
        double[] coords;
        double latitude, longitude;
        String address;

        switch (choice) {
            case 1:
                coords = coordinatesHandler.getCoordinatesFromUser();
                latitude = coords[0];
                longitude = coords[1];
                queryAPIsWithCoordinates(latitude, longitude);
                break;
            case 2:
                address = coordinatesHandler.getAddressFromUser();
                queryAPIsWithAddress(address);
                break;
            case 3:
                coords = coordinatesHandler.getCoordinatesFromUser();
                latitude = coords[0];
                longitude = coords[1];
                address = coordinatesHandler.getAddressFromUser();
                queryAPIsWithCoordinates(latitude, longitude);
                queryAPIsWithAddress(address);
                break;
        }
    }

    private void queryAPIsWithCoordinates(double latitude, double longitude) {
        outputHandler.addResult("OpenStreetMap (Reverse Geocoding)",
                osmHandler.getGeoData(latitude, longitude));
        outputHandler.addResult("OpenStreetMap (Attivita Vicine)",
                osmHandler.getNearbyAmenities(latitude, longitude));
        outputHandler.addResult("HERE WeGo (Reverse Geocoding)",
                hereHandler.getGeoData(latitude, longitude));
        outputHandler.addResult("HERE WeGo (Attivita Vicine)",
                hereHandler.getNearbyAmenities(latitude, longitude));
    }

    private void queryAPIsWithAddress(String address) {
        outputHandler.addResult("OpenStreetMap (Forward Geocoding)",
                osmHandler.searchAddress(address));
        outputHandler.addResult("HERE WeGo (Forward Geocoding)",
                hereHandler.searchAddress(address));
    }

}

