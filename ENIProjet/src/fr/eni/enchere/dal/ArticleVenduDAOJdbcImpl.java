package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	private static final String INSERT_ARTICLEVENDU = "insert into ARTICLES_VENDUS ( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente) values(?,?,?,?,?,?)";

	private static final String SELECT_ALL_ARTICLEVENDU = "select * from ARTICLES_VENDUS";

	@Override
	public void insert(ArticleVendu ArticleVendu) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			if (ArticleVendu == null) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}

			try {
				cnx.setAutoCommit(false);
				PreparedStatement rqt = cnx.prepareStatement(INSERT_ARTICLEVENDU);
				rqt.setString(1, ArticleVendu.getNomArticle());
				rqt.setString(2, ArticleVendu.getDescription());
				rqt.setDate(3, java.sql.Date.valueOf(ArticleVendu.getDateDebutEncheres()));
				rqt.setDate(4, java.sql.Date.valueOf(ArticleVendu.getDateFinEncheres()));
				rqt.setInt(5, ArticleVendu.getMiseAPrix());
				rqt.setInt(6, ArticleVendu.getPrixVente());
			} finally {
				cnx.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ArticleVendu> selectAll() throws SQLException {
		List<ArticleVendu> listeArticleVendu = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ARTICLEVENDU);
			ResultSet rs = pstmt.executeQuery();
			ArticleVendu articleVendu;
			while (rs.next()) {
				articleVendu = new ArticleVendu(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"));
				listeArticleVendu.add(articleVendu);
			}
		}
		return listeArticleVendu;
	}
}
