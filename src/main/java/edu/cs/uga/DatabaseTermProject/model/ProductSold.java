package edu.cs.uga.DatabaseTermProject.model;

/**
 * This class represents a sold product. ProductSold contains the product
 * id, the number of products sold and delivered. It also has the ratio.
 */
public class ProductSold {
    /* Instance variables */
    private String id;
    private int sold, delivered;
    private float ratio;

    /**
     * Creates a productsold that has a id, number of items sold
     * and delivered
     *
     * @param id the id(name) of the product
     * @param sold the number of products sold
     * @param delivered the number of products delivered
     */
    public ProductSold(String id, int sold, int delivered) {
        this.id = id;
        this.sold = sold;
        this.delivered = delivered;
        this.ratio = (sold != 0) ? delivered/(float)sold : 0;
    }

    /**
     *
     * @return the product id(name)
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id sets the product id(name)
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return the number of products sold
     */
    public int getSold() {
        return sold;
    }

    /**
     *
     * @param sold set the number of products sold
     *
     */
    public void setSold(int sold) {
        this.sold = sold;
    }

    /**
     *
     * @return the number of products delivered
     */
    public int getDelivered() {
        return delivered;
    }

    /**
     *
     * @param delivered set the number of products delivered
     */
    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }

    /**
     *
     * @return the ratio of a product, which the delivered to undelivered ratio
     */
    public float getRatio() {
        return ratio;
    }
}
