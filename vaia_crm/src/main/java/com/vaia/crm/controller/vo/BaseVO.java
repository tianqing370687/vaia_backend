package com.vaia.crm.controller.vo;

import com.vaia.constant.RetMessageEnum;

/**
 * Created by nicholas.chi on 2018/4/16.
 */
public class BaseVO {

    private String apiName;
    private String retStatus = "failure";
    private String retCode;
    private String message;
    private String[] opts;// 提示信息动态参数

    public BaseVO() {
        super();
        String name = this.getClass().getSimpleName();
        name = name.substring(0, name.indexOf("VO"));
        name = name.substring(0, 1).toLowerCase() + name.substring(1);
        apiName = name;
    }

    public String getRetCode() {
        return retCode;
    }

    public String getMessage() {
        return message;
    }

    public String getApiName() {
        return apiName;
    }

    public String[] getOpts() {
        return opts;
    }

    public void setOpts(String[] opts) {
        this.opts = opts;
    }

    public String getRetStatus() {
        return retStatus;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public void setRet(RetMessageEnum retMessageEnum) {
        this.retCode = retMessageEnum.getCode();
        this.message = retMessageEnum.getMessage();
        this.retStatus = retMessageEnum.getStatus();
    }

    public void setRet(RetMessageEnum retMessageEnum, String otherMessageInfo) {
        this.retCode = retMessageEnum.getCode();
        this.message = retMessageEnum.getMessage() + " : " + otherMessageInfo;
        this.retStatus = retMessageEnum.getStatus();
    }
}
