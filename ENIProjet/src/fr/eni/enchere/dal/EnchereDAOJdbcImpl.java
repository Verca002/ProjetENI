package fr.eni.enchere.dal;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.CodesResultatDAL;
import fr.eni.encheres.BusinessException;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	private static final String INSERT_ENCHERE = "insert into ENCHERES (date_enchere, montant_enchere) values(?,?)";

	private static final String SELECT_ALL_ENCHERE = "select * from ENCHERES";
	
	
	@Override
	public void insert(Enchere enchere) throws BusinessException {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			if(enchere==null)
			{
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}
			
			try {
				cnx.setAutoCommit(false);
				LocalDate date = null;
				date.getDayOfWeek();
	
				 PreparedStatement rqt = cnx.prepareStatement(INSERT_ENCHERE);
				rqt.setDate(1, java.sql.Date.valueOf(enchere.getDateEnchere()));
				rqt.setInt(2, enchere.getMontant_enchere());
				rqt.executeUpdate();
			} finally {
				cnx.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Enchere> selectAll() throws SQLException {
		List<Enchere> liste = new ArrayList<Enchere>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ENCHERE);
			
			ResultSet rs = pstmt.executeQuery();
			Enchere enchere;
			while(rs.next()) {
					enchere = new Enchere( rs.getDate("date_enchere"), rs.getInt("montant_enchere"));
					liste.add(enchere);
				}
				
		}
		return liste;
	}}