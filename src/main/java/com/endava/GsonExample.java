package com.endava;

import com.endava.google.Payment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GsonExample {
    private static final Logger LOGGER = LogManager.getLogger(GsonExample.class);

    public static void main(String[] args) {

        Payment p = new Payment();
        p.setAmount(100.0);
        p.setCurrency("RON");
        p.setCardNumber("999997683683");
        p.setCustomerName("Michael Jackson");

        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(p);
        LOGGER.info("\n{}",json);

        Payment dP = gson.fromJson(json, Payment.class);
        LOGGER.info(p.equals(dP));
        LOGGER.info(dP.getCardNumber());
    }
}
