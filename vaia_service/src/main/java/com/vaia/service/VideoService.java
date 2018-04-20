package com.vaia.service;

import com.vaia.entity.Video;

import java.util.List;

/**
 * Created by nicholas.chi on 2018/4/18.
 */
public interface VideoService {

    void saveVideo(String videoName,String videoUrl,Integer uploaderId);

    void deleteVideo(int videoId);

    Video getVideo(int videoId);

    List<Video> listVideos();

    int updateStatusBatch();

    int homeDisplay(int videoId);

    Video getVideByStatus(Integer showStatus);

}
