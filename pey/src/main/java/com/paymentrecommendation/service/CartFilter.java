package com.paymentrecommendation.service;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.PaymentInstrument;

import java.util.List;

public interface CartFilter {
    public PaymentInstrument filterInstrumentsOnCart(PaymentInstrument paymentInstruments, Double amount, LineOfBusiness lineOfBusiness);
}
