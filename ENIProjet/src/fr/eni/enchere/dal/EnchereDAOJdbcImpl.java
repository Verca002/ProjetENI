package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Enchere;

public class EnchereDAOJdbcImpl {

	private static final String INSERT_ENCHERE = "insert into ENCHERES (date_enchere, montant_enchere) values(?,?)";

	private static final String SELECT_ENCHERE = "select * from ENCHERES";

	public void insert(Enchere enchere) throws SQLException {

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement rqt = null;
			try {
				rqt = cnx.prepareStatement(INSERT_ENCHERE);
				rqt.setDate(1, enchere.getDateEnchere());
				rqt.setInt(2, enchere.getMontant_enchere());
			} finally {
				cnx.commit();
			}
		}
	}

	public List<Enchere> selectAll() throws SQLException {
		List<Enchere> liste = new ArrayList<Enchere>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement rqt = null;
			ResultSet rs = null;
			
			try {
				rqt = cnx.createStatement();
				rs = rqt.executeQuery(SELECT_ENCHERE);
				Enchere enchere = null;
				while (rs.next()) {
					enchere = new Enchere(rs.getDate("date_enchere"), rs.getInt("montant_enchere"));
				}
				liste.add(enchere);
			} finally {
				rqt.close();
			}
			cnx.close();
		}
		return liste;
	}
	
}

