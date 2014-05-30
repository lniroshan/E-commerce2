package dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import model.Article;

public class DaoArticle {

	private MongoOperations mongoOperation ;  
	public DaoArticle (){
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringMongoConfig.xml");
	 this.mongoOperation = 
                (MongoOperations) ctx.getBean("mongoTemplate");
	 
	}
	

	public boolean update (Article article){
		mongoOperation.save(article);
		return true ;
	}
	

	
	public boolean add (Article article){
		mongoOperation.save(article);
		return true ;
	}


	public void remove(Article article) {
		mongoOperation.remove(article);

	}


	public List<Article> getStore() {
		return mongoOperation.findAll(Article.class);
	}
	
}
