package com.thesetediousthings.modelbuddy;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ingredients {

    public static final List<Ingredient> ITEMS = new ArrayList<Ingredient>();
    public static final Map<String, Ingredient> ITEM_MAP = new HashMap<String, Ingredient>();

    private static final int COUNT = 8;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createIngredient(i));
        }
    }

    public static ArrayList<Ingredient> getIngredientsByRecipe(int recipeId) {

        ArrayList<Ingredient> forThisRecipe = new ArrayList<Ingredient>();

        for (int i=0; i<ITEMS.size(); i++) {
            Ingredient aIngredient = ITEMS.get(i);
            if (aIngredient.getRecipeId() == recipeId) {
                forThisRecipe.add(aIngredient);
            }
        }

        return forThisRecipe;
    }

    private static void addItem(Ingredient item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getItemIdStr(), item);
    }

    private static Ingredient createIngredient(int position) {

        PaintFactory pf = PaintFactory.getInstance();
        Ingredient aIngredient = new Ingredient();
        aIngredient.setItemId(position);
        Date aDate = new Date(System.currentTimeMillis());
        aIngredient.setCreated(aDate);
        switch (position) {
            case 1:
                aIngredient.setPart(1);
                aIngredient.setPaint(pf.getVendorPaintByKey(VendorPaint.CODE, "XF-1"));
                aIngredient.setRecipeId(1);
                break;
            case 2:
                aIngredient.setPart(2);
                aIngredient.setPaint(pf.getVendorPaintByKey(VendorPaint.CODE, "XF-2"));
                aIngredient.setRecipeId(1);
                break;
            case 3:
                aIngredient.setPart(3);
                aIngredient.setPaint(pf.getVendorPaintByKey(VendorPaint.CODE, "XF-3"));
                aIngredient.setRecipeId(1);
                break;
            case 4:
                aIngredient.setPart(1);
                aIngredient.setPaint(pf.getVendorPaintByKey(VendorPaint.CODE, "XF-4"));
                aIngredient.setRecipeId(2);
                break;
            case 5:
                aIngredient.setPart(2);
                aIngredient.setPaint(pf.getVendorPaintByKey(VendorPaint.CODE, "XF-5"));
                aIngredient.setRecipeId(2);
                break;
            case 6:
                aIngredient.setPart(3);
                aIngredient.setPaint(pf.getVendorPaintByKey(VendorPaint.CODE, "XF-6"));
                aIngredient.setRecipeId(2);
                break;
            case 7:
                aIngredient.setPart(1);
                aIngredient.setPaint(pf.getVendorPaintByKey(VendorPaint.CODE, "XF-7"));
                aIngredient.setRecipeId(3);
                break;
            case 8:
                aIngredient.setPart(2);
                aIngredient.setPaint(pf.getVendorPaintByKey(VendorPaint.CODE, "XF-8"));
                aIngredient.setRecipeId(3);
                break;
        }

        return aIngredient;
    }

}
