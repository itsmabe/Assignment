package ibmassignment.me.com.ibmassignment.model;

import java.io.Serializable;

public class Item implements Serializable {

    private String title;
    private String price;
    private String currency;
    private String description;


    public Item(String title, String price, String currency, String description) {
        this.title = title;
        this.price = price;
        this.currency = currency;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
