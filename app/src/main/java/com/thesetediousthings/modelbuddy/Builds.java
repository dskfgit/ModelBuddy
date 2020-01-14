package com.thesetediousthings.modelbuddy;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Builds {

    public static final List<Build> ITEMS = new ArrayList<Build>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Build> ITEM_MAP = new HashMap<String, Build>();

    private static final int COUNT = 3;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createBuild(i));
        }
    }

    private static void addItem(Build item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getItemIdStr(), item);
    }

    private static Build createBuild(int position) {

        Build aBuild = new Build();
        aBuild.setItemId(position);
        Date aDate = new Date(System.currentTimeMillis());
        aBuild.setCreated(aDate);
        switch (position) {
            case 1:
                aBuild.setName("Yamaha R1");
                aBuild.setDesc("A Tamiya 1/12 scale R1");
                aBuild.setScale(Build.SCALE_32);
                aBuild.setBrand("Tamiya");
                break;
            case 2:
                aBuild.setName("F4U Corsair");
                aBuild.setDesc("For Tim");
                aBuild.setScale(Build.SCALE_10);
                aBuild.setBrand("Hobby Boss");
                break;
            case 3:
                aBuild.setName("U-Boat");
                aBuild.setDesc("For Dad");
                aBuild.setScale(Build.SCALE_72);
                aBuild.setBrand("Revell");
                break;
        }

        aBuild.setNeedToBuy(false);
        aBuild.setQty(1);
        return aBuild;
    }

}
