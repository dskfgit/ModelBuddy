package com.thesetediousthings.modelbuddy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Date;

public class Paints {

    public static final List<Paint> ITEMS = new ArrayList<Paint>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Paint> ITEM_MAP = new HashMap<String, Paint>();

    private static final int COUNT = 7;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPaint(i));
        }
    }

    private static void addItem(Paint item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getItemIdStr(), item);
    }

    private static Paint createPaint(int position) {

        Paint aPaint = new Paint();
        aPaint.setItemId(position);
        Date aDate = new Date(System.currentTimeMillis());
        aPaint.setCreated(aDate);
        switch (position) {
            case 1:
                aPaint.setName("Desert Yellow");
                aPaint.setDesc("Camel colour");
                aPaint.setCode("XF-59");
                aPaint.setRemaining(20);
                aPaint.setType(VendorPaint.TYPE_ACRYLIC);
                break;
            case 2:
                aPaint.setName("Khaki Drab");
                aPaint.setDesc("Quite green");
                aPaint.setCode("XF-51");
                aPaint.setRemaining(60);
                aPaint.setType(VendorPaint.TYPE_ACRYLIC);
                break;
            case 3:
                aPaint.setName("Deck Tan");
                aPaint.setDesc("A greenish flat black");
                aPaint.setCode("XF-55");
                aPaint.setRemaining(100);
                aPaint.setType(VendorPaint.TYPE_ACRYLIC);
                break;
            case 4:
                aPaint.setName("Black");
                aPaint.setDesc("Gloss black");
                aPaint.setCode("X-1");
                aPaint.setRemaining(80);
                aPaint.setType(VendorPaint.TYPE_ACRYLIC);
                break;
            case 5:
                aPaint.setName("Black");
                aPaint.setDesc("Gloss black");
                aPaint.setCode("X-1");
                aPaint.setRemaining(80);
                aPaint.setType(VendorPaint.TYPE_ENAMEL);
                break;
            case 6:
                aPaint.setName("Metallic green");
                aPaint.setDesc("Metallic green");
                aPaint.setCode("TS-20");
                aPaint.setRemaining(80);
                aPaint.setType(VendorPaint.TYPE_SPRAY);
                break;
            case 7:
                aPaint.setName("Light gray");
                aPaint.setDesc("Light gray");
                aPaint.setCode("AS-2");
                aPaint.setRemaining(80);
                aPaint.setType(VendorPaint.TYPE_AIRMODEL_SPRAY);
                break;



        }

        aPaint.setNeedToBuy(false);
        aPaint.setQty(1);
        return aPaint;
    }

}
