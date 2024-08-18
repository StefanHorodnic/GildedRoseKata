package com.gildedrose;

public class ItemUtils {

    public static boolean isAgedBrie(Item item) {
        return isItemByType("Aged Brie", item);
    }

    public static boolean isBackstagePass(Item item) {
        return isItemByType("Backstage passes", item);
    }

    public static boolean isLegendary(Item item) {
        return isItemByType("Sulfuras", item);
    }

    public static boolean isNotAgedBrie(Item item) {
        return !isAgedBrie(item);
    }

    public static boolean isNotBackstagePass(Item item) {
        return !isBackstagePass(item);
    }

    public static boolean isNotLegendary(Item item) {
        return !isLegendary(item);
    }

    private static boolean isItemByType(String type, Item item) {
        String itemName = item.name.toLowerCase();
        return itemName.contains(type.toLowerCase());
    }
}
