package dao;

import java.util.List;

import model.Commande;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class DaoCommande {

	private MongoOperations mongoOperation ;  
	
	public DaoCommande(){
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("SpringMongoConfig.xml");
	 this.mongoOperation = 
                (MongoOperations) ctx.getBean("mongoTemplate");
	}
	
	
	public void add(Commande  commande){
		 mongoOperation.save(commande);
	}


	public List<Commande> allCommande() {
		
		 return mongoOperation.findAll(Commande.class);
	}
	
	
}
