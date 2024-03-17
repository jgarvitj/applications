package Vehicle.factory;

import Vehicle.Vehicle;
import Vehicle.Car;
import Vehicle.NullVehicle;
import Vehicle.VehicleConstants.VehicleConstants;

public class VehicleFactory {

    public static Vehicle getVehicleObject(String type) {
        if(VehicleConstants.CAR.equalsIgnoreCase(type)) {
            return new Car();
        }
        return new NullVehicle();
    }
}
