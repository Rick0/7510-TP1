package ar.fiuba.tecnicas.giledrose;

public class Inventory {
    private InventoryItem[] items;
	

    public Inventory(InventoryItem[] items) {
        super();
        this.items = items;
    }


    public Inventory() {
        super();
        items = new InventoryItem[]{
                new InventoryItemNormal( new Item("+5 Dexterity Vest", 10, 20) ),
                new InventoryItemQualityUp( new Item("Aged Brie", 2, 0) ),
                new InventoryItemNormal( new Item("Elixir of the Mongoose", 5, 7) ),
                new InventoryItemLegendary( new Item("Sulfuras, Hand of Ragnaros", 0, 80) ),
                new InventoryItemQualityMultipleUp( new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) ),
                new InventoryItemNormal( new Item("Conjured Mana Cake", 3, 6) ),
				new InventoryItemDoubleDown( new Item("Conjured", 7, 24) )
        };
    }


    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i].update();
        }
    }

}
