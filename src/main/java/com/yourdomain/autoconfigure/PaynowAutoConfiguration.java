package com.yourdomain.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.paynow.core.Paynow;

//This class is used to autoconfigure the Paynow bean you can inject across your project
@Configuration
@ConditionalOnClass(Paynow.class)
@ConditionalOnMissingBean(Paynow.class)
@EnableConfigurationProperties(PaynowProperties.class)
public class PaynowAutoConfiguration {

    private static Logger logger = LoggerFactory.getLogger(PaynowAutoConfiguration.class);

    @Bean
    public Paynow paynow(PaynowProperties properties) {

        try {
            if (isNotNullOrEmpty(properties.getIntegration().getId()) && isNotNullOrEmpty(properties.getIntegration().getId())) {
                logger.info("Paynow auto-configuration has been effected with " + "integration Id: " + properties.getIntegration().getId());
                return new Paynow(properties.getIntegration().getId(), properties.getIntegration().getKey());
            } else {
                throw new BeanCreationException("Failed to create Paynow bean. Please specify a value for integration ID and integration key in your application properties file.");
            }
        } catch (NullPointerException ex) {
            throw new BeanCreationException("Failed to create Paynow bean. Please add the require properties of an integration ID and integration key in your application properties file.");
        }

    }

    private static boolean isNotNullOrEmpty(String str) {
        return str != null || !str.trim().isEmpty();
    }

}