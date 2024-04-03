package cabBooking.strategy;

import cabBooking.model.Cab;
import cabBooking.model.Location;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public interface CabMatchingStrategy {

    public Cab getCabs(Location currLocation, List<Cab> cabs, Set<String> availableCabs) ;
}
