package com.bmukorera.payment.paynow.wrapper;

import java.io.Serializable;

/**
 * Created by bmukorera on 5/1/2017.
 */
public class PaynowPaymentInitialiseRequestWrapper implements Serializable {
    private int id;
    private String reference;
    private double amount;
    private String additionalinfo;
    private String returnurl;
    private String resulturl;
    private String status;
    private String hash;
    private String authemail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

    public String getReturnurl() {
        return returnurl;
    }

    public void setReturnurl(String returnurl) {
        this.returnurl = returnurl;
    }

    public String getResulturl() {
        return resulturl;
    }

    public void setResulturl(String resulturl) {
        this.resulturl = resulturl;
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

    public String getAuthemail() {
        return authemail;
    }

    public void setAuthemail(String authemail) {
        this.authemail = authemail;
    }
}
