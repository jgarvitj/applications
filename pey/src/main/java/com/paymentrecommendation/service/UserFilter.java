package com.paymentrecommendation.service;

import com.paymentrecommendation.models.PaymentInstrument;

import java.util.List;

public interface UserFilter {

    public List<PaymentInstrument> filterOnDeviceUPIStatus(List<PaymentInstrument> paymentInstruments, Boolean isUPIEnabled);

}
