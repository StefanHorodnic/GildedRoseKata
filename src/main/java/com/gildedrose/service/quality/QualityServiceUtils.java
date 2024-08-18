package com.gildedrose.service.quality;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemConstants;

public class QualityServiceUtils {
    public static void adjustIfUnderLowerLimit(Item item) {
        if (item.quality < ItemConstants.QUALITY.LOWER_LIMIT) {
            item.quality = ItemConstants.QUALITY.LOWER_LIMIT;
        }
    }

    public static void adjustIfOverUpperLimit(Item agedBrie) {
        if (agedBrie.quality > ItemConstants.QUALITY.UPPER_LIMIT) {
            agedBrie.quality = ItemConstants.QUALITY.UPPER_LIMIT;
        }
    }
}
