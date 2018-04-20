package com.vaia.crm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.vaia.constant.ServerConstant;
import com.vaia.crm.controller.form.HomeForm;
import com.vaia.crm.controller.form.ListArticleByPageForm;
import com.vaia.crm.controller.vo.BaseVO;
import com.vaia.crm.controller.vo.HomeVO;
import com.vaia.crm.controller.vo.ListArticleByPageVO;
import com.vaia.entity.ArticleConfiguration;
import com.vaia.entity.Video;
import com.vaia.mapper.ArticleDetailMapper;
import com.vaia.mapper.VideoMapper;
import com.vaia.service.ArticleService;
import com.vaia.service.VideoService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nicholas.chi on 2018/4/20.
 */
@RestController
public class OfficialController {

    @Autowired
    VideoService videoService;
    @Autowired
    ArticleService articleService;

    private Logger logger = LogManager.getLogger(OfficialController.class);

    @ApiOperation(value = "首页", notes = "")
    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public HomeVO home(@RequestBody HomeForm form){
        HomeVO vo = new HomeVO();

        Video video = videoService.getVideByStatus(ServerConstant.HOME_DISPLAY_YES);
        List<ArticleConfiguration> news = articleService.getArticleByParam(ServerConstant.ARTICLE_STATUS_RELEASE,
                null,form.getNews());
        Page<ArticleConfiguration> configurations = articleService.getArticleByPage(1,6,
                ServerConstant.ARTICLE_STATUS_RELEASE,null,form.getProduct());
        PageInfo<ArticleConfiguration> pageInfo = new PageInfo<>(configurations);
        if(news != null && !news.isEmpty()){
            vo.setNews(news.get(0));
        }
        vo.setVideo(video);
        vo.setPageInfo(pageInfo);
        return vo;
    }

    @ApiOperation(value = "", notes = "")
    @RequestMapping(value = "/listArticleByPage",method = RequestMethod.POST)
    public ListArticleByPageVO listArticleByPage(@RequestBody ListArticleByPageForm form){
        ListArticleByPageVO vo = new ListArticleByPageVO();
        Page<ArticleConfiguration> configurations = articleService.getArticleByPage(form.getPageNo(),form.getPageSize(),
                form.getStatus(),form.getTime(),form.getTheme());
        PageInfo<ArticleConfiguration> pageInfo = new PageInfo<>(configurations);
        vo.setPageInfo(pageInfo);
        return vo;
    }

}
