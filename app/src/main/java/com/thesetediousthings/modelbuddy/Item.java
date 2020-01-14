package com.thesetediousthings.modelbuddy;

import java.sql.Date;

public class Item extends BasicItem {

    private String name;
    private String desc;
    private int qty;
    private boolean needToBuy;

    public boolean isNeedToBuy() {
        return needToBuy;
    }

    public void setNeedToBuy(boolean needToBuy) {
        this.needToBuy = needToBuy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
