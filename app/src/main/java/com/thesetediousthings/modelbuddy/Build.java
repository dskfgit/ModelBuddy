package com.thesetediousthings.modelbuddy;

public class Build extends Item {

    private static final String[] BRANDS = {"Tamiya", "Revell", "Hobby Boss", "Airfix", "Hasegawa"};
    public static final int SCALE_144 = 1;
    public static final int SCALE_72 = 2;
    public static final int SCALE_48 = 3;
    public static final int SCALE_32 = 4;
    public static final int SCALE_12 = 5;
    public static final int SCALE_10 = 6;

    private String brand;
    private int scale;
    private float cost;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
