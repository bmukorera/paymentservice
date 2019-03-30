package com.yourdomain.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

//This class is used to parse the properties specified in the application.properties
@ConfigurationProperties(prefix = "paynow")
public class PaynowProperties {

    /**
     * Integration details to Paynow as supplied by the merchant.
     */
    private Integration integration;

    /**
     * The URL on the merchant website the customer will be redirected to by Paynow after the transaction
     * has been processed. It is recommended this URL contains enough information for the merchant
     * site to identify the transaction.
     */
    private String returnUrl;

    /**
     * The URL on the merchant website Paynow will post transaction results to. It is recommended this
     * URL contains enough information for the merchant site to identify the transaction.
     */
    private String resultUrl;

    public Integration getIntegration() {
        return integration;
    }

    public void setIntegration(Integration integration) {
        this.integration = integration;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public static class Integration {

        /**
         * Integration key sent to the merchant via email after requesting it in the “3rd Party Site or Link Profile” area of
         * “Receive Payment Links” section of “Sell or Receive” on Paynow.
         */
        private String key;

        /**
         * Integration ID shown to the merchant in the “3rd Party Site or Link Profile” area of “Receive Payment Links”
         * section of “Sell or Receive” on Paynow.
         */
        private String id;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

}