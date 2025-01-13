package org.example;

public class QueryHandler {
    private final OutputHandler outputHandler;
    private final OSMAPIHandler osmHandler;
    private final HereAPIHandler hereHandler;
    private final AzureMapsAPIHandler azureMapsHandler;
    private final CoordinatesHandler coordinatesHandler;

    public QueryHandler(OutputHandler outputHandler, CoordinatesHandler coordinatesHandler) {
        this.outputHandler = outputHandler;
        this.osmHandler = new OSMAPIHandler();
        this.hereHandler = new HereAPIHandler();
        this.azureMapsHandler = new AzureMapsAPIHandler();
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
                double[] endCoords = coordinatesHandler.getEndCoordinatesFromUser();
                queryAPIsWithTwoAddresses(coords[0], coords[1], endCoords[0], endCoords[1]);
                break;
            case 4:
                coords = coordinatesHandler.getCoordinatesFromUser();
                latitude = coords[0];
                longitude = coords[1];
                double[] endCoordsForAll = coordinatesHandler.getEndCoordinatesFromUser();
                address = coordinatesHandler.getAddressFromUser();
                // Esegui tutte e tre le operazioni
                queryAPIsWithCoordinates(latitude, longitude);
                queryAPIsWithAddress(address);
                queryAPIsWithTwoAddresses(latitude, longitude, endCoordsForAll[0], endCoordsForAll[1]);
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
        outputHandler.addResult("Azure Maps (Reverse Geocoding)",
                azureMapsHandler.getGeoData(latitude, longitude));
        outputHandler.addResult("Azure Maps (Fuso Orario)",
                azureMapsHandler.getTimezoneByCoordinates(latitude, longitude));
        outputHandler.addResult("Azure Maps (Flusso Del Traffico)",
                azureMapsHandler.getTrafficFlowSegment(latitude, longitude));
        outputHandler.addResult("Azure Maps (Qualita Aria 3 Giorni)",
                azureMapsHandler.getAirQualityDailyForecasts(latitude, longitude));
    }

    private void queryAPIsWithAddress(String address) {
        outputHandler.addResult("OpenStreetMap (Forward Geocoding)",
                osmHandler.searchAddress(address));
        outputHandler.addResult("HERE WeGo (Forward Geocoding)",
                hereHandler.searchAddress(address));
        outputHandler.addResult("Azure Maps (Forward Geocoding)",
                azureMapsHandler.searchAddress(address));
    }

    private void queryAPIsWithTwoAddresses(double startLat, double startLon, double endLat, double endLon) {
        outputHandler.addResult("OpenStreetMap (Percorso Ottimizzato)",
                osmHandler.getOptimizedRoute(startLat, startLon, endLat, endLon));
        outputHandler.addResult("HERE WeGo (Percorso Ottimizzato)",
                hereHandler.getOptimizedRoute(startLat, startLon, endLat, endLon));
        outputHandler.addResult("Azure Maps (Percorso Ottimizzato)",
                azureMapsHandler.getOptimizedRoute(startLat, startLon, endLat, endLon));
    }


}

