package com.vaia.entity;

import java.util.Date;

public class ArticleConfiguration {
    private Integer acId;

    private String mainTitle;

    private String subtitle;

    private String articleIntroduction;

    private String backgroundImgUrl;

    private String thumbnailUrl;

    private String mobBackgroundImgUrl;

    private String mobThumbnailUrl;

    private Date createTime;

    private Date releaseTime;

    private Integer theme;

    private Integer status;

    private Integer userId;

    private String author;

    private ArticleDetail articleDetail;

    public ArticleConfiguration() {
    }

    public ArticleConfiguration(Integer acId, String mainTitle, String subtitle, String articleIntroduction,
                                String backgroundImgUrl, String thumbnailUrl, String mobBackgroundImgUrl,
                                String mobThumbnailUrl, Date createTime, Date releaseTime, Integer theme,
                                Integer status, Integer userId, String author,ArticleDetail articleDetail) {
        this.acId = acId;
        this.mainTitle = mainTitle;
        this.subtitle = subtitle;
        this.articleIntroduction = articleIntroduction;
        this.backgroundImgUrl = backgroundImgUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.mobBackgroundImgUrl = mobBackgroundImgUrl;
        this.mobThumbnailUrl = mobThumbnailUrl;
        this.createTime = createTime;
        this.releaseTime = releaseTime;
        this.theme = theme;
        this.status = status;
        this.userId = userId;
        this.author = author;
        this.articleDetail = articleDetail;
    }

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle == null ? null : mainTitle.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getArticleIntroduction() {
        return articleIntroduction;
    }

    public void setArticleIntroduction(String articleIntroduction) {
        this.articleIntroduction = articleIntroduction == null ? null : articleIntroduction.trim();
    }

    public String getBackgroundImgUrl() {
        return backgroundImgUrl;
    }

    public void setBackgroundImgUrl(String backgroundImgUrl) {
        this.backgroundImgUrl = backgroundImgUrl == null ? null : backgroundImgUrl.trim();
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl == null ? null : thumbnailUrl.trim();
    }

    public String getMobBackgroundImgUrl() {
        return mobBackgroundImgUrl;
    }

    public void setMobBackgroundImgUrl(String mobBackgroundImgUrl) {
        this.mobBackgroundImgUrl = mobBackgroundImgUrl == null ? null : mobBackgroundImgUrl.trim();
    }

    public String getMobThumbnailUrl() {
        return mobThumbnailUrl;
    }

    public void setMobThumbnailUrl(String mobThumbnailUrl) {
        this.mobThumbnailUrl = mobThumbnailUrl == null ? null : mobThumbnailUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getTheme() {
        return theme;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public ArticleDetail getArticleDetail() {
        return articleDetail;
    }

    public void setArticleDetail(ArticleDetail articleDetail) {
        this.articleDetail = articleDetail;
    }
}