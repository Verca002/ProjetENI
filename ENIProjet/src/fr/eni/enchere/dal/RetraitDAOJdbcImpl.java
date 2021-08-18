package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;
import fr.eni.encheres.BusinessException;

public class RetraitDAOJdbcImpl implements RetraitDAO {
	
	private static final String INSERT_RETRAIT = "insert into RETRAITS ( rue, code_postal, ville) values(?,?,?)";

	private static final String SELECT_ALL_RETRAIT = "select * from RETRAITS";

	@Override
	public void insert(Retrait retrait) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			if (retrait == null) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}

			try {
				cnx.setAutoCommit(false);
				PreparedStatement rqt = cnx.prepareStatement(INSERT_RETRAIT);
				rqt.setString(1, retrait.getRue());
				rqt.setInt(2, retrait.getCodePostal());
				rqt.setString(1, retrait.getVille());
				
			} finally {
				cnx.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Retrait> selectAll() throws SQLException {
		List<Retrait> listeRetrait = new ArrayList<Retrait>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_RETRAIT);
			ResultSet rs = pstmt.executeQuery();
			Retrait retrait;
			while (rs.next()) {
				retrait = new Retrait(rs.getString("rue"), rs.getInt("code_postal"), rs.getString("ville"));
						
				listeRetrait.add(retrait);
			}
		}
		return listeRetrait;
	}
}