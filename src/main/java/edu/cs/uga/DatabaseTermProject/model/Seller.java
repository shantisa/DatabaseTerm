package edu.cs.uga.DatabaseTermProject.model;

/**
 * This class represents a seller. A seller contains an
 * id, city, state, zip code, number of sales and item
 * delivered by a seller. It also contains the distance and
 * delivered to undelivered ratio.
 */
public class Seller {
    /* Instance variables */
    private String id, city, state;
    private int sold, delivered, zipCode;
    private float ratio, distance;

    /**
     * Creates a seller with an id(name), city, state, zip code,
     * number of items sold and delivered.
     *
     * @param id the id(name) of a seller
     * @param city the seller city
     * @param state the seller state
     * @param sold the number of sales by a seller
     * @param delivered the number of items delivered by a seller
     * @param zipCode the seller zip code
     */
    public Seller(String id, String city, String state, int sold, int delivered, int zipCode) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.sold = sold;
        this.delivered = delivered;
        this.zipCode = zipCode;
        this.ratio = (sold != 0) ? delivered/(float)sold : 0;
    }


    /**
     * Creates a seller with an id, number of items sold
     * and delivered
     *
     * @param id the id(name) of seller
     * @param sold the number of sales
     * @param delivered the number of items delivered
     */
    public Seller(String id, int sold, int delivered){
        this.id = id;
        this.sold = sold;
        this.delivered = delivered;
        this.ratio = (sold != 0) ? delivered/(float)sold : 0;
    }

    /**
     * Creates a seller with an id, city, state, and
     * distance.
     *
     * @param id the id(name) of a seller
     * @param city the seller city
     * @param state the seller state
     * @param distance the distance from a given a customer
     */
    public Seller(String id, String city, String state, float distance){
        this.id = id;
        this.city = city;
        this.state = state;
        this.distance = distance;
    }

    /**
     *
     * @return the distance from a given customer
     */
    public float getDistance() {
        return distance;
    }

    /**
     *
     * @param distance sets the distance
     */
    public void setDistance(float distance) {
        this.distance = distance;
    }

    /**
     *
     * @return the id(name) of a seller
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id sets the id of a seller
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return the seller city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city sets the seller city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return the seller state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state sets the seller state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return the number of sales
     */
    public int getSold() {
        return sold;
    }

    /**
     *
     * @param sold sets the number of sales
     */
    public void setSold(int sold) {
        this.sold = sold;
    }

    /**
     *
     * @return the number of items delivered
     */
    public int getDelivered() {
        return delivered;
    }

    /**
     *
     * @param delivered sets the number of items delivered
     */
    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }

    /**
     *
     * @return the seller zip code
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     *
     * @param zipCode sets the seller zip code
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @return the delivered to undelivered ratio of a seller
     */
    public float getRatio() {
        return ratio;
    }

}
