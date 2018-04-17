package com.vaia.service.impl;

import com.vaia.entity.AllianceMembers;
import com.vaia.mapper.AllianceMembersMapper;
import com.vaia.service.AllianceMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ubuntu on 18-4-17.
 */
@Service
public class AllianceMembersServiceImpl implements AllianceMembersService {

    @Autowired
    AllianceMembersMapper allianceMembersMapper;

    @Override
    public void saveAllianceMembers(String memberName,String imgUrl,String companyLinks){
        AllianceMembers allianceMembers = new AllianceMembers();
        allianceMembers.setMemberName(memberName);
        allianceMembers.setImgUrl(imgUrl);
        allianceMembers.setCompanyLinks(companyLinks);
        allianceMembersMapper.insert(allianceMembers);
    }

    @Override
    public void deleteAllianceMembers(Integer memberId){
        allianceMembersMapper.deleteByPrimaryKey(memberId);
    }

    @Override
    public AllianceMembers getAllianceMembers(Integer memberId){
        AllianceMembers allianceMembers = allianceMembersMapper.selectByPrimaryKey(memberId);
        return allianceMembers;
    }

    @Override
    public List<AllianceMembers> listAllianceMembers(){
        List<AllianceMembers> list = allianceMembersMapper.listAllianceMembers();
        return list;
    }

}
