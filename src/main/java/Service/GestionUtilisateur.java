package Service;

import org.springframework.stereotype.Service;

import model.Client;
import model.Panier;



import dao.DaoUtilisateur;
@Service
public class GestionUtilisateur {

	DaoUtilisateur daoUtilisateur = new DaoUtilisateur();

	public boolean add(String nom, String prenom, String adresse,
			String dateDeNaissance, Panier panier, String mail, String motDePasse) {
		Client client = new Client(nom, prenom, adresse, dateDeNaissance,
				panier, mail, motDePasse);
		daoUtilisateur.add(client);
		return true;
	}

	public Client authentification(String mdp, String login) {
		System.out.println(daoUtilisateur.findUtilisateur(login, mdp));
		return daoUtilisateur.findUtilisateur(login, mdp);
		
	}

	public boolean connection(String nom, String motDePasse) {
		return daoUtilisateur.connection(nom, motDePasse);

	}
	
	public boolean addClient(Client client){
		return daoUtilisateur.add(client);
	}

	public boolean delete(String nom, String motDePasse) {
		Client client = daoUtilisateur.findUtilisateur(nom, motDePasse);
		if (client == null) {
			return false;
		}
		daoUtilisateur.delete(client);
		return true;
	}

	public boolean update(Client client) {
		return daoUtilisateur.update(client);
	}
}
