package com.thesetediousthings.modelbuddy;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuildsFactory {

    // static variable single_instance of type Singleton
    private static final int COUNT = 3;
    private static BuildsFactory instance = null;

    private Map<String, Build> builds;
    private List<Build> items;

    // private constructor restricted to this class itself
    private BuildsFactory()
    {
        builds = new HashMap<String, Build>();
        items = new ArrayList<Build>();
        loadBuilds();
    }

    private void loadBuilds() {

        for (int i = 1; i <= COUNT; i++) {
            addItem(createBuild(i));
        }

    }

    // static method to create instance of Singleton class
    public static BuildsFactory getInstance()
    {
        if (instance == null) {
            instance = new BuildsFactory();
        }
        return instance;
    }

    private void addItem(Build item) {
        items.add(item);
        builds.put(item.getItemIdStr(), item);
    }

    private Build createBuild(int position) {

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

    public Map<String, Build> getBuilds() {
        return builds;
    }

    public List<Build> getItems() {
        return items;
    }

    public void setBuild(Build build) {
        //Find the build and replace it.
        //IDs start at 1
        String buildId = build.getItemIdStr();
        int buildIdInt = Integer.valueOf(buildId) - 1;
        builds.put(buildId, build);
        items.set(buildIdInt, build);
    }

    public Build getBuildbyId(String id) {
        //Return the build that matches this id.
        //IDs start at 1
        return builds.get(id);
    }


}