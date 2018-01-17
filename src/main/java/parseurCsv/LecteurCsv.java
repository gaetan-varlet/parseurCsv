package parseurCsv;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class LecteurCsv {
	
	public CSVReader initialisationReader(String cheminFichier, Charset charset, char separator, int skipLines) throws IOException{
		Reader reader;
		reader = Files.newBufferedReader(Paths.get(cheminFichier),charset);
		CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(skipLines).withCSVParser(parser).build();
		return csvReader;
	}
	
	public String[] lireLigne(CSVReader csvReader) throws IOException{
		return csvReader.readNext();
	}

}
