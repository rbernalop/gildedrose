package com.gildedrose.value_objects;

public class ItemQuality {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private int quality;

    public ItemQuality(int quality) {
        if (quality <= MAX_QUALITY && quality >= MIN_QUALITY)
            this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public void increase() {
        if (quality < MAX_QUALITY)
            quality++;
    }

    public void decrease() {
        if (quality > MIN_QUALITY)
            quality--;
    }

    public void reset() {
        quality = MIN_QUALITY;
    }
}
