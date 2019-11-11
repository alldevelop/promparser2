package com.mainacad;

import com.mainacad.model.Item;
import com.mainacad.service.PromProductParserService;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class AppFunner{

    private static final Logger LOGGER = Logger.getLogger(AppFunner.class.getName());

    public static void main( String[] args ) {
        List<Item> items = Collections.synchronizedList(new ArrayList<>());

             String url = "https://prom.ua/ua/p991729133-noutbuk-omen-dc1003ua.html";

        PromProductParserService promProductParserService =
                new PromProductParserService(items, url);
        promProductParserService.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!items.isEmpty()) {
            LOGGER.info(items.get(0).getItemId());
            LOGGER.info(items.get(0).getName());
            LOGGER.info(String.valueOf(items.get(0).getPrice()));
            LOGGER.info(String.valueOf(items.get(0).getInitialPrice()));
            LOGGER.info(items.get(0).getAvailability());
            LOGGER.info(items.get(0).getImageUrl());

        }


    }

}
