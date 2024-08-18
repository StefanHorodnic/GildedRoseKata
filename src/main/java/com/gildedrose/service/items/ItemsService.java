package com.gildedrose.service.items;

import com.gildedrose.Item;
import com.gildedrose.service.item.ItemService;

public class ItemsService {
    ItemService itemService;

    public ItemsService() {
        itemService = new ItemService();
    }

    public void update(Item[] items){
        for (Item item : items) {
            itemService.updateItem(item);
        }
    }
}
