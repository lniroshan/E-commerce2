package Service;

import java.util.List;

import model.Client;
import model.Commande;
import dao.DaoCommande;

public class GestionCommande {

	
	DaoCommande daoCommande = new DaoCommande();
	public GestionCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajouterCommande(Client client){
		Commande commande = new Commande(client);
		daoCommande.add(commande);
	}

	public List<Commande> getAllCommande() {
			System.out.println(daoCommande.allCommande());
		return	daoCommande.allCommande();
	}
	
}
