package com.gildedrose.service.sellin;

import com.gildedrose.Item;
import com.gildedrose.service.sellin.GenericSellInService;
import com.gildedrose.service.sellin.LegendarySellInService;
import com.gildedrose.service.sellin.SellInService;

import static com.gildedrose.utils.ItemUtils.*;

public class SellInServiceProvider {
    /**
     * Gets the SellInService based on item type
     *
     * @param item
     * @return
     */
    public static SellInService get(Item item) {
        if (isLegendary(item)) {
            return new LegendarySellInService();
        }
        return new GenericSellInService();
    }
}
