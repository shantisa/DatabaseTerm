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
     *
     * @param name
     * @param id
     * @param min
     * @param max
     * @param avg
     */
    public Category(String name, String id, float min, float max, float avg){
        this.name = name;
        this.id = id;
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    /**
     *
     * @param name
     * @param id
     * @param min
     * @param max
     * @param avg
     * @param score
     * @param sold
     */
    public Category(String name, String id, float min, float max, float avg, float score, int sold){
        this(name, id, min, max, avg);
        this.score = score;
        this.sold = sold;
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public float getMin() {
        return min;
    }

    /**
     *
     * @param min
     */
    public void setMin(float min) {
        this.min = min;
    }

    /**
     *
     * @return
     */
    public float getMax() {
        return max;
    }

    /**
     *
     * @param max
     */
    public void setMax(float max) {
        this.max = max;
    }

    /**
     *
     * @return
     */
    public float getAvg() {
        return avg;
    }

    /**
     *
     * @param avg
     */
    public void setAvg(float avg) {
        this.avg = avg;
    }
}
