package edu.cs.uga.DatabaseTermProject.model;
public class Product {
    private String id, category, categoryId;
    private float price, score;
    private int sold;

    public Product(String id, String category, float price){
        this.id = id;
        this.category = category.trim();
        this.price = price;
    }

    public Product(String id, String category, String categoryId, float price, float score, int sold){
        this(id,category,price);
        this.sold = sold;
        this.score = score;
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
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
