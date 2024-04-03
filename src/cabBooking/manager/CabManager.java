package cabBooking.manager;

import cabBooking.model.Cab;
import cabBooking.model.Location;
import cabBooking.strategy.CabMatchingStrategy;
import cabBooking.strategy.DefaultCabMatchingStrategy;

import java.util.*;

public class CabManager {

    private static List<Cab> cabs;
    private  static Set<String> cabIdSet;
    private static Set<String> availableCabs;
    private static CabManager cabManagerInstance;
    private static final Object cabAddLock = new Object();

    private CabMatchingStrategy cabMatchingStrategy;

    public void setCabMatchingStrategy(CabMatchingStrategy cabMatchingStrategy) {
        this.cabMatchingStrategy = cabMatchingStrategy;
    }

    private CabManager(CabMatchingStrategy cabMatchingStrategy) {
        cabs = new ArrayList<>();
        cabIdSet = new HashSet<>();
        availableCabs = new HashSet<>();
        this.cabMatchingStrategy = cabMatchingStrategy;
    }

    private CabManager() {
        cabs = new ArrayList<>();
        cabIdSet = new HashSet<>();
        availableCabs = new HashSet<>();
        this.cabMatchingStrategy = new DefaultCabMatchingStrategy();
    }

    public static CabManager init(CabMatchingStrategy cabMatchingStrategy) {
        if(Objects.isNull(cabMatchingStrategy)) {
            cabManagerInstance = new CabManager();
        } else {
            cabManagerInstance = new CabManager(cabMatchingStrategy);
        }
        return cabManagerInstance;
    }
    public static CabManager getCabManagerInstance() {
        if(cabManagerInstance == null) {
            cabManagerInstance = init(null);
        }
        return cabManagerInstance;
    }

    public void addCab(String cabId, Location currentLocation) {
        if(cabIdSet.contains(cabId)) {
            //throw exception
        }
        synchronized (cabAddLock) {
            cabIdSet.add(cabId);
            availableCabs.add(cabId);
            cabs.add(new Cab(cabId, currentLocation));
        }
    }

    public Cab getBestCab(Location location) {
        return this.cabMatchingStrategy.getCabs(location, cabs, availableCabs);
    }

    public void bookCab(Cab cab) {
        if(availableCabs.contains(cab.getId())) {
            availableCabs.remove(cab.getId());
        }
    }

    public void finishRide(Location endLocation, Cab cab) {
        availableCabs.add(cab.getId());
        cab.setCurrentLocation(endLocation);
    }

    public Cab getCabById(String id) {
        for(Cab cab : cabs) {
            if(cab.getId().equals(id)) {
                return cab;
            }
        }
        return null;
    }
}
