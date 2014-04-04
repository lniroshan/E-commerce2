import static org.junit.Assert.*;
import junit.framework.Assert;
import model.Article;
import model.Client;
import model.Panier;

import org.junit.Ignore;
import org.junit.Test;

import dao.DaoArticle;
import dao.DaoUtilisateur;
import Service.GestionUtilisateur;


public class MongoTest {

	@Test
	@Ignore
	public void test() {
		GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();
		gestionUtilisateur.addClient(new Client("dbeiozf", "dbeiozf", "dbeiozf", "dbeiozf", new Panier(),"dbeiozf", "dbeiozf"));
		
	}
	

	@Test
	public void test1() {
//		GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();
//		gestionUtilisateur.addClient(new Client("toto", "toto", "toto", "toto", new Panier(),"toto", "toto"));
		DaoUtilisateur utilisateur = new DaoUtilisateur();
		Client client = utilisateur.findUtilisateur("toto", "toto");
		assertNotNull(client);
	}
	
	@Test
	public void test2() {
//		GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();
//		gestionUtilisateur.addClient(new Client("toto", "toto", "toto", "toto", new Panier(),"toto", "toto"));
        Article a1 = new Article("meuble", "lavabo", 13, 1);
        Article a2 = new Article("toillette", "armoire", 14, 1);
        Article a3 = new Article("cuisine", "salle", 16, 1);
		
		DaoArticle daoArticle = new DaoArticle();
daoArticle.add(a1);
daoArticle.add(a2);
daoArticle.add(a3);
	}
	
	

}
