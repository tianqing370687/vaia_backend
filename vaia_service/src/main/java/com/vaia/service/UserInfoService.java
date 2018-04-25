package com.vaia.service;

import com.vaia.constant.RetMessageEnum;
import com.vaia.entity.UserInfo;
import com.vaia.service.dto.LoginDTO;

import java.util.List;

/**
 * Created by nicholas.chi on 2018/4/23.
 */
public interface UserInfoService {

    LoginDTO login(String userName, String password);

    RetMessageEnum addUser(String adminName,String userName,String name,String password);

    int getUserIdByUserName(String userName);

    List<UserInfo> listAllUserInfo();

    RetMessageEnum updatePassword(String userName,String oldPassword,String newPassword);

}
