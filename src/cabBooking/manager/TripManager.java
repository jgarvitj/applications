package cabBooking.manager;

import cabBooking.constants.TripStatus;
import cabBooking.model.Cab;
import cabBooking.model.Location;
import cabBooking.model.Rider;
import cabBooking.model.Trip;
import cabBooking.strategy.DefaultCabMatchingStrategy;
import cabBooking.strategy.DefaultPricingStrategy;
import cabBooking.strategy.PricingStrategy;

import java.util.HashMap;
import java.util.Map;

public class TripManager {

    private static CabManager cabManager;
    private static PricingStrategy pricingStrategy;
    private static Map<String, Trip> tripMap;
    private Map<Cab, Trip> tripMapper;


    public TripManager() {
        cabManager = CabManager.getCabManagerInstance();
        pricingStrategy = new DefaultPricingStrategy();
        tripMap = new HashMap<>();
    }

    public Trip findAndCreateTrip(Rider rider) {
        Cab cab = cabManager.getBestCab(rider.getLocation());
        bookCab(cab);
        Trip trip = new Trip(cab, TripStatus.INPROGRESS , rider);
        tripMap.put(cab.getId(), trip);
        return trip;
    }

    private synchronized void bookCab(Cab cab) {
        cabManager.bookCab(cab);
    }

    public int finishTrip(Location endLocation, Cab cab) {
        cabManager.finishRide(endLocation, cab);
        Trip trip = tripMap.get(cab.getId());
        return pricingStrategy.getFare(trip);
    }


}
