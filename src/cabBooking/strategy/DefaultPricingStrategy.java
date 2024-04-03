package cabBooking.strategy;

import cabBooking.constants.Constants;
import cabBooking.model.Trip;

import java.util.Objects;

public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public int getFare(Trip trip) {
        if(Objects.isNull(trip) || Objects.isNull(trip.getEndLocation()) || Objects.isNull(trip.getStartLocation())) {
            return Constants.MIN_FARE;
        } else {
            return Constants.MIN_FARE * trip.getEndLocation().distance(trip.getStartLocation());
        }
    }
}
