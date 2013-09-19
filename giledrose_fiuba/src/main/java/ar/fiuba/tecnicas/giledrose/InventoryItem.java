package ar.fiuba.tecnicas.giledrose;

public abstract class InventoryItem {

	protected Item content;

	protected final int bottomQuality =  0;
	protected final int topQuality    = 50;
	protected final int bottomSellIn  =  0;
//	private final int lowSellIn     =  6;
//	private final int midSellIn     = 11;
	
//	private final int qualityNormalUp   =  1;
//	private final int qualityNormalDown = -1;
//	private final int qualityDoubleDown =  2 * qualityNormalDown;
//	private final int sellInNormalDown  = -1;


	public InventoryItem(Item item) {
		this.content = item;
	}


	public abstract void update();
	
	
	protected void oneDayPass() {
		this.setContentSellIn( getContentSellIn() - 1 );
	}
	

	protected void checkTopQuality() {
		if (this.getContentQuality() > topQuality) {
			this.setContentQuality(topQuality);
		}
	}
	
	
	protected void checkBottomQuality() {
		if (this.getContentQuality() < bottomQuality) {
			this.setContentQuality(bottomQuality);
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

}
