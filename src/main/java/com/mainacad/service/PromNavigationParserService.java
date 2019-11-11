package com.mainacad.service;

import com.mainacad.model.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class PromNavigationParserService extends Thread{
        private List<Thread> threads;
        private List<Item> items;

        public final String url;

        public PromNavigationParserService(List<Thread> threads, List<Item> items, String url) {
            this.threads = threads;
            this.items = items;
            this.url = url;
        }



        @Override
        public void run() {

            Document document = null;
              try {
                    document = Jsoup.connect(url).get();
                  Elements productLinkElements = document.getElementsByAttribute("data-product-url");
                  for (Element element : productLinkElements ) {
                      String itemUrl = element.attr("data-product-url");
                      if (itemUrl != null && !itemUrl.isEmpty()){
                          PromProductParserService promProductParserService = new PromProductParserService(items, itemUrl);
                          threads.add(promProductParserService);
                          promProductParserService.start();
                      }
                  }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
}
