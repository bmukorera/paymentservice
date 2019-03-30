package com.yourdomain.services;

import com.yourdomain.requests.PaynowPaymentUpdateRequest;

public interface PaynowPaymentUpdateProcessorService {

    void processPaynowUpdate(PaynowPaymentUpdateRequest request);

}
