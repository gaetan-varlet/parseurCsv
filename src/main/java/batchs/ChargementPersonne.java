package batchs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import beans.Personne;
import dao.PersonneDao;
import parseurCsv.LecteurCsv;

public class ChargementPersonne {

	private static final Charset encodage = StandardCharsets.UTF_8;
	private static final char separator = ';';
	private static final int skipLines = 1;
	private static final int tailleBufferBase = 10000; 

	PersonneDao personneDao = new PersonneDao();

	/**
	 * lit un fichier CSV et l'insère en base
	 * @param cheminFichier
	 * @throws SQLException
	 * @throws IOException
	 */
	public int lireFichierEtInsererDonneesEnBase(String cheminFichier) throws SQLException, IOException{
		int nombreLignesInserees = 0;
		LecteurCsv lecteurCsv = new LecteurCsv();
		CSVReader csvReader = lecteurCsv.initialisationReader(cheminFichier, encodage, separator, skipLines);
		List<Personne> listePersonne = new ArrayList<Personne>();
		String[] ligne;
		while((ligne = lecteurCsv.lireLigne(csvReader))!=null){
			Personne personne = transformerTableauEnObjet(ligne);
			listePersonne.add(personne);
			if(listePersonne.size()==tailleBufferBase){
				personneDao.create(listePersonne);
				nombreLignesInserees=nombreLignesInserees+listePersonne.size();
				listePersonne.clear();
			}
		}
		personneDao.create(listePersonne);
		nombreLignesInserees=nombreLignesInserees+listePersonne.size();
		return nombreLignesInserees;
	}

	private Personne transformerTableauEnObjet(String[] ligne){
		Personne personne = new Personne();
		personne.setPrenom(ligne[0]);
		personne.setNom(ligne[1]);
		personne.setAge(Integer.valueOf(ligne[2]));
		personne.setVille(ligne[3]);
		return personne;
	}

}