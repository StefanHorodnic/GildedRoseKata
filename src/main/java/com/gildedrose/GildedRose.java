package com.gildedrose;

import static com.gildedrose.ItemUtils.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        updateItemSellIn(item);
        updateItemQuality(item);
    }

    private void updateItemQuality(Item item) {
        if (isNotAgedBrie(item) && isNotBackstagePasses(item)) {
            if (item.quality > 0 && isNotLegendary(item)) {
                item.quality = item.quality - 1;
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (isBackstagePasses(item)) {
                    if (item.sellIn < 10) {
                        item.quality = item.quality + 1;
                    }

                    if (item.sellIn < 5) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (isNotBackstagePasses(item)) {
                    if (item.quality > 0 && isNotLegendary(item)) {
                        item.quality = item.quality - 1;
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private void updateItemSellIn(Item item) {
        if (isNotLegendary(item)) {
            --item.sellIn;
        }
    }


}
