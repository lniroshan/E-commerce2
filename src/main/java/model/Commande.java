package model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Commande")
public class Commande {

	@Id
	private int num;
	private Client client;
	private Date date;
	public Client getClient() {
		return client;
	}
	
	public Commande(Client client) {
		super();
		this.client = client;
		this.date = new Date();
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Commande [client=" + client + ", date=" + date + "]";
	}

	
	
}
