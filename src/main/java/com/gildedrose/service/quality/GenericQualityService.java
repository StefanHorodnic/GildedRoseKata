package com.gildedrose.service.quality;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemUtils;

import static com.gildedrose.service.quality.QualityServiceUtils.adjustIfUnderLowerLimit;

public class GenericQualityService implements QualityService {
    @Override
    public void updateQuality(Item item) {
        item.quality--;
        decrementIfSellDatePassed(item);
        adjustIfUnderLowerLimit(item);
    }

    private void decrementIfSellDatePassed(Item item) {
        if (ItemUtils.isSellDatePassed(item)) {
            item.quality--;
        }
    }
}
