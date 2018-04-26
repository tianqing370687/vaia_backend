package com.vaia.crm.controller;

import com.vaia.constant.RetMessageEnum;
import com.vaia.constant.ServerConstant;
import com.vaia.crm.config.WebSecurityConfig;
import com.vaia.crm.controller.form.AddUserForm;
import com.vaia.crm.controller.form.LoginForm;
import com.vaia.crm.controller.form.UpdatePasswordForm;
import com.vaia.crm.controller.vo.BaseVO;
import com.vaia.crm.controller.vo.ListUserVO;
import com.vaia.crm.controller.vo.LoginVO;
import com.vaia.entity.UserInfo;
import com.vaia.service.UserInfoService;
import com.vaia.service.dto.LoginDTO;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by nicholas.chi on 2018/4/23.
 */
@RestController
@RequestMapping(value = "/crm")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    private Logger logger = LogManager.getLogger(UserController.class);

    @ApiOperation(value = "登录", notes = "")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public LoginVO login(HttpSession session, @RequestBody LoginForm form){
        LoginVO vo = new LoginVO();
        if(form.isEmpty()){
            vo.setRet(RetMessageEnum.PARAMETER_IS_EMPTY);
            return vo;
        }
        LoginDTO dto = userInfoService.login(form.getUserName(),form.getPassword());
        if(RetMessageEnum.SUCCESS == dto.getRetCode()){
            // 设置session
            session.setAttribute(WebSecurityConfig.SESSION_KEY, form.getUserName());
        }
        vo.setRet(dto.getRetCode());
        vo.setUserName(dto.getUserName());
        vo.setName(dto.getName());
        return vo;
    }

    @ApiOperation(value = "添加管理员", notes = "")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public BaseVO addUser(HttpSession session,@RequestBody AddUserForm form){
        BaseVO vo = new BaseVO();
        String sessionName = (String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
        logger.info("userName : {}",sessionName);
        if(!ServerConstant.SYSTEM_ADMINISTRATOR.equals(sessionName)){
            vo.setRet(RetMessageEnum.PERMISSION_DENIED);
            return vo;
        }
        RetMessageEnum ret = userInfoService.addUser(sessionName,form.getUserName(),form.getName(),form.getPassword());
        vo.setRet(ret);
        return vo;
    }

    @ApiOperation(value = "修改密码", notes = "")
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public BaseVO updatePassword(HttpSession session,@RequestBody UpdatePasswordForm form){
        BaseVO vo = new BaseVO();
        String sessionName = (String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
        RetMessageEnum ret = userInfoService.updatePassword(sessionName,form.getOldPassword(),form.getNewPassword());
        vo.setRet(ret);
        return vo;
    }

    @ApiOperation(value = "获取列表", notes = "")
    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    public ListUserVO listUser(){
        ListUserVO vo = new ListUserVO();
        List<UserInfo> list = userInfoService.listAllUserInfo();
        vo.setUserInfoList(list);
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }


    @ApiOperation(value = "退出登录", notes = "")
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public BaseVO logout(HttpSession session){
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        BaseVO vo = new BaseVO();
        vo.setRet(RetMessageEnum.SUCCESS);
        return vo;
    }
}
