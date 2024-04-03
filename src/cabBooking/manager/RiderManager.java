package cabBooking.manager;

import cabBooking.model.Location;
import cabBooking.model.Rider;
import cabBooking.model.Trip;

import java.util.*;

public class RiderManager {

    private static Map<String, List<Trip>> tripLog = new HashMap<>();
    private static Map<String, Rider> riders = new HashMap<>();

    private TripManager tripManager;

    public RiderManager() {
        tripManager = new TripManager();
    }

    public Trip requestTrip(Location currentLocation, String riderId) {
        Rider rider = riders.get(riderId);
        if(Objects.nonNull(currentLocation)) {
            rider.setLocation(currentLocation);
        }
        Trip trip = tripManager.findAndCreateTrip(rider);
        tripLog.get(rider.getId()).add(trip);
        return trip;
        //return
                //CabManager.getCabManagerInstance(new DefaultCabMatchingStrategy()).getBestCab(location);
    }

    public Rider register(String id, Location location) {
        if(tripLog.containsKey(id)) {

        } else {
            tripLog.put(id, new ArrayList<Trip>());
            Rider rider = new Rider(id, location);
            riders.put(id, rider);
            return rider;
        }
        return null;
    }

}
