package com.thesetediousthings.modelbuddy;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipes {

    public static final List<Recipe> ITEMS = new ArrayList<Recipe>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Recipe> ITEM_MAP = new HashMap<String, Recipe>();

    private static final int COUNT = 3;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createRecipe(i));
        }
    }

    private static void addItem(Recipe item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getItemIdStr(), item);
    }

    private static Recipe createRecipe(int position) {

        Recipe aRecipe = new Recipe();
        aRecipe.setItemId(position);
        Date aDate = new Date(System.currentTimeMillis());
        aRecipe.setCreated(aDate);
        switch (position) {
            case 1:
                aRecipe.setName("Recipe 1");
                aRecipe.setDesc("Cockpit of HE-111P");
                aRecipe.setForColour("Funky Green");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81001");
                aRecipe.addIngredientWithCode(2, VendorPaint.SKU, "81002");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81003");
                aRecipe.setVolumeInMls(100);
                break;
            case 2:
                aRecipe.setName("Recipe 2");
                aRecipe.setDesc("Yamaha R1 metal");
                aRecipe.setForColour("Yay Metal");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81001");
                aRecipe.addIngredientWithCode(2, VendorPaint.SKU, "81002");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81003");
                aRecipe.setVolumeInMls(50);
                break;
            case 3:
                aRecipe.setName("Recipe 3");
                aRecipe.setDesc("A Tamiya version of DunkelGrau");
                aRecipe.setForColour("DunkelGrau");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81001");
                aRecipe.addIngredientWithCode(2, VendorPaint.SKU, "81002");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81003");
                aRecipe.setVolumeInMls(200);
                break;
        }

        aRecipe.setNeedToBuy(false);
        aRecipe.setQty(1);
        return aRecipe;
    }

}
