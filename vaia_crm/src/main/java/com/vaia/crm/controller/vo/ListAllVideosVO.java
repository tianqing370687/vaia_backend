package com.vaia.crm.controller.vo;

import com.vaia.entity.Video;

import java.util.List;

/**
 * Created by nicholas.chi on 2018/4/18.
 */
public class ListAllVideosVO extends BaseVO {

    private List<Video> list;

    public List<Video> getList() {
        return list;
    }

    public void setList(List<Video> list) {
        this.list = list;
    }
}
