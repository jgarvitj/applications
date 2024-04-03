package cabBooking.strategy;

import cabBooking.model.Trip;

public interface PricingStrategy {
    public int getFare(Trip trip) ;
}
