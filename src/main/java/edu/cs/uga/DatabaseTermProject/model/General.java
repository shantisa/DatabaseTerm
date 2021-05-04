package edu.cs.uga.DatabaseTermProject.model;

/**
 * This class represents database aggregate values,
 * such as the average price, minimum price,
 * maximum price, and the count.
 */
public class General {
    /* Instance variables */
    private float avgPrice, minPrice, maxPrice;
    private int count;

    /**
     * Creates a general with the average price, minimum price,
     * maximum price, and the count
     *
     * @param avgPrice the average price value of items in a dataset
     * @param minPrice the minimum price value of an item in a dataset
     * @param maxPrice the maximum price value of an item in a dataset
     * @param count the number of items in a dataset
     */
    public General(float avgPrice, float minPrice, float maxPrice, int count) {
        this.avgPrice = avgPrice;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.count = count;
    }

    /**
     *
     * @return the average price value of items
     */
    public float getAvgPrice() {
        return avgPrice;
    }

    /**
     *
     * @param avgPrice sets the average price of items
     */
    public void setAvgPrice(float avgPrice) {
        this.avgPrice = avgPrice;
    }

    /**
     *
     * @return the minimum price value of items
     */
    public float getMinPrice() {
        return minPrice;
    }

    /**
     *
     * @param minPrice sets the minimum price value
     */
    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    /**
     *
     * @return the maximum price value of items
     */
    public float getMaxPrice() {
        return maxPrice;
    }

    /**
     *
     * @param maxPrice sets the maximum price value
     */
    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     *
     * @return the number of items in a dataset
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count sets the number of items in a dataset
     */
    public void setCount(int count) {
        this.count = count;
    }
}
