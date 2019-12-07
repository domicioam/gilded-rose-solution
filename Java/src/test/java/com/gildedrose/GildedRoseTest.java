package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void shouldDecreaseQualityTwiceWhenSellDateHasPassed() {
    	Item item = new Item("Sword", 0, 10);
    	QualityUpdatable[] items = { new RegularItem(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(8, item.quality);
    	assertEquals(-1, item.sellIn);
    }
    
    @Test
    void shouldNotHaveNegativeQualityWhenRegularItem() {
    	Item item = new Item("Sword", 0, 0);
    	QualityUpdatable[] items = { new RegularItem(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(0, item.quality);
    	assertEquals(-1, item.sellIn);
    }
    
    @Test
    void shouldIncreaseAgedBrieQualityOnceWhenSellDateHasNotPassed() {
    	Item item = new Item("Aged Brie", 1, 10);
    	QualityUpdatable[] items = { new AgedBrie(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(11, item.quality);
    	assertEquals(0, item.sellIn);
    }
    
    @Test
    void shouldIncreaseAgedBrieQualityTwiceWhenSellDateHasPassed() {
    	Item item = new Item("Aged Brie", 0, 10);
    	QualityUpdatable[] items = { new AgedBrie(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(12, item.quality);
    	assertEquals(-1, item.sellIn);
    }
    
    @Test
    void shouldNotIncreaseAgedBrieQualityWhenQualityAtMax() {
    	Item item = new Item("Aged Brie", 1, 50);
    	QualityUpdatable[] items = { new AgedBrie(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(50, item.quality);
    	assertEquals(0, item.sellIn);
    }
    
    @Test
    void shouldQualityAlwaysBeEightyWhenSulfuras() {
    	Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 50);
    	QualityUpdatable[] items = { new Sulfuras(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(80, item.quality);
    }
    
    @Test
    void shouldNotDecreaseQualityOrSellInWhenSulfuras() {
    	Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 50);
    	QualityUpdatable[] items = { new Sulfuras(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(80, item.quality);
    	assertEquals(1, item.sellIn);
    }
    
    @Test
    void shouldIncreaseQualityTwiceWhenBackstackPassesAndSellInLessOrEqualTenDays() {
    	Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48);
    	QualityUpdatable[] items = { new BackstagePasses(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(50, item.quality);
    	assertEquals(0, item.sellIn);
    }
    
    @Test
    void shouldIncreaseQualityThreeTimesWhenBackstackPassesAndSellInLessOrEqualFiveDays() {
    	Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 47);
    	QualityUpdatable[] items = { new BackstagePasses(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(50, item.quality);
    	assertEquals(0, item.sellIn);
    }
    
    @Test
    void shouldDropQualityToZeroWhenBackstackPassesAndSellInLessOrEqualZeroDays() {
    	Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 47);
    	QualityUpdatable[] items = { new BackstagePasses(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(0, item.quality);
    	assertEquals(-1, item.sellIn);
    }
    
    @Test
    void shouldNotIncreaseQualityAboveFiftyWhenBackstackPassesAndSellInLessOrEqualTenDays() {
    	Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    	QualityUpdatable[] items = { new BackstagePasses(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(50, item.quality);
    	assertEquals(9, item.sellIn);
    }
    
    @Test
    void shouldNotIncreaseQualityAboveFiftyWhenBackstackPassesAndSellInLGreaterThanTenDays() {
    	Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49);
    	QualityUpdatable[] items = { new BackstagePasses(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(50, item.quality);
    	assertEquals(10, item.sellIn);
    }
    
    @Test
    void shouldNotSulfurasQualityWhenSellInHasPassed() {
    	Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 50);
    	QualityUpdatable[] items = { new Sulfuras(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(80, item.quality);
    	assertEquals(-1, item.sellIn);
    }
    
    @Test
    void foo() {
    	Item item = new Item("Aged Brie", -1, 49);
    	QualityUpdatable[] items = { new AgedBrie(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(50, item.quality);
    	assertEquals(-2, item.sellIn);
    }
    
    @Test
    void shouldDegradeQualityTwiceWhenConjuredItem() {
    	Item item = new Item("Conjured", 20, 50);
    	QualityUpdatable[] items = { new Conjured(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(48, item.quality);
    	assertEquals(19, item.sellIn);
    }
    
    @Test
    void shouldNotDegradeQualityBelowZeroWhenConjuredItem() {
    	Item item = new Item("Conjured", 20, 0);
    	QualityUpdatable[] items = { new Conjured(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(0, item.quality);
    	assertEquals(19, item.sellIn);
    }
    
    @Test
    void shouldNotDegradeQualityBelowZeroWhenConjuredItemAndQualityEqualsToOne() {
    	Item item = new Item("Conjured", 20, 1);
    	QualityUpdatable[] items = { new Conjured(item) };
    	GildedRose gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
    	assertEquals(0, item.quality);
    	assertEquals(19, item.sellIn);
    }

}
