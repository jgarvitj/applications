package cabBooking.controller;

import cabBooking.manager.CabManager;
import cabBooking.manager.TripManager;
import cabBooking.model.Cab;
import cabBooking.model.Location;
import cabBooking.strategy.CabMatchingStrategy;
import cabBooking.strategy.DefaultCabMatchingStrategy;

public class CabController {

    TripManager tripManager;

    public CabController() {
        tripManager = new TripManager();
    }

    public CabController(CabMatchingStrategy cabMatchingStrategy) {
        tripManager = new TripManager();
        CabManager.init(cabMatchingStrategy);
    }

    public void addCab(String id, Location location) {
        CabManager.getCabManagerInstance().addCab(id, location);
    }

    public void completeRide(String cabId, Location currLocation) {
        Cab cab = CabManager.getCabManagerInstance().getCabById(cabId);
        tripManager.finishTrip(currLocation, cab);
    }
}
