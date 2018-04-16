package com.vaia;

import com.github.pagehelper.Page;
import com.vaia.constant.RetMessageEnum;
import com.vaia.entity.ArticleConfiguration;

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


}