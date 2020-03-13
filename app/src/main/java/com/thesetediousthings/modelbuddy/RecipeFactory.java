package com.thesetediousthings.modelbuddy;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeFactory {

    private static RecipeFactory instance = null;
    public List<Recipe> items;
    public Map<String, Recipe> items_map;

    private RecipeFactory() {
         items = new ArrayList<Recipe>();
         items_map = new HashMap<String, Recipe>();
         generateDummyEntries();
    }

    public static RecipeFactory getInstance() {
        if (instance == null) {
            instance = new RecipeFactory();
        }
        return instance;
    }

    public List<Recipe> getItems() {
        return items;
    }

    public Map<String, Recipe> getItems_map() {
        return items_map;
    }

    public void generateDummyEntries() {
            // Add some sample items.
            for (int i = 1; i <= 3; i++) {
                addItem(createDummyRecipe(i));
            }
    }

    private void addItem(Recipe item) {
        items.add(item);
        items_map.put(item.getItemIdStr(), item);
    }

    private Recipe createDummyRecipe(int position) {

        Recipe aRecipe = new Recipe();
        aRecipe.setItemId(position);
        Date aDate = new Date(System.currentTimeMillis());
        aRecipe.setCreated(aDate);
        switch (position) {
            case 1:
                aRecipe.setName("Cockpit HE-111P");
                aRecipe.setDesc("Cockpit of HE-111P");
                aRecipe.setForColour("Funky Green");
                aRecipe.setSource("A link of some sort");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81001");
                aRecipe.addIngredientWithCode(2, VendorPaint.SKU, "81002");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81003");
                aRecipe.setVolumeInMls(100);
                Comment comment = new Comment("Here is a comment...");
                comment.setMadeBy("Me");
                aRecipe.addComment(comment);
                break;
            case 2:
                aRecipe.setName("R1 Metal");
                aRecipe.setDesc("Yamaha R1 metal");
                aRecipe.setForColour("Yay Metal");
                aRecipe.setSource("A link of some sort");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81001");
                aRecipe.addIngredientWithCode(2, VendorPaint.SKU, "81002");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81003");
                aRecipe.setVolumeInMls(50);
                comment = new Comment("Here is one more comment...");
                comment.setMadeBy("SomeBloke");
                aRecipe.addComment(comment);
                break;
            case 3:
                aRecipe.setName("DunkelGrau");
                aRecipe.setDesc("A Tamiya version of DunkelGrau");
                aRecipe.setForColour("DunkelGrau");
                aRecipe.setSource("https://www.britmodeller.com/forums/index.php?/topic/234983871-tamiya-acrylics-mixes/");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81001");
                aRecipe.addIngredientWithCode(2, VendorPaint.SKU, "81002");
                aRecipe.addIngredientWithCode(1, VendorPaint.SKU, "81003");
                aRecipe.setVolumeInMls(200);
                comment = new Comment("Here is another comment...");
                comment.setMadeBy("DSKF");
                aRecipe.addComment(comment);
                break;
        }

        aRecipe.setNeedToBuy(false);
        aRecipe.setQty(1);
        return aRecipe;
    }

}
