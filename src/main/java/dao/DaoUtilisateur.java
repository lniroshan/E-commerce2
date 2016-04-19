	package dao;

import java.util.List;

import model.Client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class DaoUtilisateur {


	private MongoOperations mongoOperation ;  
	public DaoUtilisateur (){
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("SpringMongoConfig.xml");
	 this.mongoOperation = 
                (MongoOperations) ctx.getBean("mongoTemplate");
	}
	
	public boolean add(Client client) {
		List<Client> client2 = mongoOperation.findAll(Client.class);
		System.out.println(client2);
		mongoOperation.save(client);
		return true;
	}

	public boolean connection(String nom, String motDePasse) {
		return true;
	}

	public boolean delete(Client client) {
		mongoOperation.remove(client);
		return true;
	}

	public Client findUtilisateur(String nom, String mdp) {
		Query searchUserQuery = new Query(Criteria.where("mail").is(mdp).and("motDePasse").is(nom));
		System.out.println(searchUserQuery.toString());
		Client FindUser = mongoOperation.findOne(searchUserQuery, Client.class);
		return 	FindUser;
	}

	public boolean update(Client client) {
		mongoOperation.save(client);
		return true;
	}

}
