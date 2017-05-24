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

    /**
     *Integration ID shown to the merchant in the “3rd Party Site or Link
     *Profile” area of “Receive Payment Links” section of “Sell or
     *Receive” on Paynow.
     *
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * The transaction’s reference on the merchant site, this should be
     *unique to the transaction
     */
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Final amount of the transaction, in USD to two decimal places (do
     *not include a currency symbol)
     */
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * (optional) Additional info to be displayed on Paynow to the
     *Customer. This should not include any confidential information
     */
    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }
    /**
     * The URL on the merchant website the customer will be returned to
     *after the transaction has been processed. It is recommended this
     *URL contains enough information for the merchant site to identify
     *the transaction
     */
    public String getReturnurl() {
        return returnurl;
    }

    public void setReturnurl(String returnurl) {
        this.returnurl = returnurl;
    }
    /**
     * no need to set this as this is set by the api, based on config parameters
     * */
    public String getResulturl() {
        return resulturl;
    }

    public void setResulturl(String resulturl) {
        this.resulturl = resulturl;
    }

    /**
     * no need to set this as this is set by the api
     * */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This will be handled by the API, do not set anything here
     * */
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     *(optional) If the field is present and set to an email address
     *Paynow will attempt to auto login the customers email address as
     *an anonymous user. If the email address has a registered account
     *the user will be prompted to login to that account
     */
    public String getAuthemail() {
        return authemail;
    }

    public void setAuthemail(String authemail) {
        this.authemail = authemail;
    }
}
