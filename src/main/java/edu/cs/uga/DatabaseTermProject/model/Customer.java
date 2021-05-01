package edu.cs.uga.DatabaseTermProject.model;

public class Customer {
    private String id;
    private int bought;

    public Customer(String id, int bought){
        this.id = id;
        this.bought = bought;
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
