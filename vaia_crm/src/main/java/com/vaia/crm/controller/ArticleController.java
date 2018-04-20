package com.vaia.crm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.vaia.crm.controller.form.*;
import com.vaia.crm.controller.vo.*;
import com.vaia.service.ArticleService;
import com.vaia.constant.RetMessageEnum;
import com.vaia.entity.ArticleConfiguration;
import com.vaia.entity.ArticleDetail;
import com.vaia.utils.AliyunOssUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nicholas.chi on 2018/4/16.
 */
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    AliyunOssUtils aliyunOssUtils;

    private Logger logger = LogManager.getLogger(ArticleController.class);

    @ApiOperation(value = "保存文章配置", notes = "")
    @RequestMapping(value = "/createArticleConfig",method = RequestMethod.POST,consumes = "multipart/form-data")
    public CreateArticleConfigVO createArticleConfig(CreateArticleConfigForm form){
        logger.info("method : {},param : {}",this.getClass().getSimpleName(),form.toString());
        CreateArticleConfigVO vo = new CreateArticleConfigVO();

        if(form.isEmpty()){
            vo.setRet(RetMessageEnum.PARAMETER_IS_EMPTY);
            return vo;
        }

        int userId = 1;

        String backgroundImgUrl = null;
        String thumbnailUrl = null;
        String mobBackgroundImgUrl = null;
        String mobThumbnailUrl = null;

        if(form.getBackgroundImg() != null && form.getBackgroundImg().getSize() > 0){
            backgroundImgUrl = aliyunOssUtils.uploadImg(form.getBackgroundImg());
        }
        if(form.getThumbnail() != null && form.getThumbnail().getSize() > 0){
            thumbnailUrl = aliyunOssUtils.uploadImg(form.getThumbnail());
        }
        if(form.getMobBackgroundImg() != null && form.getMobBackgroundImg().getSize() > 0){
            mobBackgroundImgUrl = aliyunOssUtils.uploadImg(form.getMobBackgroundImg());
        }
        if(form.getMobThumbnail() != null && form.getMobThumbnail().getSize() > 0){
            mobThumbnailUrl = aliyunOssUtils.uploadImg(form.getMobThumbnail());
        }

        int acId = articleService.saveArticleConfig(form.getMainTitle(),form.getSubtitle(),
                form.getArticleIntroduction(), backgroundImgUrl, thumbnailUrl,mobBackgroundImgUrl,
                mobThumbnailUrl,form.getTheme(), userId,form.getAuthor());

        vo.setAcId(acId);
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;

    }
    @ApiOperation(value = "根据ID获取文章配置", notes = "")
    @RequestMapping(value = "/getArticleConfig",method = RequestMethod.GET)
    public GetArticleConfigVO getArticleConfig(int acId){
        ArticleConfiguration configuration = articleService.getArticleConfig(acId);
        GetArticleConfigVO vo = new GetArticleConfigVO(configuration);
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }

    @ApiOperation(value = "删除文章配置", notes = "")
    @RequestMapping(value = "/deleteArticleConfig",method = RequestMethod.POST)
    public BaseVO deleteArticleConfig(int acId){
        BaseVO vo = new BaseVO();
        articleService.deleteArticleConfig(acId);
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }

    @ApiOperation(value = "更改文章发布状态", notes = "")
    @RequestMapping(value = "/updateConfigStatus",method = RequestMethod.POST)
    public BaseVO updateConfigStatus(@RequestBody UpdateConfigStatusForm form){
        logger.info("method : {},param : {}",this.getClass().getSimpleName(),form.toString());
        BaseVO vo = new BaseVO();
        RetMessageEnum retMessageEnum = articleService.updateConfigStatus(form.getAcId(),form.getStatus());
        vo.setRet(retMessageEnum);
        return vo;
    }

    @ApiOperation(value = "分页获取文章配置", notes = "")
    @RequestMapping(value = "/listArticleConfigByPage",method = RequestMethod.POST)
    public ListArticleConfigByPageVO listArticleConfigByPage(@RequestBody ListArticleConfigByPageForm form){
        logger.info("method : {},param : {}",this.getClass().getSimpleName(),form.toString());
        ListArticleConfigByPageVO vo = new ListArticleConfigByPageVO();
        Page<ArticleConfiguration> configurations = articleService.listArticleConfigByPage(form.getPageNo(),form.getPageSize());
        PageInfo<ArticleConfiguration> pageInfo = new PageInfo<>(configurations);
        vo.setRet(RetMessageEnum.SUCCESS);
        vo.setPageInfo(pageInfo);
        return vo;
    }

    @ApiOperation(value = "保存文章主体", notes = "")
    @RequestMapping(value = "/saveArticle",method = RequestMethod.POST)
    public BaseVO saveArticle(@RequestBody SaveArticleForm form){
        logger.info("method : {},param : {}",this.getClass().getSimpleName(),form.toString());
        BaseVO vo = new BaseVO();
        if(form.isEmpty()){
            vo.setRet(RetMessageEnum.PARAMETER_IS_EMPTY);
            return vo;
        }
        RetMessageEnum retMessageEnum = articleService.saveArticle(form.getAcId(),form.getArticleText());
        vo.setRet(retMessageEnum);
        return vo;
    }

    @ApiOperation(value = "获取文章详情", notes = "")
    @RequestMapping(value = "/getArticleDetails",method = RequestMethod.POST)
    public GetArticleDetailsVO getArticleDetails(@RequestBody GetArticleDetailsForm form){
        ArticleConfiguration configuration = articleService.getArticleById(form.getAcId());
        ArticleDetail detail = configuration.getArticleDetail();
        logger.info("details : {}",detail.toString());
        GetArticleDetailsVO vo = new GetArticleDetailsVO(configuration,detail);
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }

    @ApiOperation(value = "修改文章详情", notes = "")
    @RequestMapping(value = "/updateArticleConfig",method = RequestMethod.POST)
    public void updateArticleDetails(@RequestBody UpdateArticleDetailsForm form){

    }

}
