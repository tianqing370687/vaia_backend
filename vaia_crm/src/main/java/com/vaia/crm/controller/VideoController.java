package com.vaia.crm.controller;

import com.vaia.constant.RetMessageEnum;
import com.vaia.crm.controller.form.DeleteVideoForm;
import com.vaia.crm.controller.form.GetVideoForm;
import com.vaia.crm.controller.form.SaveVideoForm;
import com.vaia.crm.controller.vo.BaseVO;
import com.vaia.crm.controller.vo.GetVideoVO;
import com.vaia.crm.controller.vo.ListAllVideosVO;
import com.vaia.entity.Video;
import com.vaia.service.VideoService;
import com.vaia.utils.AliyunOssUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nicholas.chi on 2018/4/18.
 */
@RestController
public class VideoController {

    @Autowired
    AliyunOssUtils utils;
    @Autowired
    VideoService videoService;

    @ApiOperation(value = "保存视频", notes = "")
    @RequestMapping(value = "/saveVideo",method = RequestMethod.POST,consumes = "multipart/form-data")
    public BaseVO saveVideo(@RequestParam("video") SaveVideoForm form){
        BaseVO vo = new BaseVO();
        int userId = 0;
        if(form.isEmpty()){
            vo.setRet(RetMessageEnum.PARAMETER_IS_EMPTY);
            return vo;
        }
        String videoUrl = utils.uploadImg(form.getVideo());
        if(StringUtils.isBlank(videoUrl)){
            vo.setRet(RetMessageEnum.FAILUE);
            return vo;
        }
        videoService.saveVideo(form.getVideoName(),videoUrl,userId);
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }

    @ApiOperation(value = "删除", notes = "")
    @RequestMapping(value = "/deleteVideo",method = RequestMethod.POST)
    public BaseVO deleteVideo(@RequestBody DeleteVideoForm form){
        BaseVO vo = new BaseVO();
        videoService.deleteVideo(form.getVideoId());
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }

    @ApiOperation(value = "获取", notes = "")
    @RequestMapping(value = "/getVideo",method = RequestMethod.POST)
    public GetVideoVO getVideo(@RequestBody GetVideoForm form){
        GetVideoVO vo = null;
        Video video = videoService.getVideo(form.getVideoId());
        if(video == null){
            vo.setRet(RetMessageEnum.CAN_NOT_FIND_OBJECT);
            return vo;
        }
        vo = new GetVideoVO(video);
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }

    @ApiOperation(value = "获取列表", notes = "")
    @RequestMapping(value = "/listAllVideos",method = RequestMethod.POST)
    public ListAllVideosVO listAllVideos(){
        ListAllVideosVO vo = new ListAllVideosVO();
        List<Video> list = videoService.listVideos();
        vo.setList(list);
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }


}
