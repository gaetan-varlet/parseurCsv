package parseurCsv;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.opencsv.CSVReader;

public class LecteurCsvTest {
	
	private LecteurCsv lecteurCsv;
	
	@Before
	public void before(){
		lecteurCsv = new LecteurCsv();
	}
	
	@Test
	public void lireLigneTest1() throws IOException{
		CSVReader csvReader = lecteurCsv.initialisationReader(
				"src/test/resources/test-LecteurCsv-lireLigne.csv", StandardCharsets.UTF_8, ';', 1);
		
		// ligne 2
		String[] data = lecteurCsv.lireLigne(csvReader);	
		assertEquals(4, data.length);
		assertEquals("Gaëtan", data[0]);
		assertEquals("Varlet", data[1]);
		assertEquals("1988", data[2]);
		assertEquals("Gricourt", data[3]);
		// ligne 3
		data = lecteurCsv.lireLigne(csvReader);	
		assertEquals(4, data.length);
		assertEquals("Florine", data[0]);
		assertEquals("Greciet", data[1]);
		assertEquals("1990", data[2]);
		assertEquals("Brest", data[3]);
		// ligne 4
		data = lecteurCsv.lireLigne(csvReader);	
		assertEquals(4, data.length);
		assertEquals("Gaëtan", data[0]);
		assertEquals("Varlet", data[1]);
		assertEquals("1988", data[2]);
		assertEquals("Gricourt", data[3]);
		// ligne 5
		data = lecteurCsv.lireLigne(csvReader);	
		assertEquals(4, data.length);
		assertEquals("Gaë;tan", data[0]);
		assertEquals("Varlet", data[1]);
		assertEquals("1988", data[2]);
		assertEquals("Gricourt", data[3]);
		// ligne 6		
		data = lecteurCsv.lireLigne(csvReader);	
		assertEquals(4, data.length);
		assertEquals("Gaëtan", data[0]);
		assertEquals("Varlet", data[1]);
		assertEquals("12/04/1988", data[2]);
		assertEquals("Gricourt", data[3]);
		// ligne 7
		data = lecteurCsv.lireLigne(csvReader);	
		assertEquals(4, data.length);
		assertEquals("Gaëtan", data[0]);
		assertEquals("Varlet", data[1]);
		assertEquals("12\\04\\1988", data[2]); // rendu : 12\04\1988
		assertEquals("Gricourt", data[3]);
		// ligne 8
		data = lecteurCsv.lireLigne(csvReader);	
		assertEquals(4, data.length);
		assertEquals("Gaëtan", data[0]);
		assertEquals("Varlet", data[1]);
		assertEquals("12/04/1988", data[2]);
		assertEquals("Gricourt", data[3]);
		// ligne 9
		data = lecteurCsv.lireLigne(csvReader);	
		assertEquals(4, data.length);
		assertEquals("", data[0]);
		assertEquals("Varlet", data[1]);
		assertEquals("12/04/1988", data[2]);
		assertEquals("", data[3]);
		// ligne 10
		data = lecteurCsv.lireLigne(csvReader);	
		assertEquals(4, data.length);
		assertEquals("", data[0]);
		assertEquals("Varlet", data[1]);
		assertEquals("12/04/1988", data[2]);
		assertEquals("", data[3]);
		// ligne 11
		
		
		
	}

}
