package edu.cs.uga.DatabaseTermProject.model;

public class Category {
    private String name, id;
    private float min, max, avg, score;
    private int sold;

    public Category(String name, String id, float min, float max, float avg){
        this.name = name;
        this.id = id;
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    public Category(String name, String id, float min, float max, float avg, float score, int sold){
        this(name, id, min, max, avg);
        this.score = score;
        this.sold = sold;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
