package com.yourdomain.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.yourdomain.requests.PaynowPaymentUpdateRequest;
import com.yourdomain.services.PaynowPaymentUpdateProcessorService;

//This controller can be used to handle requests from Paynow for payment updates
@RestController
public class PaynowUpdateReceiverController {

    private Logger logger = LoggerFactory.getLogger(PaynowUpdateReceiverController.class);

    private PaynowPaymentUpdateProcessorService updateProcessor;

    public PaynowUpdateReceiverController(@Autowired PaynowPaymentUpdateProcessorService updateProcessor) {
        this.updateProcessor = updateProcessor;
    }

    //The REST endpoint which you should set as the result url
    //Change the value of RequestMapping if you prefer a different name
    //Add your implementation with business logic in com.yourdomain.services.PaynowPaymentUpdateProcessorServiceImpl
    @RequestMapping(
            value = "/paymentupdatereceiver",
            method = RequestMethod.POST,
            produces = {MediaType.ALL_VALUE},
            consumes = {MediaType.ALL_VALUE})
    public void processPaynowUpdate(@RequestBody PaynowPaymentUpdateRequest requestFromPaynow) {
        logger.info("Payment update received from Paynow: " + requestFromPaynow);
        updateProcessor.processPaynowUpdate(requestFromPaynow);
    }

}
