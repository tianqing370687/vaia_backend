package com.vaia.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vaia.constant.RetMessageEnum;
import com.vaia.constant.ServerConstant;
import com.vaia.entity.ArticleConfiguration;
import com.vaia.entity.ArticleDetail;
import com.vaia.mapper.ArticleConfigurationMapper;
import com.vaia.mapper.ArticleDetailMapper;
import com.vaia.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ubuntu on 18-4-17.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDetailMapper articleDetailMapper;
    @Autowired
    ArticleConfigurationMapper articleConfigurationMapper;

    @Override
    public int saveArticleConfig(String mainTitle,String subtitle,String articleIntroduction,String backgroundImgUrl,
                                 String thumbnailUrl,String mobBackgroundImgUrl,String mobThumbnailUrl,Integer theme,
                                 Integer userId, String author){

        ArticleConfiguration configuration = new ArticleConfiguration();
        configuration.setMainTitle(mainTitle);
        configuration.setSubtitle(subtitle);
        configuration.setArticleIntroduction(articleIntroduction);
        configuration.setBackgroundImgUrl(backgroundImgUrl);
        configuration.setThumbnailUrl(thumbnailUrl);
        configuration.setMobBackgroundImgUrl(mobBackgroundImgUrl);
        configuration.setMobThumbnailUrl(mobThumbnailUrl);
        configuration.setTheme(theme);
        configuration.setUserId(userId);
        configuration.setAuthor(author);

        configuration.setCreateTime(new Date());
        configuration.setReleaseTime(new Date());
        configuration.setStatus(ServerConstant.ARTICLE_STATUS_UNPUBLISHED);

        articleConfigurationMapper.insert(configuration);
        return configuration.getAcId();
    }

    @Override
    public ArticleConfiguration getArticleConfig(int acId) {
        return articleConfigurationMapper.selectByPrimaryKey(acId);
    }

    @Override
    public int deleteArticleConfig(int acId){
        return articleConfigurationMapper.deleteByPrimaryKey(acId);
    }

    @Override
    public RetMessageEnum updateConfigStatus(int acId, int status){
        ArticleConfiguration configuration = articleConfigurationMapper.selectByPrimaryKey(acId);
        if(configuration == null){
            return RetMessageEnum.CAN_NOT_FIND_OBJECT;
        }
        configuration.setStatus(status);
        articleConfigurationMapper.updateByPrimaryKey(configuration);
        return RetMessageEnum.SUCCESS;
    }

    @Override
    public Page<ArticleConfiguration> listArticleConfigByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return articleConfigurationMapper.findByPage();
    }

    @Override
    public RetMessageEnum saveArticle(int acId, String articleText) {
        ArticleConfiguration configuration = articleConfigurationMapper.selectByPrimaryKey(acId);
        if(configuration == null){
            return RetMessageEnum.CAN_NOT_FIND_OBJECT;
        }
        ArticleDetail detail = new ArticleDetail();
        detail.setArticleId(acId);
        detail.setArticle(articleText);
        articleDetailMapper.insert(detail);
        return RetMessageEnum.SUCCESS;
    }

    @Override
    public ArticleConfiguration getArticleById(int acId){
        ArticleConfiguration configuration = articleConfigurationMapper.getArticleById(acId);
        return configuration;
    }

    @Override
    public Page<ArticleConfiguration> getArticleByPage(int pageNo, int pageSize,int status, String time, int theme){
        PageHelper.startPage(pageNo,pageSize);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status",status);
        params.put("time",time);
        params.put("theme",theme);
        return articleConfigurationMapper.getArticleByParam(params);
    }

    @Override
    public List<ArticleConfiguration> getArticleByParam(int status, String time, int theme){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status",status);
        params.put("time",time);
        params.put("theme",theme);
        List<ArticleConfiguration> list = articleConfigurationMapper.getArticleByParam(params);
        return list;
    }

    @Override
    public List<String> getYears(int theme) {
        return articleConfigurationMapper.getYears(theme);
    }

}
