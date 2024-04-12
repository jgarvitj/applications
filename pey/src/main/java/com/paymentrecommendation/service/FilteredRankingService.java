package com.paymentrecommendation.service;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.PaymentInstrument;

import java.util.List;

public interface FilteredRankingService {
    public List<PaymentInstrument> getRankedPaymentInstruments(List<PaymentInstrument> paymentInstruments, LineOfBusiness lineOfBusiness);
}
