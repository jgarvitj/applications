package com.paymentrecommendation.strategy;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.PaymentInstrument;


public interface CartFilterStrategy {
    public PaymentInstrument filterInstrumentsOnCart(PaymentInstrument paymentInstrument, Double amount, LineOfBusiness lineOfBusiness);
}
