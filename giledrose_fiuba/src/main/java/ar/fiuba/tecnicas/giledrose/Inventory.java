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
                new InventoryItem( new Item("+5 Dexterity Vest", 10, 20) ),
                new InventoryItem( new Item("Aged Brie", 2, 0) ),
                new InventoryItem( new Item("Elixir of the Mongoose", 5, 7) ),
                new InventoryItem( new Item("Sulfuras, Hand of Ragnaros", 0, 80) ),
                new InventoryItem( new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) ),
                new InventoryItem( new Item("Conjured Mana Cake", 3, 6) )
        };
    }


    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i].update();
        }
    }

}
