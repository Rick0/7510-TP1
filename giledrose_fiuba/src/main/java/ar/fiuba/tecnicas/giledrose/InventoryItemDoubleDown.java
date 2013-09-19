package ar.fiuba.tecnicas.giledrose;


public class InventoryItemDoubleDown extends InventoryItem {

	private final int qualityNormalDown = -2;
	private final int qualityDoubleDown =  2 * qualityNormalDown;


	public InventoryItemDoubleDown(Item item) {
		super(item);
	}
	

	public void update() {
		this.oneDayPass();
	
		int sellIn  = this.getContentSellIn();
		int quality = this.getContentQuality();

		if (sellIn > 0) {
			quality += qualityNormalDown;
		}
		else if (sellIn <= 0) {
			quality += qualityDoubleDown;
		}

		this.setContentSellIn( sellIn );
		this.setContentQuality( quality );
		
		this.checkBottomQuality();
		this.checkTopQuality();
	}

}
