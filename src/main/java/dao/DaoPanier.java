package dao;

import model.Article;
import model.Panier;

public class DaoPanier {

//	public Panier add(Article article, Panier panier) {
//		panier.setMontant(panier.getMontant() + article.getPrix());
//		panier.setArticles(article);
//		return panier;
//	}
//
//	public Panier delete(int id, Panier panier) {
//		System.out.println("supprimer" + id);
//		Article article = findNomArticle(id, panier);
//		panier.getArticles().remove(article);
//		System.out.println(article + "prix ");
//		panier.setMontant(panier.getMontant() - article.getPrix());
//
//		return panier;
//	}
//
//	public Panier delete(String nom, Panier panier) {
//		System.out.println("supprimer" + nom);
//		Article article = findNomArticle(nom, panier);
//		panier.getArticles().remove(article);
//		System.out.println(article + "prix ");
//		panier.setMontant(panier.getMontant() - article.getPrix());
//
//		return panier;
//	}
//
//	public boolean findArticle(Article article, Panier panier) {
//		return panier.getArticles().contains(article);
//	}
//
//	public Article findNomArticle(int idArticle, Panier panier) {
//		for (Article article : panier.getArticles()) {
//			if (article.getId() == idArticle) {
//				return article;
//			}
//		}
//		return null;
//	}
//
//	public Article findNomArticle(String nomArticle, Panier panier) {
//		for (Article article : panier.getArticles()) {
//			if (article.getNom().equals(nomArticle.trim())) {
//				return article;
//			}
//		}
//		return null;
//	}
//
//	public boolean IsContainsArticle(String nomArticle, Panier panier) {
//		if (findNomArticle(nomArticle, panier) == null) {
//			return false;
//		}
//		return true;
//	}
//
//	public Panier update(Article article, Panier panier) {
//		panier.setUpdateArticle(article);
//		panier.setMontant(panier.getMontant() - article.getPrix());
//		return panier;
//	}
//
//	public Panier update(String nomarticle, Panier panier) {
//		Article article = findNomArticle(nomarticle, panier);
//		panier.getArticles().remove(article);
//
//		panier.setMontant(panier.getMontant() - article.getPrix());
//
//		return panier;
//	}
//
//	public boolean commander(Panier panier) {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
