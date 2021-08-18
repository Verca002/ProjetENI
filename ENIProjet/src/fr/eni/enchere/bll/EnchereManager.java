/*
 * Couche BLL - Traitements nécessaires pour gérer les enchères.
 * Avec Design Pattern Singleton pour n'avoir qu'UNE instance du MANAGER (et pas des enchères).
 */

package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.EnchereDAO;
import fr.eni.encheres.BusinessException;

public class EnchereManager {

// Instance fields
    
    private EnchereDAO enchereDAO;
     
    private static EnchereManager instanceEnchMana;
    
// Constructors
    /* private EnchereManager() {
    * }
    */
    
    private EnchereManager() {
        this.enchereDAO = DAOFactory.getEnchereDAO();
     }
    
    
// Methods
    // Method "getInstanceEnchMana()" >> check si l'instance existe déjà, création si besoin, renvoie l'instance de "EnchereManager"
    public static EnchereManager getInstanceEnchMana() {
        if (instanceEnchMana == null) {
            instanceEnchMana = new EnchereManager();
        }
        return instanceEnchMana;
    }
    
    // Method "encherir()" >> Faire un check des crédits dispo avant de pouvoir utiliser cette methode
    public Enchere encherir (LocalDate dateEnchere, int montant_enchere) {
        Enchere enchere = new Enchere();
        enchere.setMontant_enchere(montant_enchere);
        enchere.setDateEnchere(dateEnchere);
        
        try {
			this.enchereDAO.insert(enchere);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return enchere;
    }
    
    // Method "encheresEnCours()"
    public List<Enchere> encheresEnCours() throws SQLException {
        return this.enchereDAO.selectAll();
    }
}