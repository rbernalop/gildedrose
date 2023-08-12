package com.gildedrose.entity;

public class Unknown extends Item {
    private final static int SELL_IN_THRESHOLD_TO_DECREASE_QUALITY = 0;

    public Unknown(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseQuality();
        decreaseSellIn();
        if (sellIn() < SELL_IN_THRESHOLD_TO_DECREASE_QUALITY) {
            decreaseQuality();
        }
    }
}
