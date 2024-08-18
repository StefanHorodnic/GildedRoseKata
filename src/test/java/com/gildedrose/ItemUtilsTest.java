package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.utils.ItemUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemUtilsTest {

    @Test
    void GivenItemOfTypeAgedBrie_WhenIsAgedBrieIsCalled_ReturnsTrue() {
        Item item = new Item("Foo Aged Brie", 2, 3);
        Item item2 = new Item("aged Brie Foo", 2, 3);
        Item item3 = new Item("aged brie", 2, 3);

        assertAll(
            () -> assertTrue(isAgedBrie(item)),
            () -> assertTrue(isAgedBrie(item2)),
            () -> assertTrue(isAgedBrie(item3))
        );
    }

    @Test
    void GivenItemOfTypeBackstagePasses_WhenIsBackstagePassIsCalled_ReturnsTrue() {
        Item item = new Item("Foo Backstage passes", 2, 3);
        Item item2 = new Item("backstage passes Foo", 2, 3);
        Item item3 = new Item("Backstage Passes", 2, 3);

        assertAll(
            () -> assertTrue(isBackstagePasses(item)),
            () -> assertTrue(isBackstagePasses(item2)),
            () -> assertTrue(isBackstagePasses(item3))
        );
    }

    @Test
    void GivenItemOfTypeLegendary_WhenIsLegendaryIsCalled_ReturnsTrue() {
        Item item = new Item("Sulfuras fooo", 2, 3);
        Item item2 = new Item("Foo Sulfuras", 2, 3);
        Item item3 = new Item("sulfuras", 2, 3);

        assertAll(
            () -> assertTrue(isLegendary(item)),
            () -> assertTrue(isLegendary(item2)),
            () -> assertTrue(isLegendary(item3))
        );
    }

    @Test
    void GivenItemNotOfTypeAgedBrie_WhenIsNotAgedBrieIsCalled_ReturnsTrue() {
        Item item = new Item("Foo Brie", 2, 3);
        Item item2 = new Item("aged Foo", 2, 3);
        Item item3 = new Item("foo", 2, 3);

        assertAll(
            () -> assertTrue(isNotAgedBrie(item)),
            () -> assertTrue(isNotAgedBrie(item2)),
            () -> assertTrue(isNotAgedBrie(item3))
        );
    }

    @Test
    void GivenItemNotOfTypeBackstagePasses_WhenIsNotBackstagePassIsCalled_ReturnsTrue() {
        Item item = new Item("Foo passes", 2, 3);
        Item item2 = new Item("Foo", 2, 3);
        Item item3 = new Item("Backstage", 2, 3);

        assertAll(
            () -> assertTrue(isNotBackstagePasses(item)),
            () -> assertTrue(isNotBackstagePasses(item2)),
            () -> assertTrue(isNotBackstagePasses(item3))
        );
    }

    @Test
    void GivenItemNotOfTypeLegendary_WhenIsNotLegendaryIsCalled_ReturnsTrue() {
        Item item = new Item("fooo", 2, 3);
        Item item2 = new Item("Foo furas", 2, 3);

        assertAll(
            () -> assertTrue(isNotLegendary(item)),
            () -> assertTrue(isNotLegendary(item2))
        );
    }
}
