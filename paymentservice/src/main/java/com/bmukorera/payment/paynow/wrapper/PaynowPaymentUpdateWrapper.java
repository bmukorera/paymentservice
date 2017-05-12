package com.bmukorera.payment.paynow.wrapper;

import java.io.Serializable;

/**
 * Created by bmukorera on 5/10/2017.
 */
public class PaynowPaymentUpdateWrapper implements Serializable{
    private String reference;
    private double amount;
    private String paynowreference;
    private String pollurl;
    private String status;
    private String hash;

    public PaynowPaymentUpdateWrapper(String reference, double amount, String paynowreference, String pollurl, String status) {
        this.reference = reference;
        this.amount = amount;
        this.paynowreference = paynowreference;
        this.pollurl = pollurl;
        this.status = status;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getPaynowreference() {
        return paynowreference;
    }

    public void setPaynowreference(String paynowreference) {
        this.paynowreference = paynowreference;
    }

    public String getPollurl() {
        return pollurl;
    }

    public void setPollurl(String pollurl) {
        this.pollurl = pollurl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
