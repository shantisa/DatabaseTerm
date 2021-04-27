package edu.cs.uga.DatabaseTermProject.model;
public class Product {
    private String id, category;
    private float price;

    public Product(String id, String category, float price){
        this.id = id;
        this.category = category.trim();
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
