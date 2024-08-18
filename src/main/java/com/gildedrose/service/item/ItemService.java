package com.gildedrose.service.item;

import com.gildedrose.Item;
import com.gildedrose.service.quality.provider.QualityServiceProvider;
import com.gildedrose.service.quality.QualityService;
import com.gildedrose.service.sellin.SellInService;
import com.gildedrose.service.sellin.provider.SellInServiceProvider;

public class ItemService {

    public void updateItem(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }

    private void updateSellIn(Item item) {
        SellInService service = SellInServiceProvider.get(item);
        service.updateSellIn(item);
    }

    private void updateQuality(Item item) {
        QualityService qualityService = QualityServiceProvider.get(item);
        qualityService.updateQuality(item);
    }
}
