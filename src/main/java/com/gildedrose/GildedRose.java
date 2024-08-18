package com.gildedrose;

import com.gildedrose.service.items.ItemsService;

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
