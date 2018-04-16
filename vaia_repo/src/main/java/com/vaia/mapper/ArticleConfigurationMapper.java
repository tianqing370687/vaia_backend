package com.vaia.mapper;

import com.github.pagehelper.Page;
import com.vaia.entity.ArticleConfiguration;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("articleConfigurationMapper")
public interface ArticleConfigurationMapper {
    int deleteByPrimaryKey(Integer acId);

    int insert(ArticleConfiguration record);

    int insertSelective(ArticleConfiguration record);

    ArticleConfiguration selectByPrimaryKey(Integer acId);

    int updateByPrimaryKeySelective(ArticleConfiguration record);

    int updateByPrimaryKey(ArticleConfiguration record);

    Page<ArticleConfiguration> findByPage();
}