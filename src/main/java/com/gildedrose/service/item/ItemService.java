package com.gildedrose.service.item;

import com.gildedrose.Item;
import com.gildedrose.service.quality.QualityServiceProvider;
import com.gildedrose.service.quality.QualityService;
import com.gildedrose.service.sellin.SellInService;
import com.gildedrose.service.sellin.SellInServiceProvider;

public class ItemService {

    public void updateItem(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }

    private void updateSellIn(Item item) {
        SellInService sellInService = SellInServiceProvider.get(item);
        sellInService.update(item);
    }

    private void updateQuality(Item item) {
        QualityService qualityService = QualityServiceProvider.get(item);
        qualityService.update(item);
    }
}
