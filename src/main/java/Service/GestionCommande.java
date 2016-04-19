package Service;

import java.util.List;

import model.Client;
import model.Commande;

import org.springframework.stereotype.Service;

import dao.DaoCommande;
@Service
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

	public void remove(Commande commande) {
		daoCommande.remove(commande);
	}
	
}
