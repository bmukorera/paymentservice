package com.bmukorera.payment.paynow.api;

import com.bmukorera.payment.paynow.wrapper.PaynowPaymentInitialiseRequestWrapper;
import com.bmukorera.payment.paynow.wrapper.PaynowResponseWrapper;

/**
 * Created by bmukorera on 5/2/2017.
 */
public interface PaynowUtilService {
     PaynowResponseWrapper postPaynowPaymentRequest(PaynowPaymentInitialiseRequestWrapper paynowWrapper);
}
