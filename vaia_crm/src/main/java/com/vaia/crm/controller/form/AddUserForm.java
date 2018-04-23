package com.vaia.crm.controller.form;

import org.apache.commons.lang.StringUtils;

/**
 * Created by nicholas.chi on 2018/4/23.
 */
public class AddUserForm {

    private String userName;

    private String name;

    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AddUserForm{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean isEmpty(){
        if(StringUtils.isBlank(this.userName)){
            return true;
        }
        if(StringUtils.isBlank(this.name)){
            return true;
        }
        if(StringUtils.isBlank(this.password)){
            return true;
        }
        return false;
    }
}
