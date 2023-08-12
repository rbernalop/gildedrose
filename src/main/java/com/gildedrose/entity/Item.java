package com.gildedrose.entity;

import com.gildedrose.value_objects.ItemName;
import com.gildedrose.value_objects.ItemQuality;
import com.gildedrose.value_objects.ItemSellIn;

public abstract class Item {

    private final ItemName name;

    private ItemSellIn sellIn;

    private final ItemQuality quality;

    public Item(String name, int sellIn, int quality) {
        this.name = new ItemName(name);
        this.sellIn = new ItemSellIn(sellIn);
        this.quality = new ItemQuality(quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public abstract void update();

    public void increaseQuality() {
        quality.increase();
    }

    public void decreaseQuality() {
        quality.decrease();
    }

    public void resetQuality() {
        quality.reset();
    }

    public void decreaseSellIn() {
        sellIn = new ItemSellIn(sellIn.sellIn() - 1);
    }

    public int sellIn() {
        return sellIn.sellIn();
    }

    public int quality() {
        return quality.getQuality();
    }
}
