package com.vaia.crm.controller.form;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by nicholas.chi on 2018/4/16.
 */
public class CreateArticleConfigForm {

    private String mainTitle;
    private String subtitle;
    private String articleIntroduction;
    private MultipartFile backgroundImg;
    private MultipartFile thumbnail;
    private MultipartFile mobBackgroundImg;
    private MultipartFile mobThumbnail;
    private int theme;
    private String author;

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getArticleIntroduction() {
        return articleIntroduction;
    }

    public void setArticleIntroduction(String articleIntroduction) {
        this.articleIntroduction = articleIntroduction;
    }

    public MultipartFile getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(MultipartFile backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public MultipartFile getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(MultipartFile thumbnail) {
        this.thumbnail = thumbnail;
    }

    public MultipartFile getMobBackgroundImg() {
        return mobBackgroundImg;
    }

    public void setMobBackgroundImg(MultipartFile mobBackgroundImg) {
        this.mobBackgroundImg = mobBackgroundImg;
    }

    public MultipartFile getMobThumbnail() {
        return mobThumbnail;
    }

    public void setMobThumbnail(MultipartFile mobThumbnail) {
        this.mobThumbnail = mobThumbnail;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "CreateArticleConfigForm{" +
                "mainTitle='" + mainTitle + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", articleIntroduction='" + articleIntroduction + '\'' +
                ", backgroundImg=" + backgroundImg +
                ", thumbnail=" + thumbnail +
                ", mobBackgroundImg=" + mobBackgroundImg +
                ", mobThumbnail=" + mobThumbnail +
                ", theme=" + theme +
                ", author='" + author + '\'' +
                '}';
    }

    public boolean isEmpty(){

        if(StringUtils.isBlank(this.mainTitle)){
            return true;
        }
        return false;
    }
}
