package edu.cs.uga.DatabaseTermProject.model;

public class Seller {
    private String id, city, state;
    private int sold, delivered, zipCode;
    private float ratio, distance;

    public Seller(String id, String city, String state, int sold, int delivered, int zipCode) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.sold = sold;
        this.delivered = delivered;
        this.zipCode = zipCode;
        this.ratio = (sold != 0) ? delivered/(float)sold : 0;
    }

    public Seller(String id, String city, String state, float distance){
        this.id = id;
        this.city = city;
        this.state = state;
        this.distance = distance;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getDelivered() {
        return delivered;
    }

    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public float getRatio() {
        return ratio;
    }

}
