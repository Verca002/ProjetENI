package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;

public interface UtilisateurDAO {

	//Insérer une nouvelle enchere
	public void insert(Utilisateur utilisateur) throws  BusinessException;
	
	//Sélectionner toutes les enchere 
	public List<Utilisateur> selectAll() throws SQLException;
	

}

