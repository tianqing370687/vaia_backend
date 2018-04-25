package com.vaia.service.dto;

import com.vaia.constant.RetMessageEnum;

/**
 * Created by nicholas.chi on 2018/4/25.
 */
public class LoginDTO {

    private RetMessageEnum retCode;
    private String userName;
    private String name;

    public RetMessageEnum getRetCode() {
        return retCode;
    }

    public void setRetCode(RetMessageEnum retCode) {
        this.retCode = retCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
