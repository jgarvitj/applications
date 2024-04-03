package cabBooking.strategy;

import cabBooking.constants.Constants;
import cabBooking.model.Cab;
import cabBooking.model.Location;

import java.util.*;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy{


    @Override
    public Cab getCabs(Location currLocation, List<Cab> cabs, Set<String> availableCabs) {
        Queue<Cab> cabQ = new PriorityQueue<>(new Comparator<Cab>() {
            @Override
            public int compare(Cab o1, Cab o2) {
                return currLocation.distance(o1.getCurrentLocation()) - currLocation.distance(o2.getCurrentLocation());
            }
        });
        for(Cab cab : cabs) {
            cabQ.offer(cab);
        }
        Queue<Cab> closestCabs = new LinkedList<>();
        while(!cabQ.isEmpty() && closestCabs.size() < Constants.MAX_CABS_CLOSEST) {
            if(availableCabs.contains(cabQ.peek().getId())) {
                return cabQ.peek();
            }
        }
        return null;
    }

}
