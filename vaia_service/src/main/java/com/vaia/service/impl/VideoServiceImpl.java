package com.vaia.service.impl;

import com.vaia.constant.ServerConstant;
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
        video.setShowStatus(ServerConstant.HOME_DISPLAY_NO);
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

    @Override
    public int updateStatusBatch(){
        return videoMapper.updateStatusBatch();
    }

    @Override
    public int homeDisplay(int videoId){
        Video video = videoMapper.selectByPrimaryKey(videoId);
        video.setShowStatus(ServerConstant.HOME_DISPLAY_YES);
        int i = videoMapper.updateByPrimaryKey(video);
        return i;
    }

    @Override
    public Video getVideByStatus(Integer showStatus) {
        return videoMapper.getVideByStatus(showStatus);
    }

}
