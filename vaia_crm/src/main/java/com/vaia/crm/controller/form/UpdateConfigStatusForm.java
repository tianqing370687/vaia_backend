package com.vaia.crm.controller.form;

/**
 * Created by nicholas.chi on 2018/4/16.
 */
public class UpdateConfigStatusForm {

    private int acId;
    private int status;

    public int getAcId() {
        return acId;
    }

    public void setAcId(int acId) {
        this.acId = acId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpdateConfigStatusForm{" +
                "acId=" + acId +
                ", status=" + status +
                '}';
    }
}
