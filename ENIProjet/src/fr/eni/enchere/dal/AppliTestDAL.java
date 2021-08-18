package fr.eni.enchere.dal;


import java.time.LocalDate;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;

public class AppliTestDAL {
	public static void main(String[] args) throws BusinessException {
		
/**		LocalDate date = null;


		//Déclaration et instanciation de la DAO
		EnchereDAOJdbcImpl EnchereDAO = new EnchereDAOJdbcImpl();

		//Instanciation du jeu d'essai 
		Enchere e1 = new Enchere(date, 10);
		
																

		System.out.println("Ajout d'une enchere... ");
	
		EnchereDAO.insert(e1);
		System.out.println("Enchere ajouté  : " + e1.toString() );										**/
		


		//Déclaration et instanciation de la DAO
		UtilisateurDAOJdbcImpl UtilisateurDAO = new UtilisateurDAOJdbcImpl();

		//Instanciation du jeu d'essai 
		Utilisateur u1 = new Utilisateur("pseudo", "nom", "prenom", "email", 00000000, "rue", 00000, "ville", "motDePasse", 00, true);
		
																

		System.out.println("Ajout d'une enchere... ");
	
		UtilisateurDAO.insert(u1);
		System.out.println("Enchere ajouté  : " + u1.toString() );

															

	}}
