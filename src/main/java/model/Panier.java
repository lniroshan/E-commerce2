package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Panier")
public class Panier {
    
    @Override
    public String toString() {
        return "Panier [clientName=" + this.clientName + ", clearCart=" + this.clearCart + ", totalprice="
               + this.totalprice + ", items=" + this.items + "]";
    }
    
    private String clientName;
    private boolean clearCart;
    private int totalprice;
    private List<Article> items;
    
    public Panier() {
        this.clientName = "";
        this.clearCart = false;
        this.items = new ArrayList<Article>();
        
    }
    
    public Panier(final String clientName, final boolean clearCart, final int totalprice, final List<Article> items) {
        super();
        this.clientName = clientName;
        this.clearCart = clearCart;
        this.totalprice = totalprice;
        this.items = items;
    }
    
    public Panier(final List<Article> items) {
        this.items = items;
    }
    
    public String getClientName() {
        return this.clientName;
    }
    
    public void setClientName(final String clientName) {
        this.clientName = clientName;
    }
    
    public boolean isClearCart() {
        return this.clearCart;
    }
    
    public void setClearCart(final boolean clearCart) {
        this.clearCart = clearCart;
    }
    
    public List<Article> getItems() {
        return this.items;
    }
    
    public void setItems(final List<Article> items) {
        this.items = items;
    }
    
    public int getTotalprice() {
        return this.totalprice;
    }
    
    public void setTotalprice(final int totalprice) {
        this.totalprice = totalprice;
    }
    
    public void add(final Article article) {
        this.items.add(article);
    }
    
}
