package controller;

import java.util.ArrayList;
import java.util.List;

import model.Article;
import model.Client;
import model.Commande;
import model.Panier;

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
public class HomeController {
    
    @RequestMapping(value = "/store", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Article> list() {
        List<Article> articles = new ArrayList<Article>();
        Article a1 = new Article("meuble", "lavabo", 13, 1);
        Article a2 = new Article("toillette", "armoire", 14, 1);
        Article a3 = new Article("cuisine", "salle", 16, 1);
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        
        GestionArticle gestionArticle = new GestionArticle();
        return    gestionArticle.getStore();
//        return articles;
    }
    
    

    
    // ajout d'un nouveau client
   @RequestMapping(value="/addClient", method= RequestMethod.POST, consumes = "application/json")
	  public ResponseEntity<Object> paiementNouveauClient(@RequestBody final Client client) {
	   GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();
	   gestionUtilisateur.addClient(client);
	   return null;
   }
   
   // ajout d'un nouveau client
   @RequestMapping(value="/updateClient", method= RequestMethod.POST, consumes = "application/json")
	  public ResponseEntity<Object> modificationClient(@RequestBody final Client client) {
	   GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();
	   gestionUtilisateur.update(client);
	   return null;
   }
   
   // update d'un client
   @RequestMapping(value="/payerClient", method= RequestMethod.POST, consumes = "application/json")
	  public ResponseEntity<Object> paiementClient(@RequestBody final Client client) {
	   GestionCommande gestionCommande = new GestionCommande();
	   gestionCommande.ajouterCommande(client);
	    return null;
   }
   
   @RequestMapping(value="/authentification", method= RequestMethod.POST, consumes = "application/json")
	  public @ResponseBody ResponseEntity<Client> authentification(@RequestBody final Client client) {
	   GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();
	   Client findClient = gestionUtilisateur.authentification(client.getMail(),client.getMotDePasse());
	   if (findClient == null){
		   return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
	   }
	   
	   return  new ResponseEntity<Client>(findClient,HttpStatus.OK);
   }
    
   // ajout d'un nouveau article
   @RequestMapping(value="/ajoutArticle", method= RequestMethod.POST, consumes = "application/json")
	  public ResponseEntity<Object> ajouterArticle(@RequestBody final Article article) {
	   GestionArticle gestionArticle = new GestionArticle();
	   gestionArticle.add(article);
	   return null;
   }
   
   // suppression d'un article 
   @RequestMapping(value="/supprimerArticle", method= RequestMethod.POST, consumes = "application/json")
	  public ResponseEntity<Object> supprimerArticle(@RequestBody final Article article) {
	   GestionArticle gestionArticle = new GestionArticle();
	   gestionArticle.remove(article);
	   return null;
   }
   
   // modification d'un article 
   @RequestMapping(value="/modificationArticle", method= RequestMethod.POST, consumes = "application/json")
	  public ResponseEntity<Object> modificationArticle(@RequestBody final Article article) {
	   GestionArticle gestionArticle = new GestionArticle();
	   gestionArticle.update(article);
	   return null;
   }
   
   // recuperation commande 
   // modification d'un article 
   @RequestMapping(value="/getAllCommande", method= RequestMethod.GET, produces = "application/json")
	  public @ResponseBody List<Commande> recuperationCommande() {
GestionCommande gestionCommande  = new GestionCommande();
				return 	gestionCommande.getAllCommande();
   }
   
   
   // suppression d'une Commande 
   @RequestMapping(value="/supprimerCommande", method= RequestMethod.POST, consumes = "application/json")
	  public ResponseEntity<Object> supprimerCommande(@RequestBody final Commande commande) {
	   
	   GestionCommande gestionCommande = new GestionCommande();
	   gestionCommande.remove(commande);
	   return null;
   }
   
   
   
}
