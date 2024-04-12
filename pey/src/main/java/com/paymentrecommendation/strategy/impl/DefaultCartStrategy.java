package com.paymentrecommendation.strategy.impl;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.strategy.CartFilterStrategy;


public class DefaultCartStrategy implements CartFilterStrategy {
    @Override
    public PaymentInstrument filterInstrumentsOnCart(PaymentInstrument paymentInstrument, Double amount, LineOfBusiness lineOfBusiness) {
        return paymentInstrument;
    }
}
