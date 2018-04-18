package com.vaia.crm.controller.vo;

import com.vaia.entity.Video;

import java.util.Date;

/**
 * Created by nicholas.chi on 2018/4/18.
 */
public class GetVideoVO extends BaseVO {

    private Integer videoId;

    private String videoName;

    private String videoUrl;

    private Date updateTime;

    private Integer uploaderId;

    public GetVideoVO() {
    }

    public GetVideoVO(Integer videoId, String videoName, String videoUrl, Date updateTime, Integer uploaderId) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.videoUrl = videoUrl;
        this.updateTime = updateTime;
        this.uploaderId = uploaderId;
    }

    public GetVideoVO(Video video) {
        this.videoId = video.getVideoId();
        this.videoName = video.getVideoName();
        this.videoUrl = video.getVideoUrl();
        this.updateTime = video.getUpdateTime();
        this.uploaderId = video.getUploaderId();
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Integer uploaderId) {
        this.uploaderId = uploaderId;
    }

}
