package com.endava.jackson;

import com.endava.GsonExample;
import com.endava.google.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JacksonExample {

    private static final Logger LOGGER = LogManager.getLogger(GsonExample.class);

    public static void main(String[] args) throws JsonProcessingException {

        Payment p = new Payment();
        p.setAmount(100.0);
        p.setCurrency("EUR");
        p.setCardNumber("9997697683683");
        p.setCustomerName("ION CAMPION");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(p);
        LOGGER.info(json);

        Payment dP = objectMapper.readValue(json, Payment.class);
        LOGGER.info(dP.equals(p));
    }
}
