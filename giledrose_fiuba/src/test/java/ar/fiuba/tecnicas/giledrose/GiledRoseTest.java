package ar.fiuba.tecnicas.giledrose;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GiledRoseTest {

	Item vest;
	int vestSellInInitial  = 10;
	int vestQualityInitial = 20;
	int vestQualityUpdateNormal      = -1;
	int vestQualityUpdateWithSellIn0 = -2;
	
	Item brie;
	int brieSellInInitial  = 2;
	int brieQualityInitial = 0;
	int brieQualityUpdateNormal = 1;

	Item elixir;
	int elixirSellInInitial  = 5;
	int elixirQualityInitial = 7;
	int elixirQualityUpdateNormal      = -1;
	int elixirQualityUpdateWithSellIn0 = -2;
	
	Item sulfuras;
	int sulfurasSellInInitial  =  0;
	int sulfurasQualityInitial = 80;
	
	Item passes;
	int passesSellInInitial  = 15;
	int passesQualityInitial = 20;
	int passesQualityUpdateNormal               = 1;
	int passesQualityUpdateWithSellInLessThan10 = 2;
	int passesQualityUpdateWithSellInLessThan5  = 3;
	
	Item cake;
	int cakeSellInInitial  = 3;
	int cakeQualityInitial = 6;
	int cakeQualityUpdateNormal      = -1;
	int cakeQualityUpdateWithSellIn0 = -2;

	Item conjured;
	int conjuredSellInInitial  =  7;
	int conjuredQualityInitial = 24;
	int conjuredQualityUpdateNormal      = -2;
	int conjuredQualityUpdateWithSellIn0 = -3;
	
	InventoryItem[] items;
	Inventory inventory;


	@Before
	public void setUp() throws Exception {
		vest     = new Item("+5 Dexterity Vest", vestSellInInitial, vestQualityInitial);
		brie     = new Item("Aged Brie", brieSellInInitial, brieQualityInitial);
		elixir   = new Item("Elixir of the Mongoose", elixirSellInInitial, elixirQualityInitial);
		sulfuras = new Item("Sulfuras, Hand of Ragnaros", sulfurasSellInInitial, sulfurasQualityInitial);
		passes   = new Item("Backstage passes to a TAFKAL80ETC concert", passesSellInInitial, passesQualityInitial);
		cake     = new Item("Conjured Mana Cake", cakeSellInInitial, cakeQualityInitial);
		conjured = new Item("Conjured", conjuredSellInInitial, conjuredQualityInitial);

		items = new InventoryItem[] {
			new InventoryItemNormal( vest ),
			new InventoryItemQualityUp( brie ),
			new InventoryItemNormal( elixir ),
			new InventoryItemLegendary( sulfuras ),
			new InventoryItemQualityMultipleUp( passes ),
			new InventoryItemNormal( cake ),
			new InventoryItemDoubleDown( conjured )
		};

		inventory = new Inventory( items );
	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testInitialQualityNotNegative() {
		assertEquals(vest.getQuality() < 0, false);
		assertEquals(brie.getQuality() < 0, false);
		assertEquals(elixir.getQuality() < 0, false);
		assertEquals(sulfuras.getQuality() < 0, false);
		assertEquals(passes.getQuality() < 0, false);
		assertEquals(cake.getQuality() < 0, false);
		assertEquals(conjured.getQuality() < 0, false);
	}
	
	
	@Test
	public void testQualityNotNegativeAfterUpdate() {
		inventory.updateQuality();

		assertEquals(vest.getQuality() < 0, false);
		assertEquals(brie.getQuality() < 0, false);
		assertEquals(elixir.getQuality() < 0, false);
		assertEquals(sulfuras.getQuality() < 0, false);
		assertEquals(passes.getQuality() < 0, false);
		assertEquals(cake.getQuality() < 0, false);
		assertEquals(conjured.getQuality() < 0, false);
	}
	
	
	@Test
	public void testQualityNotNegativeAfterSomeUpdates() {
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();

		assertEquals(vest.getQuality() < 0, false);
		assertEquals(brie.getQuality() < 0, false);
		assertEquals(elixir.getQuality() < 0, false);
		assertEquals(sulfuras.getQuality() < 0, false);
		assertEquals(passes.getQuality() < 0, false);
		assertEquals(cake.getQuality() < 0, false);
		assertEquals(conjured.getQuality() < 0, false);
	}


	@Test
	public void testInitialQualityNotGreaterThan50() {
		assertEquals(vest.getQuality()     >  50, false);
		assertEquals(brie.getQuality()     >  50, false);
		assertEquals(elixir.getQuality()   >  50, false);
		assertEquals(sulfuras.getQuality() == 80, true);
		assertEquals(passes.getQuality()   >  50, false);
		assertEquals(cake.getQuality()     >  50, false);
		assertEquals(conjured.getQuality() >  50, false);
	}
	
	
	@Test
	public void testQualityNotGreaterThan50AfterUpdate() {
		inventory.updateQuality();
		
		assertEquals(vest.getQuality()     >  50, false);
		assertEquals(brie.getQuality()     >  50, false);
		assertEquals(elixir.getQuality()   >  50, false);
		assertEquals(sulfuras.getQuality() == 80, true);
		assertEquals(passes.getQuality()   >  50, false);
		assertEquals(cake.getQuality()     >  50, false);
		assertEquals(conjured.getQuality() >  50, false);
	}

	
	@Test
	public void testQualityNotGreaterThan50AfterSomeUpdates() {
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();
		
		assertEquals(vest.getQuality()     >  50, false);
		assertEquals(brie.getQuality()     >  50, false);
		assertEquals(elixir.getQuality()   >  50, false);
		assertEquals(sulfuras.getQuality() == 80, true);
		assertEquals(passes.getQuality()   >  50, false);
		assertEquals(cake.getQuality()     >  50, false);
		assertEquals(conjured.getQuality() >  50, false);
	}


	@Test
	public void testSulfurasConstantQuality() {
		assertEquals(sulfuras.getQuality() == sulfurasQualityInitial, true);
	
		inventory.updateQuality();

		assertEquals(sulfuras.getQuality() == sulfurasQualityInitial, true);
	
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();

		assertEquals(sulfuras.getQuality() == sulfurasQualityInitial, true);
	}
	
	
	@Test
	public void testSulfurasConstantSellIn() {
		assertEquals(sulfuras.getSellIn() == sulfurasSellInInitial, true);
	
		inventory.updateQuality();

		assertEquals(sulfuras.getSellIn() == sulfurasSellInInitial, true);
	
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();

		assertEquals(sulfuras.getSellIn() == sulfurasSellInInitial, true);
	}


	@Test
	public void testPassesQualityUpWhenSellInDown() {
		int times = 2;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(passes.getSellIn() , passesSellInInitial - times);
		assertEquals(passes.getQuality() , passesQualityInitial + passesQualityUpdateNormal * times);
	}
	
	
	@Test
	public void testPassesQualityUpWhenSellInDownLessThan10() {
		int times = passesSellInInitial - 11;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		int passesSellInActual = passesSellInInitial - times;
		int passesQualityAfterFirstUpdate = passesQualityInitial + passesQualityUpdateNormal * times;
		assertEquals(passes.getSellIn()  , passesSellInActual);
		assertEquals(passes.getQuality() , passesQualityAfterFirstUpdate);
		
		times = 4;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(passes.getSellIn() , passesSellInActual - times);
		assertEquals(passes.getQuality() , passesQualityAfterFirstUpdate + passesQualityUpdateWithSellInLessThan10 * times);
	}
	
	
	@Test
	public void testPassesQualityUpWhenSellInDownLessThan5() {
		int times = passesSellInInitial - 11;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}

		int passesSellInActual = passesSellInInitial - times;
		int passesQualityAfterFirstUpdate = passesQualityInitial + passesQualityUpdateNormal * times;
		assertEquals(passes.getSellIn()  , passesSellInActual);
		assertEquals(passes.getQuality() , passesQualityAfterFirstUpdate);

		times = 5;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		passesSellInActual = passesSellInActual - times;
		passesQualityAfterFirstUpdate = passesQualityAfterFirstUpdate + passesQualityUpdateWithSellInLessThan10 * times;
		assertEquals(passes.getSellIn() , passesSellInActual);
		assertEquals(passes.getQuality() , passesQualityAfterFirstUpdate);

		times = 2;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(passes.getSellIn() , passesSellInActual - times);
		assertEquals(passes.getQuality() , passesQualityAfterFirstUpdate + passesQualityUpdateWithSellInLessThan5  * times);
	}
	
	
	@Test
	public void testPassesQuality0WhenSellIn0() {
		int oneMoreTime = 1;
		int times = passesSellInInitial + oneMoreTime;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(passes.getSellIn() , -oneMoreTime);
		assertEquals(passes.getQuality() , 0);
	}


	@Test
	public void testBrieQualityUpWhenSellInDown() {
		assertEquals(brie.getQuality() == brieQualityInitial, true);
	
		inventory.updateQuality();

		assertEquals(brie.getQuality() > brieQualityInitial, true);
	
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();

		assertEquals(brie.getQuality() > brieQualityInitial, true);
	}


	@Test
	public void testBrieQualityDownWhenSellInDown() {
		int extraTimes = 5;
		int times = brieSellInInitial + extraTimes;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(brie.getSellIn()  , brieSellInInitial - times);
		assertEquals(brie.getQuality() , brieQualityInitial + brieQualityUpdateNormal * times);
	}


	@Test
	public void testVestQualityDownWhenSellInDown() {
		assertEquals(vest.getQuality() == vestQualityInitial, true);
	
		inventory.updateQuality();

		assertEquals(vest.getQuality() < vestQualityInitial, true);
	}


	@Test
	public void testVestQualityDownWhenSellIn0() {
		int extraTimes = 3;
		int times = vestSellInInitial + extraTimes;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(vest.getSellIn()  , vestSellInInitial - times);
		assertEquals(vest.getQuality() , vestQualityInitial + vestQualityUpdateNormal * (vestSellInInitial+1) + vestQualityUpdateWithSellIn0 * extraTimes);
	}


	@Test
	public void testElixirQualityDownWhenSellInDown() {
		assertEquals(elixir.getQuality() == elixirQualityInitial, true);
	
		inventory.updateQuality();

		assertEquals(elixir.getQuality() < elixirQualityInitial, true);
	}

	
	@Test
	public void testElixirQualityDownWhenSellIn0() {
		int extraTimes = 5;
		int times = elixirSellInInitial + extraTimes;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(elixir.getSellIn()  , elixirSellInInitial - times);
		assertEquals(elixir.getQuality() , 0);
	}


	@Test
	public void testCakeQualityDownWhenSellInDown() {
		assertEquals(cake.getQuality() == cakeQualityInitial, true);
	
		inventory.updateQuality();

		assertEquals(cake.getQuality() < cakeQualityInitial, true);
	}


	@Test
	public void testCakeQualityDownWhenSellIn0() {
		int extraTimes = 7;
		int times = cakeSellInInitial + extraTimes;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(cake.getSellIn()  , cakeSellInInitial - times);
		assertEquals(cake.getQuality() , 0 /*cakeQualityInitial + cakeQualityUpdateNormal * cakeSellInInitial + cakeQualityUpdateWithSellIn0 * extraTimes*/);
	}
	

	@Test
	public void testConjuredQualityDownWhenSellInDown() {
		assertEquals(conjured.getQuality() , conjuredQualityInitial);
	
		inventory.updateQuality();

		assertEquals(conjured.getQuality() , conjuredQualityInitial + conjuredQualityUpdateNormal);
	}


	@Test
	public void testConjuredQualityDownWhenSellIn0() {
		int extraTimes = 9;
		int times = conjuredSellInInitial + extraTimes;
		for (int i = 0; i < times; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(conjured.getSellIn()  , conjuredSellInInitial - times);
		assertEquals(conjured.getQuality() , 0);
	}


}
