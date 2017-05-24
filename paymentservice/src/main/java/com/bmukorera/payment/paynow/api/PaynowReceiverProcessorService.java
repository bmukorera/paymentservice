package com.bmukorera.payment.paynow.api;

import com.bmukorera.payment.paynow.wrapper.PaynowPaymentUpdateWrapper;

/**
 * Created by bmukorera on 5/11/2017.
 * This interface has to be implemented so that one is able to receive updateds from paynow and handle them as they wish
 */
public interface PaynowReceiverProcessorService {

     void processPaynowUpdate(PaynowPaymentUpdateWrapper paynowPaymentUpdateWrapper);
}
