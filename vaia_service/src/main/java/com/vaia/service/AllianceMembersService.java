package com.vaia.service;

import com.vaia.entity.AllianceMembers;

import java.util.List;

/**
 * Created by ubuntu on 18-4-17.
 */
public interface AllianceMembersService {

    void saveAllianceMembers(String memberName,String imgUrl,String companyLinks);

    void deleteAllianceMembers(Integer memberId);

    AllianceMembers getAllianceMembers(Integer memberId);

    List<AllianceMembers> listAllianceMembers();
}
