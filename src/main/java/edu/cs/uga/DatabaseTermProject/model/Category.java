package edu.cs.uga.DatabaseTermProject.model;

/**
 * This class represents a category. Each category contains
 * a string name and a id. The category has a minimum, maximum,
 * average, and review score. It also contains the amount of products
 * sold.
 */
public class Category {

    /* Instance variables */
    private String name, id;
    private float min, max, avg, score;
    private int sold;

    /**
     * Creates a category with a name, id, min value,
     * max value, and avg value.
     *
     * @param name the name of the category
     * @param id the original name of the category, which is in portuguese
     * @param min the minimum price value of a item in a category
     * @param max the maximum price value of a item in a category
     * @param avg the average price value of items in a category
     */
    public Category(String name, String id, float min, float max, float avg){
        this.name = name;
        this.id = id;
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    /**
     * Creates a category with a name, id, min value, max value,
     * average value, review score, and sold.
     *
     * @param name the name of the category
     * @param id the original name of the category, which is in portuguese
     * @param min the minimum price value of a item in a category
     * @param max the maximum price value of a item in a category
     * @param avg the average price value of items in a category
     * @param score the review score of a category
     * @param sold the amount of sales a category has
     */
    public Category(String name, String id, float min, float max, float avg, float score, int sold){
        this(name, id, min, max, avg);
        this.score = score;
        this.sold = sold;
    }

    /**
     *
     * @return the review score of a category
     */
    public float getScore() {
        return score;
    }

    /**
     *
     * @param score sets the review score
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     *
     * @return the number of sales from a category
     */
    public int getSold() {
        return sold;
    }

    /**
     *
     * @param sold sets the amount of sales from a category
     */
    public void setSold(int sold) {
        this.sold = sold;
    }

    /**
     *
     * @return the id of a category
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id sets the id value of a category
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return the name of a category
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name sets the name of a category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the minimum value price of a item in the category
     */
    public float getMin() {
        return min;
    }

    /**
     *
     * @param min sets the minimum value of a item in a category
     */
    public void setMin(float min) {
        this.min = min;
    }

    /**
     *
     * @return the maximum value price of a item in the category
     */
    public float getMax() {
        return max;
    }

    /**
     *
     * @param max sets the maximum price of a item in a category
     */
    public void setMax(float max) {
        this.max = max;
    }

    /**
     *
     * @return the average price of items in the category
     */
    public float getAvg() {
        return avg;
    }

    /**
     *
     * @param avg sets the average price of items in the category
     */
    public void setAvg(float avg) {
        this.avg = avg;
    }
}
