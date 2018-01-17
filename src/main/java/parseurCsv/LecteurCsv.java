package parseurCsv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;

public class LecteurCsv {

	private BufferedReader reader;
	private CSVParser csvParser;
	private String ligne;
	private String[] ligneSplitee;
	private int nbLignesLues = 0;

	public String getLigne() {
		return ligne;
	}
	
	public String[] getLigneSplitee() {
		return ligneSplitee;
	}

	public int getNbLignesLues() {
		return nbLignesLues;
	}
	

	public void initialisationReader
	(String cheminFichier, Charset charset, int skipLines, char separator) throws IOException{
		reader = Files.newBufferedReader(Paths.get(cheminFichier),charset);
		for (int i = 0; i < skipLines; i++) {
			reader.readLine(); // vérifier qu'on ne dépasse pas le nb de lignes du fichier
			nbLignesLues++;
		}
		csvParser = new CSVParserBuilder().withSeparator(separator).build();
	}

	public void lireLigne() throws IOException{
		ligne = reader.readLine();
		nbLignesLues++;
	}

	public void spliterLigne() throws IOException{
		ligneSplitee = csvParser.parseLine(ligne);
	}

}
