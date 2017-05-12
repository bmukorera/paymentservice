package com.bmukorera.payment.config;

import com.bmukorera.payment.paynow.api.Paynow;
import com.bmukorera.payment.paynow.api.PaynowUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bmukorera on 5/2/2017.
 */
@Configuration
public class PayNowConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public PaynowUtilService paynowUtil(RestTemplate restTemplate){
        Paynow paynowService = new Paynow();
        paynowService.setRestTemplate(restTemplate);
        paynowService.setEnvironment(environment);
        return paynowService;
    }

}
