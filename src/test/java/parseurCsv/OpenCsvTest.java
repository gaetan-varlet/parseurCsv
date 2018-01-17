package parseurCsv;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;

import beans.Personne;

public class OpenCsvTest {

	private static final String SAMPLE_CSV_FILE_PATH = "C:/Users/gaeta/Desktop/test.csv";

	@Test
	public void test1() throws IOException{

		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0).withCSVParser(parser).build();
		
		List<String[]> liste = csvReader.readAll();
		
//		for (String[] strings : liste) {
//			for (String string : strings) {
//				System.out.println(string);
//			}
//			System.out.println();
//		}
		System.out.println(liste.get(0)[0]+" "+liste.get(0)[1]+" "+liste.get(0)[2]+" "+liste.get(0)[3]);
		System.out.println(liste.get(1)[0]+" "+liste.get(1)[1]+" "+liste.get(1)[2]+" "+liste.get(1)[3]);
		System.out.println(liste.size());
		System.out.println();
		
	}
	
	@Test
	public void test2() throws IOException{

		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0).withCSVParser(parser).build();
		
		List<String[]> liste = new ArrayList<String[]>();
		String[] ligne;
		while((ligne=csvReader.readNext())!=null){
			liste.add(ligne);
		}
		
//		for (String[] strings : liste) {
//			for (String string : strings) {
//				System.out.println(string);
//			}
//			System.out.println();
//		}
		System.out.println(liste.get(0)[0]+" "+liste.get(0)[1]+" "+liste.get(0)[2]+" "+liste.get(0)[3]);
		System.out.println(liste.get(1)[0]+" "+liste.get(1)[1]+" "+liste.get(1)[2]+" "+liste.get(1)[3]);
		System.out.println(liste.size());
		System.out.println();
		
	}
	
	@Test
	@Ignore
	public void test3() throws IOException{ // 30 sec

		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		
        List<Personne> liste = new CsvToBeanBuilder(new FileReader(SAMPLE_CSV_FILE_PATH))
        		.withSeparator(';')
        		.withSkipLines(1)
                .withType(Personne.class)
                .build().parse();
        
        System.out.println(liste.size());
		System.out.println();
		
	}
	
	@Test
	@Ignore
	public void test4() throws IOException{

		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		
		ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Personne.class);
        String[] memberFieldsToBindTo = {"prenom", "nom", "age", "ville"};
        strategy.setColumnMapping(memberFieldsToBindTo);

        List<Personne> liste = new CsvToBeanBuilder(new FileReader(SAMPLE_CSV_FILE_PATH))
        		.withSeparator(';')
        		.withSkipLines(1)
        		.withMappingStrategy(strategy)
        		.withIgnoreLeadingWhiteSpace(true)
                .build().parse();
        
        System.out.println(liste.size());
		System.out.println();

	}
	
	@Test
	public void test5() throws IOException{ // 0,2 sec

		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH),StandardCharsets.UTF_8);
		CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
		
		List<Personne> liste = new ArrayList<Personne>();
		String[] ligne;
		while((ligne=csvReader.readNext())!=null){
			Personne personne = new Personne();
			personne.setPrenom(ligne[0]);
			personne.setNom(ligne[1]);
			personne.setAge(Integer.valueOf(ligne[2]));
			personne.setVille(ligne[3]);
			liste.add(personne);
		}

		System.out.println(liste.get(0).getPrenom());
		System.out.println(liste.size());
		System.out.println();
		
	}

}
