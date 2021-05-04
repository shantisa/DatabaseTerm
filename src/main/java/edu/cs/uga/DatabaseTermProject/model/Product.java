package edu.cs.uga.DatabaseTermProject.model;

/**
 * This class represents a product. Each product
 * contains a id, category, categoryID, price value, average
 * review score, and the number of products sold.
 */
public class Product {
    /* Instance variables */
    private String id, category, categoryId;
    private float price, score;
    private int sold;

    /**
     * Creates a product with an id, category, and price
     *
     * @param id the name(id) of a product
     * @param category the category of a product
     * @param price the price value of a product
     */
    public Product(String id, String category, float price){
        this.id = id;
        this.category = category.trim();
        this.price = price;
    }

    /**
     * Creates a product with a id, category, categoryID, price,
     * average review score, and number of products sold/
     *
     * @param id the name(id) of a product
     * @param category the category of a product
     * @param categoryId the categoryId of a product
     * @param price the price of a product
     * @param score the average review score of a product
     * @param sold the number of products sold
     */
    public Product(String id, String category, String categoryId, float price, float score, int sold){
        this(id,category,price);
        this.sold = sold;
        this.score = score;
        this.categoryId = categoryId;
    }

    /**
     *
     * @return the category id of a product
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId sets the category id of a product
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return the average review score of a product
     */
    public float getScore() {
        return score;
    }

    /**
     *
     * @param score sets the average review score of a product
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     *
     * @return the number of products sold
     */
    public int getSold() {
        return sold;
    }

    /**
     *
     * @param sold sets the number of products sold
     */
    public void setSold(int sold) {
        this.sold = sold;
    }

    /**
     *
     * @return the price value of a product
     */
    public float getPrice() {
        return price;
    }

    /**
     *
     * @param price sets the price value of a product
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *
     * @return the product id(name)
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id sets the product id(name)
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return the product category
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category sets the product category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
