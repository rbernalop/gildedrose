package com.gildedrose.entity;

public class BackstagePasses extends Item {
    private final static int SELL_IN_THRESHOLD_TO_RESET_QUALITY = 0;
    private final static int SELL_IN_THRESHOLD_TO_INCREASE_QUALITY = 11;
    private final static int SELL_IN_THRESHOLD_TO_DOUBLE_INCREASE_QUALITY = 6;

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        increaseQuality();
        decreaseSellIn();
        if (sellIn() < SELL_IN_THRESHOLD_TO_INCREASE_QUALITY) {
            increaseQuality();
        }
        if (sellIn() < SELL_IN_THRESHOLD_TO_DOUBLE_INCREASE_QUALITY) {
            increaseQuality();
        }

        if (sellIn() < SELL_IN_THRESHOLD_TO_RESET_QUALITY) {
            resetQuality();
        }
    }


}
