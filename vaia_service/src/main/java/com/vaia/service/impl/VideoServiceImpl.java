package com.vaia.service.impl;

import com.vaia.entity.Video;
import com.vaia.mapper.VideoMapper;
import com.vaia.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by nicholas.chi on 2018/4/18.
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;

    @Override
    public void saveVideo(String videoName,String videoUrl,Integer uploaderId){
        Video video = new Video();
        video.setVideoName(videoName);
        video.setVideoUrl(videoUrl);
        video.setUpdateTime(new Date());
        video.setUploaderId(uploaderId);
        videoMapper.insert(video);
    }

    @Override
    public void deleteVideo(int videoId){
        videoMapper.deleteByPrimaryKey(videoId);
    }

    @Override
    public Video getVideo(int videoId){
        return videoMapper.selectByPrimaryKey(videoId);
    }

    @Override
    public List<Video> listVideos(){
        List<Video> list = videoMapper.listAllVideos();
        return list;
    }

}
