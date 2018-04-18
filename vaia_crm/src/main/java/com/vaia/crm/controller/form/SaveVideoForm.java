package com.vaia.crm.controller.form;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by nicholas.chi on 2018/4/18.
 */
public class SaveVideoForm {

    private String videoName;
    private MultipartFile video;

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public MultipartFile getVideo() {
        return video;
    }

    public void setVideo(MultipartFile video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "SaveVideoForm{" +
                "videoName='" + videoName + '\'' +
                ", video=" + video +
                '}';
    }

    public boolean isEmpty(){
        if(StringUtils.isBlank(videoName)){
            return true;
        }
        return false;
    }
}
