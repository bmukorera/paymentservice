package com.bmukorera.payment.paynow.api;

import com.bmukorera.payment.paynow.wrapper.PaynowPaymentUpdateWrapper;

/**
 * Created by bmukorera on 5/11/2017.
 */
public interface PaynowReceiverProcessorService {
     void processPaynowUpdate(PaynowPaymentUpdateWrapper paynowPaymentUpdateWrapper);
}
