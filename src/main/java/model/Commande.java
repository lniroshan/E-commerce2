package model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Commande")
public class Commande {

	@Id
	private String num;
	private Client client;
	private Date date;
	
	public Commande(){
		
	}
	
	public Commande(Client client) {
		super();
		this.client = client;
		this.date = new Date();
		
	}
	
	public Client getClient() {
		return client;
	}
	

	public void setClient(Client client) {
		this.client = client;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}



	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Commande [client=" + client + ", date=" + date + "]";
	}

	
	
}
