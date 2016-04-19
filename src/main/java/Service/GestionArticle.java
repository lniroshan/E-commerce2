package Service;

import java.util.List;

import model.Article;

import org.springframework.stereotype.Service;

import dao.DaoArticle;

@Service
public class GestionArticle {


	DaoArticle daoArticle = new DaoArticle();
	
	public boolean add (Article article){
		return daoArticle.add(article);
	}

	public void remove(Article article) {
		daoArticle.remove(article);
	}

	public void update(Article article) {
		daoArticle.update(article);
	}

	public List<Article> getStore() {
		return 	daoArticle.getStore();

	}
	
	
}
