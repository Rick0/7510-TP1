package ar.fiuba.tecnicas.giledrose;


public class InventoryItemQualityUp extends InventoryItem {

	private final int qualityNormalUp = 1;
	

	public InventoryItemQualityUp(Item item) {
		super(item);
	}

	
	public void update() {
		this.oneDayPass();
		
		int sellIn  = this.getContentSellIn();
		int quality = this.getContentQuality();

		quality += qualityNormalUp;

		this.setContentSellIn( sellIn );
		this.setContentQuality( quality );
		
		this.checkBottomQuality();
		this.checkTopQuality();
	}

}
