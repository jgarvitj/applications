package com.paymentrecommendation.factory;

import com.paymentrecommendation.enums.PaymentInstrumentType;
import com.paymentrecommendation.strategy.impl.DefaultCartStrategy;
import com.paymentrecommendation.strategy.CartFilterStrategy;
import com.paymentrecommendation.strategy.impl.CreditCardCartFilterStrategy;
import com.paymentrecommendation.strategy.impl.DebitCardCartFilterStrategy;
import com.paymentrecommendation.strategy.impl.NetBankingCartStrategy;
import com.paymentrecommendation.strategy.impl.UPICartStrategy;

public class StrategyFactory {

    public static CartFilterStrategy getCartFilteringStrategy(PaymentInstrumentType paymentInstrumentType) {

        if(paymentInstrumentType.equals(PaymentInstrumentType.CREDIT_CARD)) {
            return new CreditCardCartFilterStrategy();
        } else if (paymentInstrumentType.equals(PaymentInstrumentType.UPI)) {
            return new UPICartStrategy();
        } else if (paymentInstrumentType.equals(PaymentInstrumentType.DEBIT_CARD)) {
            return new DebitCardCartFilterStrategy();
        } else if (paymentInstrumentType.equals(PaymentInstrumentType.NETBANKING)) {
            return new NetBankingCartStrategy();
        }
        throw new RuntimeException("The line of business is not supported");
    }

}
