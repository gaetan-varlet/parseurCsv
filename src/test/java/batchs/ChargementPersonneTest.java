package batchs;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChargementPersonneTest {

	@Test
	public void test1() throws SQLException, IOException{
		ChargementPersonne chargementPersonne = new ChargementPersonne();
		int nombreLignesInserees =
				chargementPersonne.lireFichierEtInsererDonneesEnBase("src/test/resources/personneCourt.csv");
		assertEquals(2, nombreLignesInserees);
	}

	@Test
	public void test2() throws SQLException, IOException{
		ChargementPersonne chargementPersonne = new ChargementPersonne();
		int nombreLignesInserees =
				chargementPersonne.lireFichierEtInsererDonneesEnBase("src/test/resources/personneLong.csv");
		assertEquals(200220, nombreLignesInserees);
	}

}
