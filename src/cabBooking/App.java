package cabBooking;

import cabBooking.controller.CabController;
import cabBooking.controller.RiderController;
import cabBooking.model.Location;
import cabBooking.strategy.DefaultCabMatchingStrategy;

public class App {
    public static void main(String[] args) {
        CabController cabController = new CabController(new DefaultCabMatchingStrategy());
        RiderController riderController = new RiderController();
        Location c1L = new Location(0,0);
        cabController.addCab("c1", c1L);

        Location c2L = new Location(10, 10);
        cabController.addCab("c2", c2L);

        Location r1L = new Location(1,1);
        riderController.register("r1", r1L);
        riderController.requestRide("r1");

        Location r2L = new Location(1, 0);
        riderController.register("r2", r2L);
        riderController.requestRide("r2");
    }
}
