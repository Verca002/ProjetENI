package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.encheres.BusinessException;

public interface ArticleVenduDAO {

	//Insérer une nouvelle enchere
	public void insert(ArticleVendu ArticleVendu) throws  BusinessException;
	
	//Sélectionner toutes les enchere 
	public List<ArticleVendu> selectAll() throws SQLException;
	

}

