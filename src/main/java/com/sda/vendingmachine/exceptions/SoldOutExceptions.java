package com.sda.vendingmachine.exceptions;

public class SoldOutExceptions extends RuntimeException {
    public SoldOutExceptions(String mesages){
        super(mesages);

    }
}
