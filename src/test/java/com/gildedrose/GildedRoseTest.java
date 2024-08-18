package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void GivenFooItem_WhenUpdateQuality_QualityAndSellInDecreaseByOne() {
        Item[] items = new Item[]{new Item("foo", 2, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items[0];
        Assertions.assertAll(
            () -> assertEquals(1, item.sellIn),
            () -> assertEquals(2, item.quality)
        );
    }

    @Test
    void GivenFooItemAfterSellDate_WhenUpdateQuality_QualityDecreaseByTwo() {
        Item[] items = new Item[]{new Item("foo", 0, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items[0];
        assertEquals(1, item.quality);
    }

    @Test
    void GivenFooItem_WhenUpdateQuality_QualityIsNeverNegative() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items[0];
        assertEquals(0, item.quality);
    }

    @Test
    void GivenAgedBrieItem_WhenUpdateQuality_QualityIsIncreased() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items[0];
        assertEquals(6, item.quality);
    }
}
