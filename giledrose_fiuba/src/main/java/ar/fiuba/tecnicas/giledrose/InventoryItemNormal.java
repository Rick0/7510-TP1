package ar.fiuba.tecnicas.giledrose;


public class InventoryItemNormal extends InventoryItem {

	private final int qualityNormalDown = -1;
	private final int qualityDoubleDown = -2; //* qualityNormalDown;

	
	public InventoryItemNormal(Item item) {
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
