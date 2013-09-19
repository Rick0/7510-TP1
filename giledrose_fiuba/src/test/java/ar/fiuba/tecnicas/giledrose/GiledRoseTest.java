package ar.fiuba.tecnicas.giledrose;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GiledRoseTest {

	Item vest;
	int vestSellInInicial  = 10;
	int vestQualityInicial = 20;
	int vestQualityAumentoNormal  = -1;
	int vestQualityAumentoSellIn0 = -2;
	
	Item brie;
	int brieSellInInicial  = 2;
	int brieQualityInicial = 0;
	int brieQualityAumentoNormal  = 1;
	int brieQualityAumentoSellIn0 = 2;

	Item elixir;
	int elixirSellInInicial  = 5;
	int elixirQualityInicial = 7;
	int elixirQualityAumentoNormal  = -1;
	int elixirQualityAumentoSellIn0 = -2;
	
	Item sulfuras;
	int sulfurasSellInInicial  =  0;
	int sulfurasQualityInicial = 80;
	
	Item passes;
	int passesSellInInicial  = 15;
	int passesQualityInicial = 20;
	int passesQualityAumentoNormal             = 1;
	int passesQualityAumentoConSellInMenosDe10 = 2;
	int passesQualityAumentoConSellInMenosDe5  = 3;
	
	Item cake;
	int cakeSellInInicial  = 3;
	int cakeQualityInicial = 6;
	int cakeQualityAumentoNormal  = -1;
	int cakeQualityAumentoSellIn0 = -2;

	Item conjured;
	int conjuredSellInInicial  =  7;
	int conjuredQualityInicial = 24;
	int conjuredQualityAumentoNormal  = -2;
	int conjuredQualityAumentoSellIn0 = -3;
	
	Item[] items;
	Inventory inventory;


	@Before
	public void setUp() throws Exception {
		vest     = new Item("+5 Dexterity Vest", vestSellInInicial, vestQualityInicial);
		brie     = new Item("Aged Brie", brieSellInInicial, brieQualityInicial);
		elixir   = new Item("Elixir of the Mongoose", elixirSellInInicial, elixirQualityInicial);
		sulfuras = new Item("Sulfuras, Hand of Ragnaros", sulfurasSellInInicial, sulfurasQualityInicial);
		passes   = new Item("Backstage passes to a TAFKAL80ETC concert", passesSellInInicial, passesQualityInicial);
		cake     = new Item("Conjured Mana Cake", cakeSellInInicial, cakeQualityInicial);
		conjured = new Item("Conjured", conjuredSellInInicial, conjuredQualityInicial);

		items = new Item[] {
			vest,
			brie,
			elixir,
			sulfuras,
			passes,
			cake,
			conjured
		};

		inventory = new Inventory( items );
	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testCalidadNoNegativoInicial() {
		assertEquals(vest.getQuality() < 0, false);
		assertEquals(brie.getQuality() < 0, false);
		assertEquals(elixir.getQuality() < 0, false);
		assertEquals(sulfuras.getQuality() < 0, false);
		assertEquals(passes.getQuality() < 0, false);
		assertEquals(cake.getQuality() < 0, false);
		assertEquals(conjured.getQuality() < 0, false);
	}
	
	
	@Test
	public void testCalidadNoNegativoTrasUnUpdate() {
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
	public void testCalidadNoNegativoTrasVariosUpdates() {
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
	public void testSulfurasCalidadConstante() {
		assertEquals(sulfuras.getQuality() == sulfurasQualityInicial, true);
	
		inventory.updateQuality();

		assertEquals(sulfuras.getQuality() == sulfurasQualityInicial, true);
	
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();

		assertEquals(sulfuras.getQuality() == sulfurasQualityInicial, true);
	}
	
	
	@Test
	public void testSulfurasVencimientoConstante() {
		assertEquals(sulfuras.getSellIn() == sulfurasSellInInicial, true);
	
		inventory.updateQuality();

		assertEquals(sulfuras.getSellIn() == sulfurasSellInInicial, true);
	
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();

		assertEquals(sulfuras.getSellIn() == sulfurasSellInInicial, true);
	}
	
	
	@Test
	public void testCalidadNoMayor50Inicial() {
		assertEquals(vest.getQuality()     >  50, false);
		assertEquals(brie.getQuality()     >  50, false);
		assertEquals(elixir.getQuality()   >  50, false);
		assertEquals(sulfuras.getQuality() == 80, true);
		assertEquals(passes.getQuality()   >  50, false);
		assertEquals(cake.getQuality()     >  50, false);
		assertEquals(conjured.getQuality() >  50, false);
	}
	
	
	@Test
	public void testCalidadNoMayor50TrasUnUpdate() {
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
	public void testCalidadNoMayor50TrasVariosUpdates() {
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
	public void testPassesCalidadAumentaCuandoDisminuyeSellIn() {
		int veces = passesSellInInicial - 10;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(passes.getSellIn() , passesSellInInicial - veces);
		assertEquals(passes.getQuality() , passesQualityInicial + passesQualityAumentoNormal * veces);
	}
	
	
	@Test
	public void testPassesCalidadAumentaCuandoDisminuyeSellInMenorA10() {
		int veces = passesSellInInicial - 10;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		int passesSellInActual = passesSellInInicial - veces;
		int passesQualityAumento1 = passesQualityInicial + passesQualityAumentoNormal * veces;
		assertEquals(passes.getSellIn()  , passesSellInActual);
		assertEquals(passes.getQuality() , passesQualityAumento1);
		
		veces = veces - 5;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(passes.getSellIn() , passesSellInActual - veces);
		assertEquals(passes.getQuality() , passesQualityAumento1 + passesQualityAumentoConSellInMenosDe10 * veces);
	}
	
	
	@Test
	public void testPassesCalidadAumentaCuandoDisminuyeSellInMenorA5() {
		int veces = passesSellInInicial - 10;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}

		int passesSellInActual = passesSellInInicial - veces;
		int passesQualityAumento1 = passesQualityInicial + passesQualityAumentoNormal * veces;
		assertEquals(passes.getSellIn()  , passesSellInActual);
		assertEquals(passes.getQuality() , passesQualityAumento1);

		veces = veces - 5;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		passesSellInActual = passesSellInActual - veces;
		passesQualityAumento1 = passesQualityAumento1 + passesQualityAumentoConSellInMenosDe10 * veces;
		assertEquals(passes.getSellIn() , passesSellInActual);
		assertEquals(passes.getQuality() , passesQualityAumento1);

		veces = 5;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(passes.getSellIn() , passesSellInActual - veces);
		assertEquals(passes.getQuality() , passesQualityAumento1 + passesQualityAumentoConSellInMenosDe10 /* aca */ * veces);
	}
	
	
	@Test
	public void testPassesCalidad0CuandoSellIn0() {
		int masUnaVez = 1;
		int veces = passesSellInInicial + masUnaVez;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(passes.getSellIn() , -masUnaVez);
		assertEquals(passes.getQuality() , 0);
	}


	@Test
	public void testBrieCalidadAumentaCuandoDisminuyeSellIn() {
		assertEquals(brie.getQuality() == brieQualityInicial, true);
	
		inventory.updateQuality();

		assertEquals(brie.getQuality() > brieQualityInicial, true);
	
		inventory.updateQuality();
		inventory.updateQuality();
		inventory.updateQuality();

		assertEquals(brie.getQuality() > brieQualityInicial, true);
	}


	@Test
	public void testBrieCalidadDisminuyeCuandoSellIn0() {
		int vecesExtras = 5;
		int veces = brieSellInInicial + vecesExtras;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(brie.getSellIn()  , brieSellInInicial - veces);
		assertEquals(brie.getQuality() , brieQualityInicial + brieQualityAumentoNormal * brieSellInInicial + brieQualityAumentoSellIn0 * vecesExtras);
	}


	@Test
	public void testVestCalidadDisminuyeCuandoDisminuyeSellIn() {
		assertEquals(vest.getQuality() == vestQualityInicial, true);
	
		inventory.updateQuality();

		assertEquals(vest.getQuality() < vestQualityInicial, true);
	}


	@Test
	public void testVestCalidadDisminuyeCuandoSellIn0() {
		int vecesExtras = 3;
		int veces = vestSellInInicial + vecesExtras;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(vest.getSellIn()  , vestSellInInicial - veces);
		assertEquals(vest.getQuality() , vestQualityInicial + vestQualityAumentoNormal * vestSellInInicial + vestQualityAumentoSellIn0 * vecesExtras);
	}


	@Test
	public void testElixirCalidadDisminuyeCuandoDisminuyeSellIn() {
		assertEquals(elixir.getQuality() == elixirQualityInicial, true);
	
		inventory.updateQuality();

		assertEquals(elixir.getQuality() < elixirQualityInicial, true);
	}

	
	@Test
	public void testElixirCalidadDisminuyeCuandoSellIn0() {
		int vecesExtras = 5;
		int veces = elixirSellInInicial + vecesExtras;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(elixir.getSellIn()  , elixirSellInInicial - veces);
		assertEquals(elixir.getQuality() , 0 /*elixirQualityInicial + elixirQualityAumentoNormal*elixirSellInInicial + elixirQualityAumentoSellIn0*vecesExtras*/);
	}


	@Test
	public void testCakeCalidadDisminuyeCuandoDisminuyeSellIn() {
		assertEquals(cake.getQuality() == cakeQualityInicial, true);
	
		inventory.updateQuality();

		assertEquals(cake.getQuality() < cakeQualityInicial, true);
	}


	@Test
	public void testCakeCalidadDisminuyeCuandoSellIn0() {
		int vecesExtras = 7;
		int veces = cakeSellInInicial + vecesExtras;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(cake.getSellIn()  , cakeSellInInicial - veces);
		assertEquals(cake.getQuality() , 0 /*cakeQualityInicial + cakeQualityAumentoNormal * cakeSellInInicial + cakeQualityAumentoSellIn0 * vecesExtras*/);
	}
	

	@Test
	public void testConjuredCalidadDisminuyeCuandoDisminuyeSellIn() {
		assertEquals(conjured.getQuality() , conjuredQualityInicial);
	
		inventory.updateQuality();

		assertEquals(conjured.getQuality() , conjuredQualityInicial + conjuredQualityAumentoNormal);
	}


	@Test
	public void testConjuredCalidadDisminuyeCuandoSellIn0() {
		int vecesExtras = 9;
		int veces = conjuredSellInInicial + vecesExtras;
		for (int i = 0; i < veces; i++) {
			inventory.updateQuality();
		}
		
		assertEquals(conjured.getSellIn()  , conjuredSellInInicial - veces);
		assertEquals(conjured.getQuality() , -1 /*conjuredQualityInicial + conjuredQualityAumentoNormal * conjuredSellInInicial + conjuredQualityAumentoSellIn0 * vecesExtras*/);
	}


}
