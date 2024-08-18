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
    void GivenItemOfTypeConjured_WhenIsConjuredIsCalled_ReturnsTrue() {
        Item item = new Item("conjured", 2, 3);
        Item item2 = new Item("Conjured", 2, 3);

        assertAll(
            () -> assertTrue(isConjured(item)),
            () -> assertTrue(isConjured(item2))
        );
    }
}
