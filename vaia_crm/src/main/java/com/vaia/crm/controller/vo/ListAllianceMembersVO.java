package com.vaia.crm.controller.vo;

import com.vaia.entity.AllianceMembers;

import java.util.List;

/**
 * Created by ubuntu on 18-4-17.
 */
public class ListAllianceMembersVO extends BaseVO {

    private List<AllianceMembers> list;

    public List<AllianceMembers> getList() {
        return list;
    }

    public void setList(List<AllianceMembers> list) {
        this.list = list;
    }
}
