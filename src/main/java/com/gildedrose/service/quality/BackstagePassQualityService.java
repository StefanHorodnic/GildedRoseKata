package com.gildedrose.service.quality;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemConstants;

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
        if (item.quality > ItemConstants.QUALITY.UPPER_LIMIT) {
            item.quality = ItemConstants.QUALITY.UPPER_LIMIT;
        }
        if (item.quality < ItemConstants.QUALITY.LOWER_LIMIT) {
            item.quality = 0;
        }
    }
}
