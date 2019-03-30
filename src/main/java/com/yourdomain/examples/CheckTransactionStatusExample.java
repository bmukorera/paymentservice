package com.yourdomain.examples;

import org.springframework.beans.factory.annotation.Autowired;
import zw.co.paynow.core.Paynow;
import zw.co.paynow.responses.StatusResponse;

public class CheckTransactionStatusExample {

    private Paynow paynow;

    private String pollUrl;

    public CheckTransactionStatusExample(@Autowired Paynow paynow, String pollUrl) {
        this.paynow = paynow;
        this.pollUrl = pollUrl;
    }

    public void example() {

        //Checking if the payment has been paid by getting the detailed status
        StatusResponse status = paynow.pollTransaction(pollUrl);

        //Use the paid method to check if the transaction was paid
        if (status.paid()) {
            // Yay! Transaction was paid for
        } else {
            System.out.println("Why you no pay?");
        }

    }

}
