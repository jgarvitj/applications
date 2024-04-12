package com.paymentrecommendation.service.impl;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.enums.PaymentInstrumentType;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.service.FilteredRankingService;

import java.util.*;

public class FilteredRankingServiceImpl implements FilteredRankingService {


    private Map<LineOfBusiness, Map<PaymentInstrumentType, Integer>> getPaymentOrder() {
        Map<LineOfBusiness, String>  lobBasedOrder = new HashMap<>();
        lobBasedOrder.put(LineOfBusiness.CREDIT_CARD_BILL_PAYMENT, "UPI,NETBANKING,DEBIT_CARD");
        lobBasedOrder.put(LineOfBusiness.COMMERCE, "CREDIT_CARD,UPI,DEBIT_CARD");
        lobBasedOrder.put(LineOfBusiness.INVESTMENT, "UPI,NETBANKING,DEBIT_CARD");

        Map<LineOfBusiness, Map<PaymentInstrumentType, Integer>> paymentOrder = new HashMap<>();
        for(LineOfBusiness lob : LineOfBusiness.values()) {
            String orderString = lobBasedOrder.get(lob);
            if(orderString != null && !orderString.isEmpty()) {
                String[] eligibleGateways = orderString.split(",");
                Map<PaymentInstrumentType, Integer> orderMap = new HashMap<>();
                for(int i = 0; i < eligibleGateways.length; i++) {
                    orderMap.put(PaymentInstrumentType.valueOf(eligibleGateways[i]), i);
                }
                paymentOrder.put(lob, orderMap);
            }
        }
        return Collections.unmodifiableMap(paymentOrder);
    }
    @Override
    public List<PaymentInstrument> getRankedPaymentInstruments(List<PaymentInstrument> paymentInstruments, LineOfBusiness lineOfBusiness) {


        List<PaymentInstrument> filteredList = new ArrayList<>();
        Map<PaymentInstrumentType, Integer> order  = getPaymentOrder().get(lineOfBusiness);
        for(PaymentInstrument paymentInstrument : paymentInstruments) {
            if(order.containsKey(paymentInstrument.getPaymentInstrumentType())) {
                filteredList.add(paymentInstrument);
            }
        }

        Collections.sort(filteredList, new Comparator<PaymentInstrument>() {
            @Override
            public int compare(PaymentInstrument o1, PaymentInstrument o2) {
                int orderO1 = order.get(o1.getPaymentInstrumentType());
                int orderO2 = order.get(o2.getPaymentInstrumentType());
                if(orderO2 == orderO1) {
                    return Double.compare(o2.getRelevanceScore(), o1.getRelevanceScore());
                }
                return Integer.compare(orderO1, orderO2);
            }
        });
        return filteredList;
    }


}
