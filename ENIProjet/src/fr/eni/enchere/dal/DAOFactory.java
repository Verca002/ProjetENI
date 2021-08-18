package fr.eni.enchere.dal;



public abstract class DAOFactory {
	
	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAOJdbcImpl();
	}
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static ArticleVenduDAO getArticleVenduDAO()
	{
		return new ArticleVenduDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO()
	{
		return new RetraitDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAOJdbcImpl();
	}
}
	