package com.gildedrose;

public class RegularItem extends QualityUpdatable {

	public RegularItem(Item item) {
		super(item);
	}

	@Override
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
