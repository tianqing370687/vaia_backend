package com.vaia.crm.controller;

import com.vaia.crm.ao.FileUploadAO;
import com.vaia.entity.TestEntity;
import com.vaia.mapper.TestEntityMapper;
import com.vaia.utils.AliyunOssUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @ResponseBody
    @RequestMapping(value = "/imgUpload",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public FileUploadAO imgUpload(@RequestParam("img") MultipartFile img){

        FileUploadAO ao = new FileUploadAO();
        String url = utils.uploadImg(img);
        logger.info("the url of img is : {}",url);

        String[] data = {url};
        ao.setErrno(0);
        ao.setData(data);

        return ao;
    }
    @RequestMapping(value = "/listTest",method = RequestMethod.GET)
    public String listTest(){
        TestEntity entity = testEntityMapper.selectByPrimaryKey(1);
        logger.info("entity : {}",entity.toString());
        return "success";
    }



}
