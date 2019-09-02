package com.sda.vendingmachine.storage;

import jdk.jfr.DataAmount;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Item {
    private int id;
    private String name;
    private BigDecimal price;
}
