package com.thesetediousthings.modelbuddy;

import java.util.Date;

public class Comment {

    private String comment;
    private String madeBy;
    private Date created;

    public Comment(String comment) {
        this.comment = comment;
        created = new Date();
        created.setTime(System.currentTimeMillis());
    }

    public String getComment() {
        return comment;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public Date getCreated() {
        return created;
    }
}
