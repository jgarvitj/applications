package com.paymentrecommendation.service.impl;

import com.paymentrecommendation.models.Cart;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.models.User;
import com.paymentrecommendation.service.CartFilter;
import com.paymentrecommendation.service.FilteredRankingService;
import com.paymentrecommendation.service.PaymentRecommender;
import com.paymentrecommendation.service.UserFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PaymentRecommenderImpl implements PaymentRecommender {
    private FilteredRankingService filteredRankingService;
    private UserFilter userFilter;
    private CartFilter cartFilter;
    public PaymentRecommenderImpl(FilteredRankingService filteredRankingService, UserFilter userFilter, CartFilter cartFilter) {
        this.filteredRankingService =filteredRankingService;
        this.userFilter = userFilter;
        this.cartFilter = cartFilter;
    }
    @Override
    public List<PaymentInstrument> recommendPaymentInstruments(User user, Cart cart) {
        if(Objects.isNull(cart)) {
            return Collections.emptyList();
        }
        if(Objects.isNull(user) || Objects.isNull(user.getUserPaymentInstrument())
                 || Objects.isNull(cart.getLineOfBusiness()) ) {
            throw new RuntimeException("The line of business is not supported");
        }

        List<PaymentInstrument> paymentInstruments = user.getUserPaymentInstrument().getPaymentInstruments();
        if(Objects.isNull(paymentInstruments) || paymentInstruments.isEmpty()) {
            return paymentInstruments;
        }
        Boolean isUpiEnabled = Boolean.FALSE;
        if(Objects.nonNull(user) && Objects.nonNull(user.getUserContext()) && Objects.nonNull(user.getUserContext().getDeviceContext())) {
            isUpiEnabled = user.getUserContext().getDeviceContext().isUpiEnabled();
        }

        List<PaymentInstrument> deviceFilteredPayments = userFilter.filterOnDeviceUPIStatus(paymentInstruments, isUpiEnabled);
        if(deviceFilteredPayments.isEmpty()) {
            return deviceFilteredPayments;
        }
        List<PaymentInstrument> cartLimitFilteredPayments = new ArrayList<>();
        for(PaymentInstrument paymentInstrument : deviceFilteredPayments) {
            PaymentInstrument instrument = cartFilter.filterInstrumentsOnCart(paymentInstrument, cart.getCartDetail().getCartAmount(), cart.getLineOfBusiness());
            if (Objects.nonNull(instrument)) {
                cartLimitFilteredPayments.add(instrument);
            }


        }

        if(cartLimitFilteredPayments.isEmpty()) {
            return cartLimitFilteredPayments;
        }

        return filteredRankingService.getRankedPaymentInstruments(cartLimitFilteredPayments, cart.getLineOfBusiness());
    }
}
