package com.hitsz.frequency.entity;

/**
 * @author yang
 * @create 2021-04-15 9:07
 */
public class Glass {
    private Integer id;
    private double width;
    private double height;
    private double thick;
    private double elasticModulus;
    private double poissonRatio;
    private double upper;
    private double highThreshold;
    private double lowThreshold;
    private double lower;

    public Glass() {
    }

    public Glass(Integer id, double width, double height, double thick, double elasticModulus, double poissonRatio, double upper, double highThreshold, double lowThreshold, double lower) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.thick = thick;
        this.elasticModulus = elasticModulus;
        this.poissonRatio = poissonRatio;
        this.upper = upper;
        this.highThreshold = highThreshold;
        this.lowThreshold = lowThreshold;
        this.lower = lower;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getThick() {
        return thick;
    }

    public void setThick(double thick) {
        this.thick = thick;
    }

    public double getElasticModulus() {
        return elasticModulus;
    }

    public void setElasticModulus(double elasticModulus) {
        this.elasticModulus = elasticModulus;
    }

    public double getPoissonRatio() {
        return poissonRatio;
    }

    public void setPoissonRatio(double poissonRatio) {
        this.poissonRatio = poissonRatio;
    }

    public double getUpper() {
        return upper;
    }

    public void setUpper(double upper) {
        this.upper = upper;
    }

    public double getHighThreshold() {
        return highThreshold;
    }

    public void setHighThreshold(double highThreshold) {
        this.highThreshold = highThreshold;
    }

    public double getLowThreshold() {
        return lowThreshold;
    }

    public void setLowThreshold(double lowThreshold) {
        this.lowThreshold = lowThreshold;
    }

    public double getLower() {
        return lower;
    }

    public void setLower(double lower) {
        this.lower = lower;
    }

    @Override
    public String toString() {
        return "Glass{" +
                "id=" + id +
                ", width=" + width +
                ", height=" + height +
                ", thick=" + thick +
                ", elasticModulus=" + elasticModulus +
                ", poissonRatio=" + poissonRatio +
                ", upper=" + upper +
                ", highThreshold=" + highThreshold +
                ", lowThreshold=" + lowThreshold +
                ", lower=" + lower +
                '}';
    }
}
