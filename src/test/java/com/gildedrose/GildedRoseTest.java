package com.gildedrose;

import com.gildedrose.entity.Item;
import com.gildedrose.value_objects.ItemQuality;
import com.gildedrose.value_objects.ItemSellIn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void testThatSellInValueIsDecreased() {
        Item whateverItem = ItemFactory.from("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose(new Item[]{whateverItem});
        gildedRose.updateQuality();

        ItemSellIn expectedSellIn = new ItemSellIn(9);
        assertEquals(expectedSellIn.sellIn(), whateverItem.sellIn());
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item whateverItem = ItemFactory.from("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose(new Item[]{whateverItem});
        gildedRose.updateQuality();

        ItemQuality expectedQuality = new ItemQuality(9);
        assertEquals(expectedQuality.getQuality(), whateverItem.quality());
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = ItemFactory.from("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose(new Item[]{whateverItem});
        gildedRose.updateQuality();

        ItemQuality expectedQuality = new ItemQuality(8);
        assertEquals(expectedQuality.getQuality(), whateverItem.quality());
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = ItemFactory.from("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose(new Item[]{whateverItem});
        gildedRose.updateQuality();

        ItemQuality expectedQuality = new ItemQuality(0);
        assertEquals(expectedQuality.getQuality(), whateverItem.quality());
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = ItemFactory.from("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
        gildedRose.updateQuality();

        ItemQuality expectedQuality = new ItemQuality(2);
        assertEquals(expectedQuality.getQuality(), agedBrie.quality());
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = ItemFactory.from("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
        gildedRose.updateQuality();

        ItemQuality expectedQuality = new ItemQuality(50);
        assertEquals(expectedQuality.getQuality(), agedBrie.quality());
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = ItemFactory.from("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});
        gildedRose.updateQuality();

        ItemQuality expectedQuality = new ItemQuality(25);
        assertEquals(expectedQuality.getQuality(), sulfuras.quality());

        ItemSellIn expectedSellIn = new ItemSellIn(0);
        assertEquals(expectedSellIn.sellIn(), sulfuras.sellIn());
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        Item backstagePasses = ItemFactory.from("Backstage passes to a TAFKAL80ETC concert", 12, 20);

        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});
        gildedRose.updateQuality();

        ItemQuality expectedQuality = new ItemQuality(21);
        assertEquals(expectedQuality.getQuality(), backstagePasses.quality());
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        Item backstagePasses = ItemFactory.from("Backstage passes to a TAFKAL80ETC concert", 7, 20);

        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});
        gildedRose.updateQuality();

        ItemQuality expectedQuality = new ItemQuality(22);
        assertEquals(expectedQuality.getQuality(), backstagePasses.quality());
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        Item backstagePasses = ItemFactory.from("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});
        gildedRose.updateQuality();

        ItemQuality expectedQuality = new ItemQuality(23);
        assertEquals(expectedQuality.getQuality(), backstagePasses.quality());
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        Item backstagePasses = ItemFactory.from("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});
        gildedRose.updateQuality();

        ItemQuality expectedQuality = new ItemQuality(0);
        assertEquals(expectedQuality.getQuality(), backstagePasses.quality());
    }

}