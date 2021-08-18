package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Retrait;
import fr.eni.encheres.BusinessException;

public interface RetraitDAO {
	//Insérer une nouvelle enchere
	public void insert(Retrait retrait) throws BusinessException;
	
	//Sélectionner toutes les enchere 
	public List<Retrait> selectAll() throws SQLException;
	

}