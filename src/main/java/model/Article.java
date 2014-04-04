package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "article")
public class Article {
    
    private String sku;
    @Id
    private String name;
    private int price;
    private int quantity;
    
    public String getSku() {
        return this.sku;
    }
    
    public void setSku(final String sku) {
        this.sku = sku;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(final int price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
    
    public Article(final String sku, final String name, final int price, final int quantity) {
        super();
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Article() {
        
    }
    
    @Override
    public String toString() {
        return "Article [sku=" + this.sku + ", name=" + this.name + ", price=" + this.price + ", quantity="
               + this.quantity + "]";
    }
    
}
