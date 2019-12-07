package com.gildedrose;

public class Conjured extends QualityUpdatable {

	public Conjured(Item item) {
		super(item);
	}

	@Override
	void updateQuality() {
		if (item.quality > 0) {
			if(item.quality == 1) {
				item.quality = 0;
			} else {
				item.quality = item.quality - 2;
			}
		}
		item.sellIn = item.sellIn - 1;
	}

}
