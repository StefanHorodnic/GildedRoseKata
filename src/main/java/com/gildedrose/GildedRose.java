package com.gildedrose;

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
        if (!item.name.equals("Aged Brie")
            && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (isNotLegendary(item)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (isNotLegendary(item)) {
                            item.quality = item.quality - 1;
                        }
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
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            --item.sellIn;
        }
    }

    private boolean isNotLegendary(Item item) {
        return !isLegendary(item);
    }

    private boolean isLegendary(Item item) {
        return item.name.startsWith("Sulfuras");
    }
}
