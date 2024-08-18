package com.gildedrose.service.quality;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemConstants;
import com.gildedrose.utils.ItemUtils;

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

    private void adjustIfUnderLowerLimit(Item item) {
        if (item.quality < ItemConstants.QUALITY.LOWER_LIMIT) {
            item.quality = 0;
        }
    }
}
