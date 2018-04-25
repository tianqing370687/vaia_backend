package com.vaia.crm.controller.vo;

import com.vaia.service.dto.LoginDTO;

/**
 * Created by nicholas.chi on 2018/4/25.
 */
public class LoginVO extends BaseVO {

    private String userName;
    private String name;

    public LoginVO() {
    }

    public LoginVO(LoginDTO dto) {
        this.userName = dto.getUserName();
        this.name = dto.getName();
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
