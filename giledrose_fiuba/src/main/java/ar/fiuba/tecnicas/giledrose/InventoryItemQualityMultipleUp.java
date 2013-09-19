package ar.fiuba.tecnicas.giledrose;


public class InventoryItemQualityMultipleUp extends InventoryItem {

	private final int lowSellIn     =  6;
	private final int midSellIn     = 11;
	
	private final int qualityNormalUp = 1;
	private final int qualityDoubleUp = 2;
	private final int qualityTripleUp = 3;


	public InventoryItemQualityMultipleUp(Item item) {
		super(item);
	}

	
	public void update() {
		this.oneDayPass();
		
		int sellIn  = this.getContentSellIn();
		int quality = this.getContentQuality();
	
		if (sellIn >= midSellIn) {
			quality += qualityNormalUp;
		}
		else if (sellIn < midSellIn  &&  sellIn >= lowSellIn) {
			quality += qualityDoubleUp;
		}
		else if (sellIn < lowSellIn  &&  sellIn > bottomSellIn) {
			quality += qualityTripleUp;
		}
		else {
			quality = bottomSellIn;
		}
		
		this.setContentSellIn( sellIn );
		this.setContentQuality( quality );
		
		this.checkBottomQuality();
		this.checkTopQuality();
	}

}
