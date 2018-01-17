package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import beans.Personne;

public class PersonneDao {
	
	Connection connexion;
	
	public void create(List<Personne> listePersonne) throws SQLException {
	}

	public void create2(List<Personne> listePersonne) throws SQLException {
		String requeteSql = "insert into PERSONNE (nom, prenom, age, ville) values (?,?,?,?)";
		PreparedStatement ps = connexion.prepareStatement(requeteSql);		
		for (Personne personne : listePersonne) {
			ps.setString(1, personne.getNom());
			ps.setString(2, personne.getPrenom());
			ps.setInt(3, personne.getAge());
			ps.setString(4, personne.getVille());
			ps.addBatch();
		}
		ps.executeBatch();
		ps.close();	
	}

}
