package com.vaia.crm.controller.vo;

import com.vaia.entity.ArticleConfiguration;
import com.vaia.entity.ArticleDetail;

import java.util.Date;

/**
 * Created by nicholas.chi on 2018/4/19.
 */
public class GetArticleDetailsVO extends BaseVO{

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

    private String article;

    public GetArticleDetailsVO() {
    }

    public GetArticleDetailsVO(ArticleConfiguration configuration,ArticleDetail detail) {
        this.acId = configuration.getAcId();
        this.mainTitle = configuration.getMainTitle();
        this.subtitle = configuration.getSubtitle();
        this.articleIntroduction = configuration.getArticleIntroduction();
        this.backgroundImgUrl = configuration.getBackgroundImgUrl();
        this.thumbnailUrl = configuration.getThumbnailUrl();
        this.mobBackgroundImgUrl = configuration.getMobBackgroundImgUrl();
        this.mobThumbnailUrl = configuration.getMobThumbnailUrl();
        this.createTime = configuration.getCreateTime();
        this.releaseTime = configuration.getReleaseTime();
        this.theme = configuration.getTheme();
        this.status = configuration.getStatus();
        this.userId = configuration.getUserId();
        this.author = configuration.getAuthor();
        this.article = detail.getArticle();
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

    public String getBackgroundImgUrl() {
        return backgroundImgUrl;
    }

    public void setBackgroundImgUrl(String backgroundImgUrl) {
        this.backgroundImgUrl = backgroundImgUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getMobBackgroundImgUrl() {
        return mobBackgroundImgUrl;
    }

    public void setMobBackgroundImgUrl(String mobBackgroundImgUrl) {
        this.mobBackgroundImgUrl = mobBackgroundImgUrl;
    }

    public String getMobThumbnailUrl() {
        return mobThumbnailUrl;
    }

    public void setMobThumbnailUrl(String mobThumbnailUrl) {
        this.mobThumbnailUrl = mobThumbnailUrl;
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
        this.author = author;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
