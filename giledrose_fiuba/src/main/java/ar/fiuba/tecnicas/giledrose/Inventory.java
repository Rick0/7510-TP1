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
            if (items[i].getName() != "Aged Brie" && items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].getQuality() > bottomQuality) {
                    if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
						if (items[i].getName() == "Conjured") {
							items[i].setQuality(items[i].getQuality() + qualityDoubleDown);
						}
						else {
							items[i].setQuality(items[i].getQuality() + qualityNormalDown);
						}
                    }
                }
            } else {
                if (items[i].getQuality() < topQuality) {
                    items[i].setQuality(items[i].getQuality() + qualityNormalUp);

                    if (items[i].getName() == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].getSellIn() < midSellIn) {
                            if (items[i].getQuality() < topQuality) {
                                items[i].setQuality(items[i].getQuality() + qualityNormalUp);
                            }
                        }

                        if (items[i].getSellIn() < lowSellIn) {
                            if (items[i].getQuality() < topQuality) {
                                items[i].setQuality(items[i].getQuality() + qualityNormalUp);
                            }
                        }
                    }
                }
            }

            if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                items[i].setSellIn(items[i].getSellIn() + sellInNormalDown);
            }

            if (items[i].getSellIn() < bottomSellIn) {
                if (items[i].getName() != "Aged Brie") {
                    if (items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].getQuality() > bottomQuality) {
                            if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                                items[i].setQuality(items[i].getQuality() + qualityNormalDown);
                            }
                        }
                    } else {
                        items[i].setQuality(items[i].getQuality() - items[i].getQuality());
                    }
                } else {
                    if (items[i].getQuality() < topQuality) {
                        items[i].setQuality(items[i].getQuality() + qualityNormalUp);
                    }
                }
            }
        }
    }

}
