package cabBooking.model;

public class Cab {
    private String id;
    private Location currentLocation;

    public Cab(String id, Location currentLocation) {
        this.id = id;
        this.currentLocation = currentLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

}
