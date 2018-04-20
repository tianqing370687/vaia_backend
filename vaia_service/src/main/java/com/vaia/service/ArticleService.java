package com.vaia.service;

import com.github.pagehelper.Page;
import com.vaia.constant.RetMessageEnum;
import com.vaia.entity.ArticleConfiguration;

import java.util.List;

/**
 * Created by nicholas.chi on 2018/4/16.
 */
public interface ArticleService {

    int saveArticleConfig(String mainTitle,String subtitle,String articleIntroduction,String backgroundImgUrl,
                                 String thumbnailUrl,String mobBackgroundImgUrl,String mobThumbnailUrl,
                                 Integer theme,Integer userId,String author);

    ArticleConfiguration getArticleConfig(int acId);

    int deleteArticleConfig(int acId);

    RetMessageEnum updateConfigStatus(int acId, int status);

    Page<ArticleConfiguration> listArticleConfigByPage(int pageNo, int pageSize);

    RetMessageEnum saveArticle(int acId,String articleText);

    ArticleConfiguration getArticleById(int acId);

    Page<ArticleConfiguration> getArticleByPage(int pageNo, int pageSize,int status, String time, int theme);

    List<ArticleConfiguration> getArticleByParam(int status, String time, int theme);

}
