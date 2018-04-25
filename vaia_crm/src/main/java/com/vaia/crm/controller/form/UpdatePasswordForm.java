package com.vaia.crm.controller.form;

import org.apache.commons.lang.StringUtils;

/**
 * Created by nicholas.chi on 2018/4/25.
 */
public class UpdatePasswordForm {

    private String oldPassword;
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "UpdatePasswordForm{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    public boolean isEmpty(){
        if(StringUtils.isBlank(this.oldPassword)){
            return true;
        }
        if(StringUtils.isBlank(this.newPassword)){
            return true;
        }
        return false;
    }
}
