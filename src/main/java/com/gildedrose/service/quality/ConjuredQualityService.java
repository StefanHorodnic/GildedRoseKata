package com.gildedrose.service.quality;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemUtils;

import static com.gildedrose.service.quality.QualityServiceUtils.adjustIfUnderLowerLimit;

public class ConjuredQualityService implements QualityService {
    @Override
    public void update(Item item) {
        item.quality = item.quality - 2;
        decrementIfSellDatePassed(item);
        adjustIfUnderLowerLimit(item);
    }

    private void decrementIfSellDatePassed(Item item) {
        if (ItemUtils.isSellDatePassed(item)) {
            item.quality = item.quality - 2;
        }
    }
}
