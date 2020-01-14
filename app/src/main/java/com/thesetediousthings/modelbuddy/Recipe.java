package com.thesetediousthings.modelbuddy;

import java.util.ArrayList;

public class Recipe extends Item {

    private int volumeInMls;
    private String forColour;

    private ArrayList<Ingredient> ingredients;

    public Recipe() {
        ingredients = new ArrayList<Ingredient>();
    }

    public int getVolumeInMls() {
        return volumeInMls;
    }

    public void setVolumeInMls(int volumeInMls) {
        this.volumeInMls = volumeInMls;
    }

    public void addIngredient(int part, VendorPaint aVendorPaint) {
        ingredients.add(new Ingredient(part, aVendorPaint));
    }

    public void addIngredientWithCode(int part, int type, String code) {
        PaintFactory pf = PaintFactory.getInstance();
        Ingredient ingredient = new Ingredient();
        VendorPaint aPaint = pf.getVendorPaintByKey(type, code);
        ingredient.setPart(part);
        ingredient.setPaint(aPaint);
        ingredients.add(ingredient);
    }

    public int getNumIngredients() {
        int num = 0;
        if (ingredients != null) {
            num = ingredients.size();
        }
        return num;
    }

    public String getForColour() {
        return forColour;
    }

    public void setForColour(String forColour) {
        this.forColour = forColour;
    }

}
