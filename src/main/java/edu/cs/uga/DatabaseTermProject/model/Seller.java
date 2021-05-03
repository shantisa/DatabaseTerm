package edu.cs.uga.DatabaseTermProject.model;

/**
 *
 */
public class Seller {
    /* Instance variables */
    private String id, city, state;
    private int sold, delivered, zipCode;
    private float ratio, distance;

    /**
     *
     * @param id
     * @param city
     * @param state
     * @param sold
     * @param delivered
     * @param zipCode
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
     *
     * @param id
     * @param sold
     * @param delivered
     */
    public Seller(String id, int sold, int delivered){
        this.id = id;
        this.sold = sold;
        this.delivered = delivered;
        this.ratio = (sold != 0) ? delivered/(float)sold : 0;
    }

    /**
     *
     * @param id
     * @param city
     * @param state
     * @param distance
     */
    public Seller(String id, String city, String state, float distance){
        this.id = id;
        this.city = city;
        this.state = state;
        this.distance = distance;
    }

    /**
     *
     * @return
     */
    public float getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     */
    public void setDistance(float distance) {
        this.distance = distance;
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
    public int getDelivered() {
        return delivered;
    }

    /**
     *
     * @param delivered
     */
    public void setDelivered(int delivered) {
        this.delivered = delivered;
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
    public float getRatio() {
        return ratio;
    }

}
