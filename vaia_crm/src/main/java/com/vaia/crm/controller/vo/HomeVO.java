package com.vaia.crm.controller.vo;

import com.github.pagehelper.PageInfo;
import com.vaia.entity.ArticleConfiguration;
import com.vaia.entity.Video;

/**
 * Created by nicholas.chi on 2018/4/20.
 */
public class HomeVO extends BaseVO{

    private Video video;
    private ArticleConfiguration news;
    private PageInfo<ArticleConfiguration> pageInfo;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public ArticleConfiguration getNews() {
        return news;
    }

    public void setNews(ArticleConfiguration news) {
        this.news = news;
    }

    public PageInfo<ArticleConfiguration> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<ArticleConfiguration> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
