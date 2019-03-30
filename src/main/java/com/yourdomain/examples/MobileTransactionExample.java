package com.yourdomain.examples;

import org.springframework.beans.factory.annotation.Autowired;
import zw.co.paynow.constants.MobileMoneyMethod;
import zw.co.paynow.core.Payment;
import zw.co.paynow.core.Paynow;
import zw.co.paynow.responses.MobileInitResponse;

public class MobileTransactionExample {

    private Paynow paynow;

    public MobileTransactionExample(@Autowired Paynow paynow) {
        this.paynow = paynow;
    }

    public void example() {
        //Create a new payment passing your own unique reference for that payment (e.g invoice id)
        //You can choose to pass in the email address of the customer whereby Paynow will attempt to auto login the customer using that email at the Paynow website
        //Payment payment = paynow.createPayment("Invoice 35", );
        Payment payment = paynow.createPayment("Invoice 35", "example@example.org");

        //When the payment is created, add the cart items your customer should pay for
        payment.add("Bananas", 2.5);
        payment.add("Apples", 3.4);

        //Initiate the transaction so that the payment can be accepted
        //Response form Paynow will contain various information you could use. See javadocs for more
        MobileInitResponse response = paynow.sendMobile(payment, "0773123456", MobileMoneyMethod.ECOCASH);

        //Check if the request was successful
        if (response.success()) {

            //Instructions on how to make the mobile money payment
            String instructions = response.instructions();

            // Get the poll url of the transaction so you can poll the transaction status later if required
            String pollUrl = response.pollUrl();

        } else {
            // Something went wrong
            System.out.println(response.errors());
        }
    }

}
