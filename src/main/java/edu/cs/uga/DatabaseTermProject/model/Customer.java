package edu.cs.uga.DatabaseTermProject.model;

/**
 * This class represents a customer. Each customer has a id, which
 * represents the customer name. A customer has a city, state,
 *  zip code. The class also have the amount a customer has spent
 *  on an item and the number of products bought.
 */
public class Customer {
    /* Instance variables */
    private String id, city, state;
    private int bought, zipCode;
    private float spent;

    /**
     * Creates a customer with an id and the number of
     * products bought.
     *
     * @param id the name(id) of the customer
     * @param bought the number of products bought
     */
    public Customer(String id, int bought){
        this.id = id;
        this.bought = bought;
    }

    /**
     * Creates a customer with an id, number of products bought,
     * and the amount of money spent on the items.
     *
     * @param id the name(id) of the customer
     * @param bought the number of products bought
     * @param spent the amount of money spent on the products purchased
     */
    public Customer(String id, int bought, float spent){
        this(id, bought);
        this.spent = spent;
    }

    /**
     * Creates a customer with an id, city, state, zip code,
     * number of products bought, and the amount of money spent
     * on the items.
     *
     * @param id the name(id) of the customer
     * @param city the customer city
     * @param state the customer state
     * @param zipCode the customer zip code
     * @param bought the number of products bought
     * @param spent the amount of money spent on products purchased
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
     * @return the customer city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city sets a customer city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return the customer state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state sets a customer state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return the customer zip code
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     *
     * @param zipCode sets a customer zip code
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @return the amount spent by a customer
     */
    public float getSpent() {
        return spent;
    }

    /**
     *
     * @param spent sets the amount spent by a customer
     */
    public void setSpent(float spent) {
        this.spent = spent;
    }

    /**
     *
     * @return the customer id(name)
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id sets the customer id(name)
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return the number of items bought by a customer
     */
    public int getBought() {
        return bought;
    }

    /**
     *
     * @param bought sets the number of items bought by a customer
     */
    public void setBought(int bought) {
        this.bought = bought;
    }
}
