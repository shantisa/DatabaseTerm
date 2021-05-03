package edu.cs.uga.DatabaseTermProject.model;

/**
 *
 */
public class ProductSold {
    /* Instance variables */
    private String id;
    private int sold, delivered;
    private float ratio;

    /**
     *
     * @param id
     * @param sold
     * @param delivered
     */
    public ProductSold(String id, int sold, int delivered) {
        this.id = id;
        this.sold = sold;
        this.delivered = delivered;
        this.ratio = (sold != 0) ? delivered/(float)sold : 0;
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
    public float getRatio() {
        return ratio;
    }
}
