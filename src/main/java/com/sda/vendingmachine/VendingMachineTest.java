package com.sda.vendingmachine;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.implementation.VendingMachineImpl;
import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class VendingMachineTest {
    public static void main(String[] args) {
        Item heidiChocolate = new Item(1, "Ciocolata Heidi", BigDecimal.valueOf(5));
        Item mineralWater = new Item(2, "Mineral Water", BigDecimal.valueOf(7));
        Item cocaCola = new Item(3, "Coca Cola", BigDecimal.valueOf(10));

        //////// randul cu ciocolata Heidi care contine 3 bucati
        Queue<Item> chocolateItemQueue = new ArrayDeque<>();
        chocolateItemQueue.add(heidiChocolate);
        chocolateItemQueue.add(heidiChocolate);
        chocolateItemQueue.add(heidiChocolate);

        Queue<Item> waterItemQueue = new ArrayDeque<>();
        waterItemQueue.add(mineralWater);

        Queue<Item> colaItemQueue = new ArrayDeque<>();
        colaItemQueue.add(cocaCola);

        Map<Integer, Queue<Item>> storageMap = new HashMap<>();
        storageMap.put(22, chocolateItemQueue);
        storageMap.put(23, waterItemQueue);
        storageMap.put(24, colaItemQueue);

        VendingStorage vendingStorage = new VendingStorage(storageMap);
        System.out.println(vendingStorage);

        Bank bank = new Bank();
        Queue<Coin> oneDollars = new ArrayDeque<>();
        oneDollars.add(Coin.ONE_DOLAR);
        oneDollars.add(Coin.ONE_DOLAR);
        oneDollars.add(Coin.ONE_DOLAR);

        Queue<Coin> dimes = new ArrayDeque<>();
        dimes.add(Coin.DIME);

        Queue<Coin> halfs = new ArrayDeque<>();
        halfs.add(Coin.HALF);
        halfs.add(Coin.HALF);

        Queue<Coin> penny = new ArrayDeque<>();
        penny.add(Coin.PENNY);
        penny.add(Coin.PENNY);
        penny.add(Coin.PENNY);

        bank.setOneDollarStack(oneDollars);
        bank.setDimeStack(dimes);
        bank.setHalfStack(halfs);
        bank.setPennyStack(penny);
        bank.setNickelStack(new ArrayDeque<>());
        bank.setQuarterStack(new ArrayDeque<>());

        System.out.println(bank);

        VendingMachineImpl iVendingMachine = new VendingMachineImpl();
        iVendingMachine.setStorage(vendingStorage);
        iVendingMachine.setBank(bank);
        iVendingMachine.getItem(22);
        System.out.println("Produseul este: " + iVendingMachine.getItem(22));
        System.out.println(vendingStorage);

       // System.out.println("Produseul este: " + iVendingMachine.getItem(30));// da sold out exceptions ca nu avem cheia produsului 30
      //  iVendingMachine.getItem(30);// returneaza SoldOutExceptions ca nu avem cheia produsului 30
       // iVendingMachine.getItem(26);// returneaza SoldOutExceptions ca ....


        Queue<Coin> wallet = new ArrayDeque<>();
        wallet.add(Coin.PENNY);
        wallet.add(Coin.DIME);
        wallet.add(Coin.HALF);
        wallet.add(Coin.HALF);
        wallet.add(Coin.HALF);
        wallet.add(Coin.QUARTER);
        wallet.add(Coin.ONE_DOLAR);
        wallet.add(Coin.ONE_DOLAR);
        wallet.add(Coin.ONE_DOLAR);
        wallet.add(Coin.ONE_DOLAR);

        System.out.println(bank);

        iVendingMachine.payItem(24, wallet);

        System.out.println(bank);


    }
}
