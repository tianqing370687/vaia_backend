package com.vaia.crm.controller;

import com.vaia.constant.RetMessageEnum;
import com.vaia.crm.controller.form.DeleteAllianceMembersForm;
import com.vaia.crm.controller.form.GetAllianceMembersForm;
import com.vaia.crm.controller.form.SaveAllianceMembersForm;
import com.vaia.crm.controller.vo.BaseVO;
import com.vaia.crm.controller.vo.GetAllianceMembersVO;
import com.vaia.crm.controller.vo.ListAllianceMembersVO;
import com.vaia.entity.AllianceMembers;
import com.vaia.service.AllianceMembersService;
import com.vaia.utils.AliyunOssUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ubuntu on 18-4-17.
 */
@RestController
public class AllianceMembersController {

    @Autowired
    AliyunOssUtils utils;
    @Autowired
    AllianceMembersService allianceMembersService;

    @ApiOperation(value = "保存", notes = "")
    @RequestMapping(value = "/saveAllianceMembers",method = RequestMethod.POST,consumes = "multipart/form-data")
    public BaseVO saveAllianceMembers(SaveAllianceMembersForm form){
        BaseVO vo = new BaseVO();
        if(form.isEmpty()){
            vo.setRet(RetMessageEnum.PARAMETER_IS_EMPTY);
            return vo;
        }
        String imgUrl =utils.uploadImg(form.getImg());
        if(StringUtils.isBlank(imgUrl)){
            vo.setRet(RetMessageEnum.FAILUE);
            return vo;
        }

        allianceMembersService.saveAllianceMembers(form.getMemberName()
                ,imgUrl,form.getCompanyLinks());
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }

    @ApiOperation(value = "删除", notes = "")
    @RequestMapping(value = "/deleteAllianceMembers",method = RequestMethod.POST)
    public BaseVO deleteAllianceMembers(@RequestBody DeleteAllianceMembersForm form){
        BaseVO vo = new BaseVO();
        allianceMembersService.deleteAllianceMembers(form.getMemberId());
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }

    @ApiOperation(value = "获取", notes = "")
    @RequestMapping(value = "/getAllianceMembers",method = RequestMethod.POST)
    public GetAllianceMembersVO getAllianceMembers(@RequestBody GetAllianceMembersForm form){
        AllianceMembers allianceMembers = allianceMembersService.getAllianceMembers(form.getMemberId());
        if(allianceMembers == null){
            GetAllianceMembersVO vo = new GetAllianceMembersVO();
            vo.setRet(RetMessageEnum.CAN_NOT_FIND_OBJECT);
            return vo;
        }
        GetAllianceMembersVO vo = new GetAllianceMembersVO(allianceMembers);
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }

    @ApiOperation(value = "获取列表", notes = "")
    @RequestMapping(value = "/listAllianceMembers",method = RequestMethod.GET)
    public ListAllianceMembersVO listAllianceMembers(){
        ListAllianceMembersVO vo = new ListAllianceMembersVO();
        List<AllianceMembers> list = allianceMembersService.listAllianceMembers();
        vo.setList(list);
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }

}
