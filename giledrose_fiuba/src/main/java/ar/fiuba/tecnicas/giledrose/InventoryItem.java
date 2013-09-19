package ar.fiuba.tecnicas.giledrose;

public class InventoryItem {

	private Item content;

	private final int bottomQuality =  0;
	private final int topQuality    = 50;
	private final int bottomSellIn  =  0;
	private final int lowSellIn     =  6;
	private final int midSellIn     = 11;
	
	private final int qualityNormalUp   =  1;
	private final int qualityNormalDown = -1;
	private final int qualityDoubleDown =  2 * qualityNormalDown;
	private final int sellInNormalDown  = -1;


	public InventoryItem(Item item) {
		this.content = item;
	}

	
	public void update() {
		if ( !isAgedBrie()  &&  !isBackstagePasses() ) {
			if ( isItemQualityAboveBottom() ) {
				if ( !isSulfuras() ) {
					if ( isConjured() ) {
						setContentQuality(getContentQuality() + qualityDoubleDown);
					}
					else {
						setContentQuality(getContentQuality() + qualityNormalDown);
					}
				}
			}
		} else {
			if ( isItemQualityLessTop() ) {
				setContentQuality(getContentQuality() + qualityNormalUp);

				if ( isBackstagePasses() ) {
					if ( isItemSellInLessMidValue() ) {
						if ( isItemQualityLessTop() ) {
							setContentQuality(getContentQuality() + qualityNormalUp);
						}
					}

					if ( isItemSellInLessLowValue() ) {
						if ( isItemQualityLessTop() ) {
							setContentQuality(getContentQuality() + qualityNormalUp);
						}
					}
				}
			}
		}

		if ( !isSulfuras() ) {
			setContentSellIn(getContentSellIn() + sellInNormalDown);
		}

		if ( isItemSellInLessBottomValue() ) {
			if ( !isAgedBrie() ) {
				if ( !isBackstagePasses() ) {
					if ( isItemQualityAboveBottom() ) {
						if ( !isSulfuras() ) {
							setContentQuality(getContentQuality() + qualityNormalDown);
						}
					}
				} else {
					setContentQuality(getContentQuality() - getContentQuality());
				}
			} else {
				if ( isItemQualityLessTop() ) {
					setContentQuality(getContentQuality() + qualityNormalUp);
				}
			}
		}
	}
	

    public String getContentName() {
        return this.content.getName();
    }

	
    public void setContentName(String name) {
        this.content.setName(name);
    }

	
    public int getContentSellIn() {
        return this.content.getSellIn();
    }

	
    public void setContentSellIn(int sellIn) {
        this.content.setSellIn(sellIn);
    }

	
    public int getContentQuality() {
        return this.content.getQuality();
    }

	
    public void setContentQuality(int quality) {
        this.content.setQuality(quality);
    }
	
	
	
	
	
	private boolean isAgedBrie() {
		return this.getContentName() == "Aged Brie";
	}

	
	private boolean isBackstagePasses() {
		return this.getContentName() == "Backstage passes to a TAFKAL80ETC concert";
	}
	
	
	private boolean isSulfuras() {
		return this.getContentName() == "Sulfuras, Hand of Ragnaros";
	}
	
	
	private boolean isConjured() {
		return this.getContentName() == "Conjured";
	}


	private boolean isItemQualityAboveBottom() {
		return getContentQuality() > bottomQuality;
	}
	
	
	private boolean isItemQualityLessTop() {
		return getContentQuality() < topQuality;
	}
	
	
	private boolean isItemSellInLessMidValue() {
		return getContentSellIn() < midSellIn;
	}
	
	
	private boolean isItemSellInLessLowValue() {
		return getContentSellIn() < lowSellIn;
	}
	
	
	private boolean isItemSellInLessBottomValue() {
		return getContentSellIn() < bottomSellIn;
	}

}
