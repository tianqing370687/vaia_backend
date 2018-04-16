package com.vaia.crm.controller.vo;

import com.github.pagehelper.PageInfo;
import com.vaia.entity.ArticleConfiguration;

/**
 * Created by nicholas.chi on 2018/4/16.
 */
public class ListArticleConfigByPageVO extends BaseVO {

    private PageInfo<ArticleConfiguration> pageInfo;

    public PageInfo<ArticleConfiguration> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<ArticleConfiguration> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
