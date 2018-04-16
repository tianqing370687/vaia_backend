package com.vaia.crm.controller;

import com.vaia.entity.TestEntity;
import com.vaia.mapper.TestEntityMapper;
import com.vaia.utils.AliyunOssUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by nicholas.chi on 2018/4/12.
 */
@RestController
public class FileUploadController {

    private Logger logger = LogManager.getLogger(FileUploadController.class);

    @Autowired
    AliyunOssUtils utils;

    @Autowired
    TestEntityMapper testEntityMapper;

    @ApiOperation(value = "上传文件", notes = "")
    @RequestMapping(value = "/imgUpload",method = RequestMethod.POST)
    public String imgUpload(@RequestParam("img") MultipartFile img){
        String url = utils.uploadImg(img);
        logger.info("the url of img is : {}",url);
        return url;
    }
    @RequestMapping(value = "/listTest",method = RequestMethod.GET)
    public String listTest(){
        TestEntity entity = testEntityMapper.selectByPrimaryKey(1);
        logger.info("entity : {}",entity.toString());
        return "success";
    }



}
