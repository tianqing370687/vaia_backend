package com.vaia.service.impl;

import com.vaia.constant.RetMessageEnum;
import com.vaia.entity.UserInfo;
import com.vaia.mapper.UserInfoMapper;
import com.vaia.service.UserInfoService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nicholas.chi on 2018/4/23.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    private Logger logger = LogManager.getLogger(UserInfoServiceImpl.class);

    @Override
    public RetMessageEnum login(String userName,String password){
        UserInfo userInfo = userInfoMapper.getUserInfoByUserName(userName);
        if(userInfo == null){
            return RetMessageEnum.CAN_NOT_FIND_OBJECT;
        }
        String str = DigestUtils.md5Hex(DigestUtils.md5Hex(password) + userInfo.getSalt());
        if(str.equals(userInfo.getPassword())){
            return RetMessageEnum.SUCCESS;
        }
        return RetMessageEnum.FAILUE;
    }

    @Override
    public RetMessageEnum addUser(String adminName, String userName, String name, String password) {
        UserInfo userInfo = userInfoMapper.getUserInfoByUserName(userName);
        if(userInfo != null){
            return RetMessageEnum.USERNAME_ALREADY_EXISTS;
        }
        userInfo.setUserName(userName);
        userInfo.setName(name);

        String salt = "vaiacrm";
        String pw = DigestUtils.md5Hex(DigestUtils.md5Hex(password) + salt);
        logger.info("salt : {},password : {}",salt,pw);

        userInfo.setPassword(pw);
        userInfo.setSalt(salt);
        userInfo.setState(1);

        int i = userInfoMapper.insert(userInfo);
        if(i <= 0){
            return RetMessageEnum.FAILUE;
        }

        return RetMessageEnum.SUCCESS;
    }

    @Override
    public int getUserIdByUserName(String userName) {
        UserInfo user = userInfoMapper.getUserInfoByUserName(userName);
        if(user == null){
            return 0;
        }
        return user.getUserId();
    }

    @Override
    public List<UserInfo> listAllUserInfo() {
        return userInfoMapper.listAllUserInfo();
    }

}
