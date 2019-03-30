package com.yourdomain.services;

import org.springframework.stereotype.Service;
import com.yourdomain.requests.PaynowPaymentUpdateRequest;

//Add your implementation with business logic in this class
@Service
public class PaynowPaymentUpdateProcessorServiceImpl implements PaynowPaymentUpdateProcessorService{

    @Override
    public void processPaynowUpdate(PaynowPaymentUpdateRequest request) {
        //your logic here on what to do when payment is received
        //maybe save the payment information in database?
        //maybe send the customer an SMS notifying that payment has been received?
    }

}
