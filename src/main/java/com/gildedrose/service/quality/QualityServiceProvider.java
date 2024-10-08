package com.gildedrose.service.quality;

import com.gildedrose.Item;

import static com.gildedrose.utils.ItemUtils.*;

public class QualityServiceProvider {
    public static QualityService get(Item item) {
        if (isBackstagePasses(item)) {
            return new BackstagePassQualityService();
        }
        if (isAgedBrie(item)) {
            return new AgedBrieQualityService();
        }
        if (isLegendary(item)) {
            return new LegendaryQualityService();
        }
        if (isConjured(item)) {
            return new ConjuredQualityService();
        }
        return new GenericQualityService();
    }
}
