package test.src.mietwagen.view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mietwagen.model.*;

public class TestUnternehmen {

	Unternehmen u;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		u = Unternehmen.getInstance();
		u.emptyList();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSuchen() {
		Mietwagen m = new Mietwagen(1,"VW",false,null,"Sheila");
		Mietwagen m1 = new Mietwagen(2,"VW",false,null,"Sheila");
		
		assertEquals(true,u.anlegen(m)); 
		assertEquals(0,u.suchen(m));
		assertEquals(-1,u.suchen(m1));
		
	
	}

	@Test
	public void testsuchenMarke() {
		Mietwagen m = new Mietwagen(1,"VW",false,null,"Sheila");
		Mietwagen m1 = new Mietwagen(2,"VW",false,null,"Alex");
		Mietwagen m2 = new Mietwagen(3,"Opel",false,null,"Anna");
		ArrayList<Mietwagen> markeList = new ArrayList<Mietwagen>();
		markeList.add(m);
		markeList.add(m1);
		assertEquals(true,u.anlegen(m)); 
		assertEquals(true,u.anlegen(m1)); 
		assertEquals(true,u.anlegen(m2)); 
		
		assertEquals(markeList, u.suchenMarke("VW"));
		
	}

	@Test
	public void testAnlegen() {
		Mietwagen m = new Mietwagen(1,"VW",false,null,"Sheila");
		Mietwagen m1 = new Mietwagen(1,"VW",false,null,"Sheila");
		Mietwagen m2 = new Mietwagen(2,"VW",false,null,"Sheila");
		
		assertEquals(true,u.anlegen(m));
		assertEquals(false,u.anlegen(m1));
		assertEquals(true,u.anlegen(m2));
	}

  //We check that it adds a car and then we delete the car and try adding it again(same id)
	//wich schould work

	@Test
	public void testLoschen() {
		
		Mietwagen m = new Mietwagen(1,"VW",false,null,"Sheila");
			
		assertEquals(true,u.anlegen(m));
		assertEquals(false,u.anlegen(m));
		assertEquals(true,u.loschen(m));
		assertEquals(true,u.anlegen(m));
				
	}

	@Test
	public void testVermietenBisDatum() {
		Mietwagen m = new Mietwagen(1,"VW",false,null,"Sheila");
		u.anlegen(m);
		assertTrue(u.vermietenBisDatum(m, new Datum(1,"Januar",2017)));
		assertEquals( new Datum(1,"Januar",2017),m.getVermietet_bis_Datum());
		
	}
	
	
}
