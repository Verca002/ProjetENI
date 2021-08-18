package fr.eni.enchere.dal;


import java.time.LocalDate;
import fr.eni.enchere.bo.Enchere;
import fr.eni.encheres.BusinessException;

public class AppliTestDAL {
	public static void main(String[] args) throws BusinessException {
		LocalDate date = null;


		//Déclaration et instanciation de la DAO
		EnchereDAOJdbcImpl EnchereDAO = new EnchereDAOJdbcImpl();

		//Instanciation du jeu d'essai 
		Enchere e1 = new Enchere(date, 10);
		
																

		System.out.println("Ajout d'une enchere... ");
	
		EnchereDAO.insert(e1);
		System.out.println("Enchere ajouté  : " + e1.toString() );	

															

	}}
