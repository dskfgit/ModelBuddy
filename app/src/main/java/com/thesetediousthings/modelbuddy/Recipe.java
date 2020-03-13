package com.thesetediousthings.modelbuddy;

import java.util.ArrayList;

public class Recipe extends Item {

    private int volumeInMls;
    private String forColour;
    private String source;



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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setForColour(String forColour) {
        this.forColour = forColour;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
}
