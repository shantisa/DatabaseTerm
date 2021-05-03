package edu.cs.uga.DatabaseTermProject.model;

/**
 *
 */
public class Product {
    /* Instance variables */
    private String id, category, categoryId;
    private float price, score;
    private int sold;

    /**
     *
     * @param id
     * @param category
     * @param price
     */
    public Product(String id, String category, float price){
        this.id = id;
        this.category = category.trim();
        this.price = price;
    }

    /**
     *
     * @param id
     * @param category
     * @param categoryId
     * @param price
     * @param score
     * @param sold
     */
    public Product(String id, String category, String categoryId, float price, float score, int sold){
        this(id,category,price);
        this.sold = sold;
        this.score = score;
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     */
    public float getScore() {
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     *
     * @return
     */
    public int getSold() {
        return sold;
    }

    /**
     *
     * @param sold
     */
    public void setSold(int sold) {
        this.sold = sold;
    }

    /**
     *
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
