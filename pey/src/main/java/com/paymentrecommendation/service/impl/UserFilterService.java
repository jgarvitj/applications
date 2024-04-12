package com.paymentrecommendation.service.impl;

import com.paymentrecommendation.enums.PaymentInstrumentType;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.service.UserFilter;

import java.util.ArrayList;
import java.util.List;

public class UserFilterService implements UserFilter {
    @Override
    public List<PaymentInstrument> filterOnDeviceUPIStatus(List<PaymentInstrument> paymentInstruments, Boolean isUPIEnabled) {
        if(isUPIEnabled) {
            return paymentInstruments;
        }
        List<PaymentInstrument> deviceFilter = new ArrayList<>();

        for(PaymentInstrument paymentInstrument : paymentInstruments) {
            if (!paymentInstrument.getPaymentInstrumentType().equals(PaymentInstrumentType.UPI)) {
                deviceFilter.add(paymentInstrument);
            }
        }

        return deviceFilter;
    }
}
