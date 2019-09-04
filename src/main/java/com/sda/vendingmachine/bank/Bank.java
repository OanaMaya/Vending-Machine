package com.sda.vendingmachine.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Bank {

    private Queue<Coin> pennyStack;
    private Queue<Coin> nickelStack;
    private Queue<Coin> dimeStack;
    private Queue<Coin> quarterStack;
    private Queue<Coin> halfStack;
    private Queue<Coin> oneDollarStack;



    @Override
        public String toString() {
            double total = (pennyStack.size() * 0.01) + (nickelStack.size() * 0.05) + (dimeStack.size() * 0.10) +
                    (halfStack.size() * 0.50) + (quarterStack.size() * 0.25) + (oneDollarStack.size() * 1);
            return "\n" + "Amount of money in the bank " +
                    "\n" + "Penny: " + pennyStack.size() +
                    "\n" + "Nickles: " + nickelStack.size() +
                    "\n" + "Dimes: " + dimeStack.size() +
                    "\n" + "Half: " + halfStack.size() +
                    "\n" + "Quarters: " + quarterStack.size() +
                    "\n" + "Dollars: " + oneDollarStack.size() +
                    "\n" + "Total: " + total;
        }


    public void updateBank(Queue<Coin> money) {
        BigDecimal total = BigDecimal.ZERO;
        for (Coin moneda : money) {

            switch (moneda) {
                case ONE_DOLAR:
                    oneDollarStack.add(moneda);
                case HALF:
                    halfStack.add(moneda);
                case PENNY:
                    pennyStack.add(moneda);
                case DIME:
                    dimeStack.add(moneda);
                case NICKEL:
                    dimeStack.add(moneda);
                case QUARTER:
                    quarterStack.add(moneda);
                    break;
            }


        }

    }
}


