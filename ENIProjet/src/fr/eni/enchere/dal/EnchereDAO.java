package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Enchere;

public interface EnchereDAO {
	//Insérer une nouvelle enchere
	public void insert(Enchere enchere) throws SQLException;
	
	//Sélectionner toutes les enchere 
	public List<Enchere> selectAll() throws SQLException;
	

}
