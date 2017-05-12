package com.bmukorera.payment.paynow.util;

import com.bmukorera.payment.config.PayNowConfiguration;
import com.bmukorera.payment.paynow.api.Paynow;
import com.bmukorera.payment.paynow.wrapper.PaynowPaymentInitialiseRequestWrapper;
import com.bmukorera.payment.paynow.wrapper.PaynowResponseWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by bmukorera on 5/1/2017.
 */
//@RunWith(JUnit4.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
@Import(PayNowConfiguration.class)
@Configuration
@WebAppConfiguration
@PropertySource(value = {"classpath:application.properties"})
@TestPropertySource(properties = {
        "paynow.url=https://www.paynow.co.zw/interface/initiatetransaction",
        "paynow.integration.key=2e2437b9-dac5-49ee-9e30-aa1419d1f6ae"
})
public class PaynowTest {

    PaynowPaymentInitialiseRequestWrapper paynowRequestWrapper;
    Paynow paynow;

    RestTemplate restTemplate;

    private Environment environment;



    @Before
    public void setUp() {
    initialiseRequest();
    paynow =new Paynow();
    restTemplate = new RestTemplate();
   // restTemplate =mock(RestTemplate.class);
   environment=mock(Environment.class);
   when(environment.getProperty("paynow.url"))
                .thenReturn("https://www.paynow.co.zw/interface/initiatetransaction");

        when(environment.getProperty("paynow.integration.key"))
                .thenReturn("2e2437b9-dac5-49ee-9e30-aa1419d1f6ae");

        paynow.setEnvironment(environment);
    paynow.setRestTemplate(restTemplate);

    }


        @Bean
        public static PropertySourcesPlaceholderConfigurer properties() {
            PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
            Properties properties = new Properties();

            properties.setProperty("paynow.url", "https://www.paynow.co.zw/interface/initiatetransaction");
            properties.setProperty("paynow.integration.key","2e2437b9-dac5-49ee-9e30-aa1419d1f6ae");

            propertySourcesPlaceholderConfigurer.setProperties(properties);
           // propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("application.properties"));
            return propertySourcesPlaceholderConfigurer;
        }


    @Test
    public void testPostPaynowPaymentRequest(){
        PaynowResponseWrapper paynowResponseWrapper = paynow.postPaynowPaymentRequest(paynowRequestWrapper);
        assertThat(paynowResponseWrapper.getStatus(),equalTo("Ok"));
    }


    private void initialiseRequest(){
        paynowRequestWrapper= new PaynowPaymentInitialiseRequestWrapper();
        /*paynowRequestWrapper.setId(1);
        paynowRequestWrapper.setAdditionalinfo("additionalinfo");
        paynowRequestWrapper.setAmount(1.0);
        paynowRequestWrapper.setAuthemail("test@bmukorera.com");
        paynowRequestWrapper.setHash("hash");
        paynowRequestWrapper.setReference("reference");
        paynowRequestWrapper.setResulturl("resulturl");
        paynowRequestWrapper.setReturnurl("returnurl");
        paynowRequestWrapper.setStatus("status");*/


        paynowRequestWrapper.setAdditionalinfo("test payment");
        paynowRequestWrapper.setAmount(0.50);
        paynowRequestWrapper.setReturnurl("http://cleanwater.bmukorera.com:8080:/paynow/payment/update/payment2/");
        paynowRequestWrapper.setId(2216);
        paynowRequestWrapper.setReference("devtestde5");
        paynowRequestWrapper.setResulturl("http://cleanwater.bmukorera.com:8080:/paynow/payment/update/payment2/");
        paynowRequestWrapper.setStatus("Message");
        paynowRequestWrapper.setAuthemail("test@bmukorera.com");
    }

}