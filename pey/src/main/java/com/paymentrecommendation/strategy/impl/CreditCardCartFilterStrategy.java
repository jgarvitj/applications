package com.paymentrecommendation.strategy.impl;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.strategy.CartFilterStrategy;


public class CreditCardCartFilterStrategy implements CartFilterStrategy {
    @Override
    public PaymentInstrument filterInstrumentsOnCart(PaymentInstrument paymentInstrument, Double amount, LineOfBusiness lineOfBusiness) {
        if(amount <= 250000 && lineOfBusiness.equals(LineOfBusiness.COMMERCE)) {
            return paymentInstrument;
        }
        return null;
    }
}
