package com.vaia.crm.session;

import java.io.Serializable;

/**
 * Created by nicholas.chi on 2018/5/2.
 */
public class UserSession implements Serializable {

    private Integer userId;

    private String userName;

    public UserSession() {
    }

    public UserSession(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
