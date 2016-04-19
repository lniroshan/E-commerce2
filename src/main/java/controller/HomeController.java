package controller;

import java.util.List;

import model.Article;
import model.Client;
import model.Commande;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Service.GestionArticle;
import Service.GestionCommande;
import Service.GestionUtilisateur;

@Controller
@ComponentScan("Service")
public class HomeController {

	@Autowired 
	GestionArticle gestionArticle;
	@Autowired 
	GestionUtilisateur gestionUtilisateur;
	@Autowired
	GestionCommande gestionCommande;
	
	private static final Logger logger = LoggerFactory
			.getLogger("HomeController");

	@RequestMapping(value = "/store", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Article> list() {
		return gestionArticle.getStore();
	}

	// ajout d'un nouveau client
	@RequestMapping(value = "/addClient", method = RequestMethod.POST, consumes = "application/json")
	public void paiementNouveauClient(
			@RequestBody final Client client) {
		gestionUtilisateur.addClient(client);
		
	}

	// ajout d'un nouveau client
	@RequestMapping(value = "/updateClient", method = RequestMethod.PUT, consumes = "application/json")
	public void modificationClient(@RequestBody final Client client) {
		gestionUtilisateur.update(client);

	}

	// update d'un client
	@RequestMapping(value = "/payerClient", method = RequestMethod.PUT, consumes = "application/json")
	public void paiementClient(@RequestBody final Client client) {
		gestionCommande.ajouterCommande(client);

	}

	// authentification du client
	@RequestMapping(value = "/authentification", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<Client> authentification(
			@RequestBody final Client client) {
		Client findClient = gestionUtilisateur.authentification(client
				.getMail().trim(), client.getMotDePasse().trim());
		if (findClient == null) {
			return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Client>(findClient, HttpStatus.OK);
	}

	// ajout d'un nouveau article
	@RequestMapping(value = "/ajoutArticle", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> ajouterArticle(
			@RequestBody final Article article) {
		gestionArticle.add(article);
		return null;
	}

	// suppression d'un article
	@RequestMapping(value = "/supprimerArticle", method = RequestMethod.DELETE, consumes = "application/json")
	public void supprimerArticle(
			@RequestBody final Article article) {
		gestionArticle.remove(article);
		
	}

	// modification d'un article
	@RequestMapping(value = "/modificationArticle", method = RequestMethod.PUT, consumes = "application/json")
	public void modificationArticle(@RequestBody final Article article) {
		gestionArticle.update(article);

	}

	// recuperation commande
	// modification d'un article
	@RequestMapping(value = "/getAllCommande", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Commande> recuperationCommande() {
		return gestionCommande.getAllCommande();
	}

	// suppression d'une Commande
	@RequestMapping(value = "/supprimerCommande", method = RequestMethod.DELETE, consumes = "application/json")
	public void supprimerCommande(@RequestBody final Commande commande) {
		logger.debug("suppression de la commande" + commande.getNum());
		gestionCommande.remove(commande);
	}

}
