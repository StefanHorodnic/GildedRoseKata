package com.gildedrose;

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
