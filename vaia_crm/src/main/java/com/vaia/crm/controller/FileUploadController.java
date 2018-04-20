package com.vaia.crm.controller;

import com.vaia.crm.controller.vo.FileUploadVO;
import com.vaia.entity.TestEntity;
import com.vaia.mapper.TestEntityMapper;
import com.vaia.utils.AliyunOssUtils;
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

    @RequestMapping(value = "/imgUpload",method = RequestMethod.POST)
    public FileUploadVO imgUpload(@RequestParam("img") MultipartFile img){

        FileUploadVO vo = new FileUploadVO();
        String url = utils.uploadImg(img);
        logger.info("the url of img is : {}",url);

        String[] data = {url};
        vo.setErrno(0);
        vo.setData(data);

        return vo;
    }
}
