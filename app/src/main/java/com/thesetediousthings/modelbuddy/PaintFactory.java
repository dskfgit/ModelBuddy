package com.thesetediousthings.modelbuddy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class PaintFactory {

    private static PaintFactory paintFactory = null;
    private Map<String, VendorPaint> paints;
    private int loadingVendor = 0;

    //TODO: Make this a singleton

    private PaintFactory() {
    }

    public static PaintFactory getInstance() {
        if (paintFactory == null) {
            paintFactory = new PaintFactory();
            paintFactory.paints = new HashMap<String, VendorPaint>();
            paintFactory.loadTamiya();
        }
        return paintFactory;
    }

    public VendorPaint getVendorPaintByKey(int field, String key) {

        VendorPaint match = null;

        switch (field) {
            case VendorPaint.SKU:
                match = paints.get(key);
                break;

            case VendorPaint.CODE:

                Iterator it = paints.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    VendorPaint avp = (VendorPaint) pair.getValue();
                    if (avp.getCode().equalsIgnoreCase(key)) {
                        match = avp;
                    }
                }
                break;
        }
        return match;
    }


    public void add(String sku, String code, String desc) {

        paints.put(sku, new VendorPaint(sku, code, desc, loadingVendor));

    }

    public void loadTamiya() {

        loadingVendor = VendorPaint.VENDOR_TAMIYA;

        //Acrylic Gloss
        add("81001", "X-1", "Black");
        add("81002", "X-2", "White");
        add("81003", "X-3", "Royal blue");
        add("81004", "X-4 ", "Blue");
        add("81005", "X-5 ", "Green");
        add("81006", "X-6", "Orange");
        add("81007", "X-7", "Red");
        add("81008", "X-8", "Lemon yellow");
        add("81009", "X-9", "Brown");
        add("81010", "X-10", "Gun metal");
        add("81011", "X-11", "Chrome silver");
        add("81012", "X-12", "Gold leaf");
        add("81013", "X-13 ", "Metallic blue");
        add("81014", "X-14 ", "Sky blue");
        add("81015", "X-15", "Light green");
        add("81016", "X-16", "Purple");
        add("81017", "X-17", "Pink");
        add("81018", "X-18", "Semi gloss black");
        add("81019", "X-19", "Smoke");
        add("81020", "X-20A", "Acrylic thinner");

        //Acrylic Flat
        add("81301", "XF-1", "Flat black");
        add("81302", "XF-2", "Flat white");
        add("81303", "XF-3", "Flat yellow");
        add("81304", "XF-4", "Yellow green");
        add("81305", "XF-5", "Flat green");
        add("81306", "XF-6", "Copper");
        add("81307", "XF-7", "Flat red");
        add("81308", "XF-8", "Flat blue");
        add("81309", "XF-9", "Hull red");
        add("81310", "XF-10", "Flat brown");
        add("81311", "XF-11", "J.N. green");
        add("81312", "XF-12", "J.N. grey");
        add("81313", "XF-13", "J.A. green");
        add("81314", "XF-14", "J.A. grey");
        add("81315", "XF-15", "Flat flesh");
        add("81316", "XF-16", "Flat aluminum");
        add("81317", "XF-17", "Sea blue");
        add("81318", "XF-18", "Medium blue");
        add("81319", "XF-19", "Sky grey");
        add("81320", "XF-20", "Medium grey");
        add("81321", "XF-21", "Sky");
        add("81322", "XF-22", "RLM grey");
        add("81323", "XF-23", "Light blue");
        add("81324", "XF-24", "Dark grey");
        add("81325", "XF-25", "Light sea grey");
        add("81326", "XF-26", "Deep green");
        add("81327", "XF-27", "Black green");
        add("81328", "XF-28", "Dark copper");
        add("81349", "XF-49", "Khaki");
        add("81350", "XF-50", "Field blue");
        add("81351", "XF-51", "Khaki drab");
        add("81352", "XF-52", "Flat earth");
        add("81353", "XF-53", "Neutral grey");
        add("81354", "XF-54", "Dark sea grey");
        add("81355", "XF-55", "Deck tan");
        add("81356", "XF-56", "Metallic grey");
        add("81357", "XF-57", "Buff");
        add("81358", "XF-58", "Olive green");
        add("81359", "XF-59", "Desert yellow");
        add("81360", "XF-60", "Dark yellow");
        add("81361", "XF-61", "Dark green");
        add("81362", "XF-62", "Olive drab");
        add("81363", "XF-63", "German grey");
        add("81364", "XF-64", "Red brown");
        add("81365", "XF-65", "Field grey");
        add("81366", "XF-66", "Light grey");
        add("81367", "XF-67", "NATO green");
        add("81368", "XF-68", "NATO brown");
        add("81369", "XF-69", "NATO black");
        add("81370", "XF-70", "Dark green 2");
        add("81371", "XF-71", "Cockpit green (IJN)");

        //Spray for Aircraft
        add("86501", "AS-1", "Dark green");
        add("86502", "AS-2", "Light gray");
        add("86503", "AS-3", "Gray green");
        add("86504", "AS-4", "Gray violet");
        add("86505", "AS-5", "Light blue");
        add("86506", "AS-6", "Olive drab");
        add("86507", "AS-7", "Neutral gray");
        add("86508", "AS-8", "Navy blue");
        add("86509", "AS-9", "Dark green");
        add("86510", "AS-10", "Ocean gray");
        add("86511", "AS-11", "Medium sea gray");
        add("86512", "AS-12", "Bare-metal silver");
        add("86513", "AS-13", "Green");
        add("86514", "AS-14", "Olive green");
        add("86515", "AS-15", "Tan");
        add("86516", "AS-16", "Light gray");
        add("86517", "AS-17", "Dark green (IJA)");
        add("86518", "AS-18", "Light gray (IJA)");
        add("86519", "AS-19", "Intermediate blue");
        add("86520", "AS-20", "Insignia white");
        add("86521", "AS-21", "Dark green 2 (IJN)");
        add("86522", "AS-22", "Dark earth");
        add("86523", "AS-23", "Light green (Luftwaffe)");
        add("86524", "AS-24", "Dark green (Luftwaffe)");
        add("86525", "AS-25", "Dark ghost grey");
        add("86526", "AS-26", "Light ghost grey");
        add("86527", "AS-27", "Gunship gray 2");
        add("86528", "AS-28", "Medium gray");
        add("86529", "AS-29", "Gray green (IJN)");
        add("86530", "AS-30", "Dark green 2");
        add("86531", "AS-31", "Ocean gray 2");
        add("86532", "AS-32", "Medium Sea Gray 2");

        //Spray
        add("85001", "TS-1","Red brown");
        add("85002", "TS-2","Dark green");
        add("85003", "TS-3","Dark yellow");
        add("85004", "TS-4","German grey");
        add("85005", "TS-5","Olive drab");
        add("85006", "TS-6","Matt black");
        add("85007", "TS-7","Racing white");
        add("85008", "TS-8","Italian red");
        add("85009", "TS-9","British green");
        add("85010", "TS-10","French blue");

        add("85011","TS-11","Maroon");
        add("85012","TS-12","Orange");
        add("85013","TS-13","Clear");
        add("85014","TS-14","Black");
        add("85015","TS-15","Blue");

        add("85016","TS-16", "Yellow");
        add("85017","TS-17","Gloss aluminum");
        add("85018","TS-18","Metallic red");
        add("85019","TS-19","Metallic blue");
        add("85020","TS-20","Metallic green");

        add("85021","TS-21","Gold");
        add("85022","TS-22","Light green");
        add("85023","TS-23","Light blue");
        add("85024","TS-24","Purple");
        add("85025","TS-25","Pink");

        add("85026","TS-26","Pure white");
        add("85027","TS-27","Matt white");
        add("85028","TS-28","Olive drab 2");
        add("85029","TS-29","Semi gloss black");
        add("85030","TS-30","Silver leaf");

    }

}
