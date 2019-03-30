package com.yourdomain.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.paynow.core.Payment;
import zw.co.paynow.core.Paynow;
import zw.co.paynow.responses.WebInitResponse;

@Service
public class WebTransactionExample {

    private Paynow paynow;

    public WebTransactionExample(@Autowired Paynow paynow) {
        this.paynow = paynow;
    }

    public void example() {

        //Create a new payment passing your own unique reference for that payment (e.g invoice id)
        //You can choose to pass in the email address of the customer whereby Paynow will attempt to auto login the customer using that email at the Paynow website
        //Payment payment = paynow.createPayment("Invoice 35", "example@example.org");
        Payment payment = paynow.createPayment("Invoice 35");

        //When the payment is created, add the cart items your customer should pay for
        payment.add("Bananas", 2.5);
        payment.add("Apples", 3.4);

        //Optionally add a description for the cart, otherwise a description will be generated automatically
        //Generated description will be shown to the user at Paynow website when making a payment
        payment.setCartDescription("Apples and Bananas");

        //Initiate the transaction so that the payment can be accepted
        //Response form Paynow will contain various information you could use. See javadocs for more
        WebInitResponse response = paynow.send(payment);

        //Check if the request was successful
        if (response.success()) {

            //Get the url to redirect the user to so they can make payment
            String redirectURL = response.redirectURL();

            // Get the poll url of the transaction so you can poll the transaction status later if required
            String pollUrl = response.pollUrl();

        } else {
            // Something went wrong
            System.out.println(response.errors());
        }

    }

}
