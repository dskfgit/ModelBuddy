package com.thesetediousthings.modelbuddy;

public class Ingredient extends BasicItem {

    private int part;
    private int recipeId;

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    private VendorPaint paint;

    public Ingredient() {}

    public Ingredient(int part, VendorPaint paint) {
        this.paint = paint;
        this.part = part;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public VendorPaint getPaint() {
        return paint;
    }

    public void setPaint(VendorPaint paint) {
        this.paint = paint;
    }
}
