package com.paymentrecommendation.service.impl;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.factory.StrategyFactory;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.service.CartFilter;
import com.paymentrecommendation.strategy.CartFilterStrategy;


public class CartFilterService implements CartFilter {


    @Override
    public PaymentInstrument filterInstrumentsOnCart(PaymentInstrument paymentInstruments, Double amount, LineOfBusiness lineOfBusiness) {
        CartFilterStrategy cartFilterStrategy =  StrategyFactory.getCartFilteringStrategy(paymentInstruments.getPaymentInstrumentType());
        return cartFilterStrategy.filterInstrumentsOnCart(paymentInstruments, amount, lineOfBusiness);
    }
}
