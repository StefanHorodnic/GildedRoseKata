package com.gildedrose.service.quality;

import com.gildedrose.Item;

import static com.gildedrose.service.quality.QualityServiceUtils.adjustIfOverUpperLimit;
import static com.gildedrose.service.quality.QualityServiceUtils.adjustIfUnderLowerLimit;

public class BackstagePassQualityService implements QualityService {
    @Override
    public void update(Item backstagePass) {
        updateBasedOnSellIn(backstagePass);
        updateBasedOnQuality(backstagePass);
    }

    private void updateBasedOnSellIn(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else {
            increment(item);
        }
    }

    private void increment(Item item) {
        item.quality++;
        incrementIfBelowFirstThreshold(item);
        incrementIfBelowSecondThreshold(item);
    }

    private void incrementIfBelowFirstThreshold(Item item) {
        if (item.sellIn < 10) {
            item.quality++;
        }
    }

    private void incrementIfBelowSecondThreshold(Item item) {
        if (item.sellIn < 5) {
            item.quality++;
        }
    }

    private void updateBasedOnQuality(Item item) {
        adjustIfUnderLowerLimit(item);
        adjustIfOverUpperLimit(item);
    }
}
