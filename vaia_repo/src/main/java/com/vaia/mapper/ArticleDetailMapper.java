package com.vaia.mapper;

import com.vaia.entity.ArticleDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("articleDetailMapper")
public interface ArticleDetailMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(ArticleDetail record);

    int insertSelective(ArticleDetail record);

    ArticleDetail selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(ArticleDetail record);

    int updateByPrimaryKeyWithBLOBs(ArticleDetail record);
}