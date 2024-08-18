package com.gildedrose.service.quality;

import com.gildedrose.Item;

import static com.gildedrose.service.quality.QualityServiceUtils.adjustIfOverUpperLimit;

public class AgedBrieQualityService implements QualityService {
    @Override
    public void updateQuality(Item agedBrie) {
        agedBrie.quality++;
        adjustIfOverUpperLimit(agedBrie);
    }
}
