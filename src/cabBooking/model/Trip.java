package cabBooking.model;

import cabBooking.constants.TripStatus;

public class Trip {
    private Cab cab;
    private TripStatus tripStatus;
    private Rider rider;
    private Location startLocation;
    private Location endLocation;

    public Trip(Cab cab, TripStatus tripStatus, Rider rider) {
        this.cab = cab;
        this.tripStatus = tripStatus;
        this.rider = rider;
        this.startLocation = rider.getLocation();
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }
}
