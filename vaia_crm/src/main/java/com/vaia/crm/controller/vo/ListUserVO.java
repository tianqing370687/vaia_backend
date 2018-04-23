package com.vaia.crm.controller.vo;

import com.vaia.entity.UserInfo;

import java.util.List;

/**
 * Created by nicholas.chi on 2018/4/23.
 */
public class ListUserVO extends BaseVO {
    private List<UserInfo> userInfoList;

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
