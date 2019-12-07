package com.gildedrose;

public abstract class QualityUpdatable {
	
	protected Item item;

	public QualityUpdatable(Item item) {
		this.item = item;
	}

	abstract void updateQuality();
}