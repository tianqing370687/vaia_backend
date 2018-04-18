package com.vaia.mapper;

import com.vaia.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("videoMapper")
public interface VideoMapper {
    int deleteByPrimaryKey(Integer videoId);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer videoId);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    List<Video> listAllVideos();
}