package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT_UTILISATEUR = "insert into UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,"
			+ " credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";

	private static final String SELECT_ALL_UTILISATEUR = "select * from UTILISATEURS";

	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			if(utilisateur==null)
			{
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}
			
			try {
				cnx.setAutoCommit(false);
				 PreparedStatement rqt = cnx.prepareStatement(INSERT_UTILISATEUR);
					rqt.setString(1, utilisateur.getPseudo());
					rqt.setString(2, utilisateur.getNom());		
					rqt.setString(3, utilisateur.getPrenom());
					rqt.setString(4, utilisateur.getEmail());
					rqt.setInt(5, utilisateur.getTelephone());
					rqt.setString(6, utilisateur.getRue());
					rqt.setInt(7, utilisateur.getCodePostal());
					rqt.setString(8, utilisateur.getVille());
					rqt.setString(9, utilisateur.getMotDePasse());
					rqt.setInt(10, utilisateur.getCredit());
					rqt.setBoolean(11, utilisateur.isAdmin());
					rqt.executeUpdate();
			} finally {
				cnx.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Utilisateur> selectAll() throws SQLException {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur >();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_UTILISATEUR);
			ResultSet rs = pstmt.executeQuery();
			Utilisateur utilisateur;
			while(rs.next())
			

				{
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getInt("telephone")
						, rs.getString("rue"), rs.getInt("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),rs.getInt("credit"), rs.getBoolean("administrateur"));				
				listeUtilisateur.add(utilisateur);
				}
		
	}
	return listeUtilisateur;
}}
