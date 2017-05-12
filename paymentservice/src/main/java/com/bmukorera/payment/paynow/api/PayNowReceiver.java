package com.bmukorera.payment.paynow.api;

import com.bmukorera.payment.paynow.wrapper.PaynowPaymentUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bmukorera on 5/11/2017.
 */
@RestController
public class PayNowReceiver {

    @Autowired
    PaynowReceiverProcessorService paynowReceiverProcessorService;

        @RequestMapping(value = "/paynowUpdateReceiver",method = RequestMethod.POST,
                produces = {MediaType.ALL_VALUE},consumes = {MediaType.ALL_VALUE})
        @ResponseBody
        public void processPaynowUpdate(@RequestBody PaynowPaymentUpdateWrapper paynowPaymentUpdateWrapper){
         paynowReceiverProcessorService.processPaynowUpdate(paynowPaymentUpdateWrapper);
        }

}
