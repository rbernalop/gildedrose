package com.gildedrose.value_objects;

public class ItemName {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private final String name;

    public ItemName(String name) {
        this.name = name;
    }

    public boolean isAgedBrie() {
        return name.equals(AGED_BRIE);
    }

    public boolean isBackstagePasses() {
        return name.equals(BACKSTAGE_PASSES);
    }

    public boolean isSulfuras() {
        return name.equals(SULFURAS);
    }
}
