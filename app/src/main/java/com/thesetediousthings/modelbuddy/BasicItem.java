package com.thesetediousthings.modelbuddy;

import java.sql.Date;

public class BasicItem {

    public static final String ARG_ITEM_ID = "item_id";

    private Date created;
    private int itemId;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemIdStr() {
        return new Integer(itemId).toString();
    }

}
