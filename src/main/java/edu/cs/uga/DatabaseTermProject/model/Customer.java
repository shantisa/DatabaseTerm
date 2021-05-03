package edu.cs.uga.DatabaseTermProject.model;

/**
 *
 */
public class Customer {
    /* Instance variables */
    private String id, city, state;
    private int bought, zipCode;
    private float spent;

    /**
     *
     * @param id
     * @param bought
     */
    public Customer(String id, int bought){
        this.id = id;
        this.bought = bought;
    }

    /**
     *
     * @param id
     * @param bought
     * @param spent
     */
    public Customer(String id, int bought, float spent){
        this(id, bought);
        this.spent = spent;
    }

    /**
     *
     * @param id
     * @param city
     * @param state
     * @param zipCode
     * @param bought
     * @param spent
     */
    public Customer(String id, String city, String state, int zipCode, int bought, float spent){
        this(id, bought);
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.spent = spent;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     *
     * @param zipCode
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @return
     */
    public float getSpent() {
        return spent;
    }

    /**
     *
     * @param spent
     */
    public void setSpent(float spent) {
        this.spent = spent;
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
    public int getBought() {
        return bought;
    }

    /**
     *
     * @param bought
     */
    public void setBought(int bought) {
        this.bought = bought;
    }
}
