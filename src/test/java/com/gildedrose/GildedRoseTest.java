package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void GivenFooItem_WhenUpdateItems_QualityAndSellInDecreaseByOne() {
        Item[] items = new Item[]{new Item("foo", 2, 3)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        Item item = items[0];
        Assertions.assertAll(
            () -> assertEquals(1, item.sellIn),
            () -> assertEquals(2, item.quality)
        );
    }

    @Test
    void GivenFooItemAfterSellDate_WhenUpdateItems_QualityDecreaseByTwo() {
        Item[] items = new Item[]{new Item("foo", 0, 3)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        Item item = items[0];
        assertEquals(1, item.quality);
    }

    @Test
    void GivenFooItem_WhenUpdateItems_QualityIsNeverNegative() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        Item item = items[0];
        assertEquals(0, item.quality);
    }

    @Test
    void GivenAgedBrieItem_WhenUpdateItems_QualityIsIncreased() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        Item item = items[0];
        assertEquals(6, item.quality);
    }

    @Test
    void GivenQualityIncreasingItem_WhenUpdateItems_QualityDoesNotExceedFifty() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 3, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateItems();
        Assertions.assertAll(
            () -> assertEquals(50, items[0].quality),
            () -> assertEquals(50, items[1].quality)
        );
    }

    @Test
    void GivenLegendaryItem_WhenUpdateItems_QualityAndSellInDoNotAlter() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 3, 80)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        Item item = items[0];
        Assertions.assertAll(
            () -> assertEquals(80, item.quality),
            () -> assertEquals(3, item.sellIn)
        );
    }

    @Test
    void GivenBackstagePassesItemWithSellInLessThenTenAndMoreThenFive_WhenUpdateItems_QualityIncreasesByTwo() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(12, items[0].quality);
    }

    @Test
    void GivenBackstagePassesItemWithSellInEqualToTen_WhenUpdateItems_QualityIncreasesByTwo() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(12, items[0].quality);
    }

    @Test
    void GivenBackstagePassesItemWithSellInLessThenFiveAndMoreThenZero_WhenUpdateItems_QualityIncreasesByThree() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(13, items[0].quality);
    }

    @Test
    void GivenBackstagePassesItemWithSellInEqualToFive_WhenUpdateItems_QualityIncreasesByThree() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(13, items[0].quality);
    }

    @Test
    void GivenBackstagePassesItemWithSellInIsZero_WhenUpdateItems_QualityIsZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(0, items[0].quality);
    }

    @Test
    void GivenBackstagePassesItemWithSellInLessThenZero_WhenUpdateItems_QualityIsZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(0, items[0].quality);
    }

    @Test
    void GivenConjuredItemWithPositiveSellIn_WhenUpdateItems_QualityDecreasesByTwo() {
        Item[] items = new Item[]{new Item("Conjured", 4, 10)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(8, items[0].quality);
    }

    @Test
    void GivenConjuredItemWithNegativeSellIn_WhenUpdateItems_QualityDecreasesByTwo() {
        Item[] items = new Item[]{new Item("Conjured", -3, 10)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(6, items[0].quality);
    }
}
