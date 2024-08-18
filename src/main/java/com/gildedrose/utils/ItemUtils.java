package com.gildedrose.utils;

import com.gildedrose.Item;

public class ItemUtils {

    public static boolean isSellDatePassed(Item item) {
        return item.sellIn <= 0;
    }

    public static boolean isAgedBrie(Item item) {
        return isTypeByName("Aged Brie", item);
    }

    public static boolean isBackstagePasses(Item item) {
        return isTypeByName("Backstage passes", item);
    }

    public static boolean isLegendary(Item item) {
        return isTypeByName("Sulfuras", item);
    }

    public static boolean isConjured(Item item) {
        return isTypeByName("Conjured", item);
    }

    private static boolean isTypeByName(String type, Item item) {
        String itemName = item.name.toLowerCase();
        return itemName.contains(type.toLowerCase());
    }
}
