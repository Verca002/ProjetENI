package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import fr.eni.enchere.bo.Enchere;

public class AppliTestDAL {
	public static void main(String[] args) {
		LocalDate date = null;


		//Déclaration et instanciation de la DAO
		EnchereDAOJdbcImpl EnchereDAO = new EnchereDAOJdbcImpl();

		//Instanciation du jeu d'essai 
		Enchere e1 = new Enchere(date, 10);
		
																

		System.out.println("Ajout d'une enchere... ");
	
		try {
			EnchereDAO.insert(e1);
			System.out.println("Enchere ajouté  : " + e1.toString() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

			/**
			//Sélection de tous les articles
			List<Article> articles = articleDAO.selectAll();
			System.out.println("\nSélection de tous les articles  : "  );
			afficherArticles(articles);

			
		
			//Suppression d'un article
			System.out.println("\nSuppression de l'article  : " + a1.toString());
			articleDAO.delete(a1.getIdArticle());
			articles = articleDAO.selectAll();
			System.out.println("Liste des articles après suppression : "  );
			afficherArticles(articles);
			System.out.println("---------------------------------------------------------------");

		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}																		**/
	
/**	
	private static void afficherArticles(List<Article> articles){
		StringBuffer sb = new StringBuffer();
		for(Article art: articles){
			sb.append(art.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}																	**/
										

	}}
