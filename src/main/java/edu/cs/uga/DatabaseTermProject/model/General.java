package edu.cs.uga.DatabaseTermProject.model;

public class General {
    /* Instance variables */
    private float avgPrice, minPrice, maxPrice;
    private int count;

    /**
     *
     * @param avgPrice
     * @param minPrice
     * @param maxPrice
     * @param count
     */
    public General(float avgPrice, float minPrice, float maxPrice, int count) {
        this.avgPrice = avgPrice;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.count = count;
    }

    /**
     *
     * @return
     */
    public float getAvgPrice() {
        return avgPrice;
    }

    /**
     *
     * @param avgPrice
     */
    public void setAvgPrice(float avgPrice) {
        this.avgPrice = avgPrice;
    }

    /**
     *
     * @return
     */
    public float getMinPrice() {
        return minPrice;
    }

    /**
     *
     * @param minPrice
     */
    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    /**
     *
     * @return
     */
    public float getMaxPrice() {
        return maxPrice;
    }

    /**
     *
     * @param maxPrice
     */
    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }
}
