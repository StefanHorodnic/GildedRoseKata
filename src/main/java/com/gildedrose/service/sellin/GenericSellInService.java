package com.gildedrose.service.sellin;

import com.gildedrose.Item;

public class GenericSellInService implements SellInService {
    @Override
    public void update(Item item) {
        item.sellIn--;
    }
}
