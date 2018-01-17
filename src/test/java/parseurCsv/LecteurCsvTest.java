package parseurCsv;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

public class LecteurCsvTest {
	
	private LecteurCsv lecteurCsv;
	
	@Before
	public void before(){
		lecteurCsv = new LecteurCsv();
	}
	
	@Test
	public void lireEtSplitLigneTest() throws IOException{
		lecteurCsv.initialisationReader(
				"src/test/resources/test-LecteurCsv-lireLigne.csv", StandardCharsets.UTF_8, 1, ';');
		assertEquals(1, lecteurCsv.getNbLignesLues());
		// ligne 2
		lecteurCsv.lireLigne();
		assertEquals(2, lecteurCsv.getNbLignesLues());
		assertEquals("Gaëtan;Varlet;1988;Gricourt", lecteurCsv.getLigne());
		lecteurCsv.spliterLigne();
		assertEquals(4, lecteurCsv.getLigneSplitee().length);
		assertEquals("Gaëtan", lecteurCsv.getLigneSplitee()[0]);
		assertEquals("Varlet", lecteurCsv.getLigneSplitee()[1]);
		assertEquals("1988", lecteurCsv.getLigneSplitee()[2]);
		assertEquals("Gricourt", lecteurCsv.getLigneSplitee()[3]);
		// ligne 3
		lecteurCsv.lireLigne();	
		assertEquals("Florine;Greciet;1990;Brest", lecteurCsv.getLigne());
		lecteurCsv.spliterLigne();
		assertEquals(4, lecteurCsv.getLigneSplitee().length);
		assertEquals("Florine", lecteurCsv.getLigneSplitee()[0]);
		assertEquals("Greciet", lecteurCsv.getLigneSplitee()[1]);
		assertEquals("1990", lecteurCsv.getLigneSplitee()[2]);
		assertEquals("Brest", lecteurCsv.getLigneSplitee()[3]);
		// ligne 4
		lecteurCsv.lireLigne();	
		assertEquals(4, lecteurCsv.getLigneSplitee().length);
		lecteurCsv.spliterLigne();
		assertEquals("Gaëtan", lecteurCsv.getLigneSplitee()[0]);
		assertEquals("Varlet", lecteurCsv.getLigneSplitee()[1]);
		assertEquals("1988", lecteurCsv.getLigneSplitee()[2]);
		assertEquals("Gricourt", lecteurCsv.getLigneSplitee()[3]);
		// ligne 5
		lecteurCsv.lireLigne();	
		assertEquals(4, lecteurCsv.getLigneSplitee().length);
		lecteurCsv.spliterLigne();
		assertEquals("Gaë;tan", lecteurCsv.getLigneSplitee()[0]);
		assertEquals("Varlet", lecteurCsv.getLigneSplitee()[1]);
		assertEquals("1988", lecteurCsv.getLigneSplitee()[2]);
		assertEquals("Gricourt", lecteurCsv.getLigneSplitee()[3]);
		// ligne 6		
		lecteurCsv.lireLigne();	
		assertEquals(4, lecteurCsv.getLigneSplitee().length);
		lecteurCsv.spliterLigne();
		assertEquals("Gaëtan", lecteurCsv.getLigneSplitee()[0]);
		assertEquals("Varlet", lecteurCsv.getLigneSplitee()[1]);
		assertEquals("12/04/1988", lecteurCsv.getLigneSplitee()[2]);
		assertEquals("Gricourt", lecteurCsv.getLigneSplitee()[3]);
		// ligne 7
		lecteurCsv.lireLigne();	
		assertEquals(4, lecteurCsv.getLigneSplitee().length);
		lecteurCsv.spliterLigne();
		assertEquals("Gaëtan", lecteurCsv.getLigneSplitee()[0]);
		assertEquals("Varlet", lecteurCsv.getLigneSplitee()[1]);
		assertEquals("12\\04\\1988", lecteurCsv.getLigneSplitee()[2]); // rendu : 12\04\1988
		assertEquals("Gricourt", lecteurCsv.getLigneSplitee()[3]);
		// ligne 8
		lecteurCsv.lireLigne();	
		assertEquals(4, lecteurCsv.getLigneSplitee().length);
		lecteurCsv.spliterLigne();
		assertEquals("Gaëtan", lecteurCsv.getLigneSplitee()[0]);
		assertEquals("Varlet", lecteurCsv.getLigneSplitee()[1]);
		assertEquals("12/04/1988", lecteurCsv.getLigneSplitee()[2]);
		assertEquals("Gricourt", lecteurCsv.getLigneSplitee()[3]);
		// ligne 9
		lecteurCsv.lireLigne();	
		assertEquals(4, lecteurCsv.getLigneSplitee().length);
		lecteurCsv.spliterLigne();
		assertEquals("", lecteurCsv.getLigneSplitee()[0]);
		assertEquals("Varlet", lecteurCsv.getLigneSplitee()[1]);
		assertEquals("12/04/1988", lecteurCsv.getLigneSplitee()[2]);
		assertEquals("", lecteurCsv.getLigneSplitee()[3]);
		// ligne 10
		lecteurCsv.lireLigne();	
		assertEquals(4, lecteurCsv.getLigneSplitee().length);
		lecteurCsv.spliterLigne();
		assertEquals("", lecteurCsv.getLigneSplitee()[0]);
		assertEquals("Varlet", lecteurCsv.getLigneSplitee()[1]);
		assertEquals("12/04/1988", lecteurCsv.getLigneSplitee()[2]);
		assertEquals("", lecteurCsv.getLigneSplitee()[3]);
		// ligne 11
	}

}
