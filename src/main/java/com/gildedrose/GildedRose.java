package com.gildedrose;

class GildedRose {
    Item[] items;
    ItemsService itemsService;

    public GildedRose(Item[] items) {
        this.items = items;
        this.itemsService = new ItemsService();
    }

    public void updateItems() {
        itemsService.update(items);
    }
}
