package com.thesetediousthings.modelbuddy;

public class Paint extends Item {

    private static final String[] BRANDS = {"Tamiya", "Mr. Color", "Humbrol"};
    private String code;
    private int remaining;
    private String sku;
    private int type;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
