package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "client")
public class Client {
	
	@Id
	private String id; 
	private String nom;
	private String prenom;
	private String adresse;
	private String dateDeNaissance;
	private Panier panier;
	private String mail;
	private String motDePasse;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String adresse,
			String dateDeNaissance, Panier panier, String mail, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateDeNaissance = dateDeNaissance;
		this.panier = panier;
		this.mail = mail;
		this.motDePasse = motDePasse;
	}

	public String getAdresse() {
		return adresse;
	}



	public String getMail() {
		return mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public Panier getPanier() {
		return panier;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse="
				+ adresse + ", dateDeNaissance=" + dateDeNaissance
				+ ", panier=" + panier + ", mail=" + mail + ", motDePasse="
				+ motDePasse + "]";
	}

	
	
}
