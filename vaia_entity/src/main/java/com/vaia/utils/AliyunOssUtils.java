package com.vaia.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by nicholas.chi on 2018/4/12.
 */
@Component
@PropertySource("classpath:/dev/config.properties")
public class AliyunOssUtils {

    private OSS ossClient;

    @Value("${ali.endpoint}")
    private String endpoint;
    @Value("${ali.accesskey.id}")
    private String accessKeyId;
    @Value("${ali.accesskey.secret}")
    private String accessKeySecret;
    @Value("${ali.bucketname}")
    private String bucketName;

    private static Logger logger = LogManager.getLogger(AliyunOssUtils.class);

    @PostConstruct
    public void init(){
        this.ossClient =  new OSSClient(endpoint,accessKeyId,accessKeySecret);
    }

    public String uploadImg(MultipartFile file,String theme){
        String objUrl = "";
        if(file == null || file.getSize() <= 0){
            return objUrl;
        }
        boolean isSuccess;
        File targetFile;
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String fileName = (new Date().getTime())+"."+suffix.trim();
        logger.info("file Name is {} ",fileName);

        String key ="www/"+theme + "/"+ fileName;
        logger.info("the key is {}",key);

        try {
            targetFile = convert(file);
            isSuccess = uploadFile(key,targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("MultipartFile file convert fail : {}",e.getMessage());
            return objUrl;
        }

        if(isSuccess){
            objUrl = "http://vaia-www.oss-cn-shanghai.aliyuncs.com/"+key;
            logger.info("the path of file is : {}",objUrl);
            targetFile.delete();
            return objUrl;
        }
        return objUrl;
    }

    private boolean uploadFile(String key, File file){
        logger.info("Getting Started with OSS SDK for Java");
        if(!ossClient.doesBucketExist(bucketName)){
            logger.info("Creating bucket : {}",bucketName);
            ossClient.createBucket(bucketName);
            CreateBucketRequest createBucketRequest= new CreateBucketRequest(bucketName);
            createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
            ossClient.createBucket(createBucketRequest);
        }
        logger.info("Uploading a new object to OSS from a file");
        ossClient.putObject(new PutObjectRequest(bucketName, key, file));
        ossClient.setObjectAcl(bucketName, key, CannedAccessControlList.PublicRead);
        boolean exists = ossClient.doesObjectExist(bucketName, key);
        return exists;
    }

    private File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public OSS getOssClient() {
        return ossClient;
    }

    public void setOssClient(OSS ossClient) {
        this.ossClient = ossClient;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
