package com.gildedrose;

class GildedRose {
	QualityUpdatable[] items;
	
	public GildedRose(QualityUpdatable[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			items[i].updateQuality();
		}
	}
}