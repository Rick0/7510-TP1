package ar.fiuba.tecnicas.giledrose;

public class Inventory {
    private Item[] items;
	
	private final int bottomQuality =  0;
	private final int topQuality    = 50;
	private final int bottomSellIn  =  0;
	private final int lowSellIn     =  6;
	private final int midSellIn     = 11;
	
	private final int qualityNormalUp   =  1;
	private final int qualityNormalDown = -1;
	private final int qualityDoubleDown =  2 * qualityNormalDown;
	private final int sellInNormalDown  = -1;


    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Inventory() {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if ( !isAgedBrie(i)  &&  !isBackstagePasses(i) ) {
                if ( isItemQualityAboveBottom(i) ) {
                    if ( !isSulfuras(i) ) {
						if ( isConjured(i) ) {
							items[i].setQuality(items[i].getQuality() + qualityDoubleDown);
						}
						else {
							items[i].setQuality(items[i].getQuality() + qualityNormalDown);
						}
                    }
                }
            } else {
                if ( isItemQualityLessTop(i) ) {
                    items[i].setQuality(items[i].getQuality() + qualityNormalUp);

                    if ( isBackstagePasses(i) ) {
                        if ( isItemSellInLessMidValue(i) ) {
                            if ( isItemQualityLessTop(i) ) {
                                items[i].setQuality(items[i].getQuality() + qualityNormalUp);
                            }
                        }

                        if ( isItemSellInLessLowValue(i) ) {
                            if ( isItemQualityLessTop(i) ) {
                                items[i].setQuality(items[i].getQuality() + qualityNormalUp);
                            }
                        }
                    }
                }
            }

            if ( !isSulfuras(i) ) {
                items[i].setSellIn(items[i].getSellIn() + sellInNormalDown);
            }

            if ( isItemSellInLessBottomValue(i) ) {
                if ( !isAgedBrie(i) ) {
                    if ( !isBackstagePasses(i) ) {
                        if ( isItemQualityAboveBottom(i) ) {
                            if ( !isSulfuras(i) ) {
                                items[i].setQuality(items[i].getQuality() + qualityNormalDown);
                            }
                        }
                    } else {
                        items[i].setQuality(items[i].getQuality() - items[i].getQuality());
                    }
                } else {
                    if ( isItemQualityLessTop(i) ) {
                        items[i].setQuality(items[i].getQuality() + qualityNormalUp);
                    }
                }
            }
        }
    }



	private boolean isAgedBrie(int i) {
		return items[i].getName() == "Aged Brie";
	}

	
	private boolean isBackstagePasses(int i) {
		return items[i].getName() == "Backstage passes to a TAFKAL80ETC concert";
	}
	
	
	private boolean isSulfuras(int i) {
		return items[i].getName() == "Sulfuras, Hand of Ragnaros";
	}
	
	
	private boolean isConjured(int i) {
		return items[i].getName() == "Conjured";
	}


	private boolean isItemQualityAboveBottom(int i) {
		return items[i].getQuality() > bottomQuality;
	}
	
	
	private boolean isItemQualityLessTop(int i) {
		return items[i].getQuality() < topQuality;
	}
	
	
	private boolean isItemSellInLessMidValue(int i) {
		return items[i].getSellIn() < midSellIn;
	}
	
	
	private boolean isItemSellInLessLowValue(int i) {
		return items[i].getSellIn() < lowSellIn;
	}
	
	
	private boolean isItemSellInLessBottomValue(int i) {
		return items[i].getSellIn() < bottomSellIn;
	}

}
