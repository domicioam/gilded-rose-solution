package com.gildedrose;

public class RegularItem {

	private Item item;

	public RegularItem(Item item) {
		this.item = item;
	}

	public void updateQuality() {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
		item.sellIn = item.sellIn - 1;
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}

}
