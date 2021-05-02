package edu.cs.uga.DatabaseTermProject.model;

public class Customer {
    private String id, city, state;
    private int bought, zipCode;
    private float spent;

    public Customer(String id, int bought){
        this.id = id;
        this.bought = bought;
    }

    public Customer(String id, String city, String state, int zipCode, int bought, float spent){
        this(id, bought);
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.spent = spent;
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public float getSpent() {
        return spent;
    }

    public void setSpent(float spent) {
        this.spent = spent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBought() {
        return bought;
    }

    public void setBought(int bought) {
        this.bought = bought;
    }
}
