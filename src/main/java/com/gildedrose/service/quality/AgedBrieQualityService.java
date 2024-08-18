package com.gildedrose.service.quality;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemConstants;

public class AgedBrieQualityService implements QualityService {
    @Override
    public void updateQuality(Item agedBrie) {
        agedBrie.quality++;
        adjustIfOverUpperLimit(agedBrie);
    }

    private void adjustIfOverUpperLimit(Item agedBrie) {
        if (agedBrie.quality > ItemConstants.QUALITY.UPPER_LIMIT) {
            agedBrie.quality = 50;
        }
    }
}
