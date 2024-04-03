package cabBooking.controller;

import cabBooking.manager.RiderManager;
import cabBooking.model.Location;
import cabBooking.model.Rider;

public class RiderController {

    private RiderManager riderManager;

    public RiderController() {
        this.riderManager = new RiderManager();
    }


    public void requestRide(Location location, String id) {
        this.riderManager.requestTrip(location, id);
    }
    public void requestRide( String id) {
        this.riderManager.requestTrip(null, id);
    }

    public void register(String riderId, Location location) {
        this.riderManager.register(riderId, location);
    }

}
