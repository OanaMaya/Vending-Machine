package com.sda.vendingmachine.implementation;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.exceptions.NotSufficientChangeException;
import com.sda.vendingmachine.exceptions.SoldOutExceptions;
import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VendingMachineImpl implements IVendingMachine {
    private VendingStorage storage;
    private Bank bank;


    public Item getItem(int productCode) {

        // accesam storage map cu get
        // obtinem coada de la cheia cu valoare product code

        Map<Integer, Queue<Item>> myStorageMap = storage.getStorageMap();

        Queue<Item> queueByProductCode = myStorageMap.get(productCode);

        if (queueByProductCode == null || queueByProductCode.size() == 0) {
            throw new SoldOutExceptions(" The product you requested is not availble");
        } else {
            return queueByProductCode.poll();
        }


    }

    public void payItem(int productCode, Queue<Coin> amountPayed) {
        Map<Integer, Queue<Item>> myStorageMap = storage.getStorageMap();

        Queue<Item> queueByProductCode = myStorageMap.get(productCode);

        BigDecimal amountExpected = queueByProductCode.peek().getPrice();

        BigDecimal amountPaidAsBigDecimal = getTotalMoneyAsBigDecimal(amountPayed);

        if (amountPaidAsBigDecimal.compareTo(amountExpected) < 0) {
            throw new NotSufficientChangeException(" You did pay enough.");
        } else {
            bank.updateBank(amountPayed);
        }

    }

    public Queue<Coin> getChange(BigDecimal amountExpected, BigDecimal amountReceived) {
        return null;
    }

    public void CancelRequest() {

    }


    private BigDecimal getTotalMoneyAsBigDecimal(Queue<Coin> money) {
        BigDecimal total = BigDecimal.ZERO;
        for (Coin moneda : money) {
            switch (moneda) {
                case ONE_DOLAR:
                    total = total.add(new BigDecimal(1));
                case HALF:
                    total = total.add(new BigDecimal(0.5));
                case PENNY:
                    total = total.add(new BigDecimal(0.01));
                case DIME:
                    total = total.add(new BigDecimal(0.1));
                case NICKEL:
                    total = total.add(new BigDecimal(0.05));
                case QUARTER:
                    total = total.add(new BigDecimal(0.25));
                    break;
            }
        }

        return total;
    }
}










