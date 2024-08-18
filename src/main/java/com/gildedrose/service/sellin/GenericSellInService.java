package com.gildedrose.service.sellin;

import com.gildedrose.Item;

public class GenericSellInService implements SellInService {
    @Override
    public void updateSellIn(Item item) {
        item.sellIn--;
    }
}
