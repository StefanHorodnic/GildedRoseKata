package com.gildedrose.service.quality;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemConstants;

public class QualityServiceCommon {
    public static void adjustIfUnderLowerLimit(Item item) {
        if (item.quality < ItemConstants.QUALITY.LOWER_LIMIT) {
            item.quality = 0;
        }
    }
}
