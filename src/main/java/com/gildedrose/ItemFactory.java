package com.gildedrose;

import com.gildedrose.entity.*;
import com.gildedrose.value_objects.ItemName;

public class ItemFactory {
    public static Item from(String name, int sellIn, int quality) {
        ItemName itemName = new ItemName(name);
        if(itemName.isAgedBrie()) return new AgedBrie(name, sellIn, quality);
        if (itemName.isBackstagePasses()) return new BackstagePasses(name, sellIn, quality);
        if (itemName.isSulfuras()) return new Sulfuras(name, sellIn, quality);
        return new Unknown(name, sellIn, quality);
    }
}
