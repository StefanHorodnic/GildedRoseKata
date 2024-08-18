package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void GivenFooItem_WhenUpdateQuality_QualityAndSellInDecreesByOne() {
        Item[] items = new Item[]{new Item("foo", 2, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items[0];
        Assertions.assertAll(
            () -> assertEquals(1, item.sellIn),
            () -> assertEquals(2, item.quality)
        );
    }
}
