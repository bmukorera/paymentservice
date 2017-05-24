package com.bmukorera.payment.paynow.api;

import com.bmukorera.payment.paynow.util.StringUtil;
import com.bmukorera.payment.paynow.wrapper.PaynowPaymentInitialiseRequestWrapper;
import com.bmukorera.payment.paynow.wrapper.PaynowPaymentUpdateWrapper;
import com.bmukorera.payment.paynow.wrapper.PaynowResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * Created by bmukorera on 5/1/2017.
 */

public class Paynow implements PaynowUtilService {

    Logger LOGGER = LoggerFactory.getLogger(PaynowUtilService.class);
    RestTemplate restTemplate;
    Environment environment;



    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
    * This method is called to initialise a payment request with paynow,
    * It returns a response wrapper with the browserurl the customer is to be redirected to
    * to complete the payment
    * @param paynowWrapper input of type PaynowPaymentInitialiseRequestWrapper
    * @return PaynowResponseWrapper returns response in the form of the object PaynowResponseWrapper
     */
    public PaynowResponseWrapper postPaynowPaymentRequest(PaynowPaymentInitialiseRequestWrapper paynowWrapper) {
        PaynowResponseWrapper paynowResponseWrapper = null;
        try {
            MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<String, Object>();
            multiValueMap.add("resulturl", environment.getProperty("paynow.config.webapproot")+"/paynowUpdateReceiver");
            multiValueMap.add("returnurl", paynowWrapper.getReturnurl());
            multiValueMap.add("reference", paynowWrapper.getReference());
            multiValueMap.add("amount", paynowWrapper.getAmount() + "");
            multiValueMap.add("id", paynowWrapper.getId() + "");
            multiValueMap.add("additionalinfo", paynowWrapper.getAdditionalinfo());
            multiValueMap.add("authemail", paynowWrapper.getAuthemail());
            multiValueMap.add("status", "Message");
            String hash = generateTwoWayHash(multiValueMap, environment.getProperty("paynow.integration.key"));
            multiValueMap.add("hash", hash);
            String restResponse = restTemplate.postForObject(environment.getProperty("paynow.url.initialise.transanction"), multiValueMap, String.class);
            LOGGER.info("response from paynow {} ",restResponse);
            return generateGateWayResponse(getResponseAsMap(restResponse));
        } catch (Exception e) {
            LOGGER.error("Exception {}",e);
        }
        return paynowResponseWrapper;
    }

    private Map<String,String> getResponseAsMap(String paynowResponseString){
        return StringUtil.generateMapFromList(StringUtil.splitStringByTag(paynowResponseString,"&") ,"=" );
    }

    /**
    * This method is used to poll for an update on a payment that has been done
    *@return  PaynowPaymentUpdateWrapper object
    * @param pollurl, A String parameter of the poll url that is returned when the payment initialisation is done
    *
     */
    public PaynowPaymentUpdateWrapper postPollRequest(String pollurl){
        String restResponse = restTemplate.postForObject(pollurl,new LinkedMultiValueMap<String, Object>(),String.class);
        LOGGER.info("response from paynow {} ",restResponse);
        return generatePaymentUpdateWrapper(getResponseAsMap(restResponse));
    }

    private String generateTwoWayHash(MultiValueMap<String, Object> dataMapping, String key) {
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, List<Object>> entry : dataMapping.entrySet()) {
            buffer.append(entry.getValue().toString().trim().replace("[","").replace("]",""));
        }
        String joinedValues = buffer.toString();
        String concat = joinedValues + key;
        String utfConcat = concat;
        try {
            utfConcat = new String(concat.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e1) {
            LOGGER.error("Exception {}",e1);
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(utfConcat.getBytes());
        } catch (NoSuchAlgorithmException e) {
           LOGGER.error("Exception {} ",e);
        }
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append((Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)).toUpperCase());
        }
        String result = sb.toString();
        return result;
    }

    private  PaynowResponseWrapper generateGateWayResponse(Map<String, String> map) {
        String status = map.get("status");
        String browserUrl = map.get("browserurl");
        String pollurl = map.get("pollurl");
        String hash = map.get("hash");
        PaynowResponseWrapper response = new PaynowResponseWrapper(browserUrl, pollurl, status, hash);
        return response;
    }

    private PaynowPaymentUpdateWrapper generatePaymentUpdateWrapper(Map<String, String> map){
        try {
            String reference = map.get("reference");
            String amount = map.get("amount");
            String paynowreference = map.get("paynowreference");
            String pollurl = map.get("pollurl");
            String status = map.get("status");
            double amnt= Double.parseDouble(amount);
            return new PaynowPaymentUpdateWrapper(reference,amnt,paynowreference,pollurl,status);
        }catch (NumberFormatException nfe){
            LOGGER.error("exception in parsing response {}",nfe.getMessage());
        }
        return null;
    }

}
