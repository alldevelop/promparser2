package com.mainacad.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String itemId;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private BigDecimal initialPrice;
    private String availability;
    private String url;

    public Item(String itemId, String name, String url, String imageUrl, BigDecimal price, BigDecimal initPrice, String availability) {
    }
}