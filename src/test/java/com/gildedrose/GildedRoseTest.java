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

    @Test
    void GivenQualityIncreasingItem_WhenUpdateQuality_QualityDoesNotExceedFifty() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 3, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertAll(
            () -> assertEquals(50, items[0].quality),
            () -> assertEquals(50, items[1].quality)
        );
    }

    @Test
    void GivenLegendaryItem_WhenUpdateQuality_QualityAndSellInDoNotAlter() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 3, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items[0];
        Assertions.assertAll(
            () -> assertEquals(80, item.quality),
            () -> assertEquals(3, item.sellIn)
        );
    }

    @Test
    void GivenBackstagePassesItemWithSellInLessThenTenAndMoreThenFive_WhenUpdateQuality_QualityIncreasesByTwo() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, items[0].quality);
    }

    @Test
    void GivenBackstagePassesItemWithSellInEqualToTen_WhenUpdateQuality_QualityIncreasesByTwo() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, items[0].quality);
    }

    @Test
    void GivenBackstagePassesItemWithSellInLessThenFiveAndMoreThenZero_WhenUpdateQuality_QualityIncreasesByThree() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, items[0].quality);
    }

    @Test
    void GivenBackstagePassesItemWithSellInEqualToFive_WhenUpdateQuality_QualityIncreasesByThree() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, items[0].quality);
    }

    @Test
    void GivenBackstagePassesItemWithSellInIsZero_WhenUpdateQuality_QualityIsZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    void GivenBackstagePassesItemWithSellInLessThenZero_WhenUpdateQuality_QualityIsZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }
}
