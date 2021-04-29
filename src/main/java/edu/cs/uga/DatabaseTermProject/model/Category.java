package edu.cs.uga.DatabaseTermProject.model;

public class Category {
    private String name;
    private float min, max, avg;

    public Category(String name, float min, float max, float avg){
        this.name = name;
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }
}
