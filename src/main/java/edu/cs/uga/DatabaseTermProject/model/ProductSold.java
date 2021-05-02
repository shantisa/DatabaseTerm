package edu.cs.uga.DatabaseTermProject.model;

public class ProductSold {
    private String id;
    private int sold, delivered;
    private float ratio;

    public ProductSold(String id, int sold, int delivered) {
        this.id = id;
        this.sold = sold;
        this.delivered = delivered;
        this.ratio = (sold != 0) ? delivered/(float)sold : 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public float getRatio() {
        return ratio;
    }
}
