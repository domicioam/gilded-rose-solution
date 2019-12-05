package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			switch (items[i].name) {
			case "Aged Brie":
				AgedBrie agedBrie = new AgedBrie(items[i]);
				agedBrie.updateQuality();
				break;
			case "Backstage passes to a TAFKAL80ETC concert":
				BackstagePasses backstagePasses = new BackstagePasses(items[i]);
				backstagePasses.updateQuality();
				break;
			case "Sulfuras, Hand of Ragnaros":
				Sulfuras sulfuras = new Sulfuras(items[i]);
				sulfuras.updateQuality();
				break;
			default:
				RegularItem regularItem = new RegularItem(items[i]);
				regularItem.updateQuality();
				break;
			}
		}
	}
}