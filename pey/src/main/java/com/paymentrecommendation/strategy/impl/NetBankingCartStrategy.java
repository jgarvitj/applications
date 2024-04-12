package com.paymentrecommendation.strategy.impl;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.strategy.CartFilterStrategy;

public class NetBankingCartStrategy implements CartFilterStrategy {
    @Override
    public PaymentInstrument filterInstrumentsOnCart(PaymentInstrument paymentInstrument, Double amount, LineOfBusiness lineOfBusiness) {
        if( lineOfBusiness.equals(LineOfBusiness.CREDIT_CARD_BILL_PAYMENT) && amount <= 200000) {
            return paymentInstrument;
        } else if (lineOfBusiness.equals(LineOfBusiness.INVESTMENT) && amount <= 150000) {
            return paymentInstrument;
        }
        return null;
    }
}
