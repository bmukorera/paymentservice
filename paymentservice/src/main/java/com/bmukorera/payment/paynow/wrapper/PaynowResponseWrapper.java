package com.bmukorera.payment.paynow.wrapper;

import java.io.Serializable;

/**
 * Created by bmukorera on 5/1/2017.
 */
public class PaynowResponseWrapper implements Serializable{
    private String browserurl;
    private String pollurl;
    private String status;
    private String hash;

    public PaynowResponseWrapper(String browserurl, String pollurl, String status, String hash) {
        this.browserurl = browserurl;
        this.pollurl = pollurl;
        this.status = status;
        this.hash = hash;
    }

    public String getBrowserurl() {
        return browserurl;
    }

    public void setBrowserurl(String browserurl) {
        this.browserurl = browserurl;
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
