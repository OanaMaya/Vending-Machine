package com.sda.vendingmachine.storage;

import java.util.Map;
import java.util.Queue;

@AllArgsConstructor
@NoArgsConstructor

public class VendingStorage {
    Map<Integer, Queue<Item>> storageMap;
}
