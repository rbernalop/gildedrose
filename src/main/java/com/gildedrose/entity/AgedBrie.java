package com.gildedrose.entity;

public class AgedBrie extends Item {
    private final static int SELL_IN_THRESHOLD_TO_RESET_QUALITY = 0;

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void update() {
        increaseQuality();
        decreaseSellIn();
        if (sellIn() < SELL_IN_THRESHOLD_TO_RESET_QUALITY) {
            increaseQuality();
        }
    }
}
