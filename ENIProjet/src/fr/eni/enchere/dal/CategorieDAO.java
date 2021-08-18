package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.encheres.BusinessException;

public interface CategorieDAO {
	//Insérer une nouvelle enchere
	public void insert(Categorie categorie) throws BusinessException;
	
	//Sélectionner toutes les enchere 
	public List<Categorie> selectAll() throws SQLException;
	

}