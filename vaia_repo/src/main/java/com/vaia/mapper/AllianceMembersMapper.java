package com.vaia.mapper;

import com.vaia.entity.AllianceMembers;

public interface AllianceMembersMapper {
    int deleteByPrimaryKey(Integer memberId);

    int insert(AllianceMembers record);

    int insertSelective(AllianceMembers record);

    AllianceMembers selectByPrimaryKey(Integer memberId);

    int updateByPrimaryKeySelective(AllianceMembers record);

    int updateByPrimaryKey(AllianceMembers record);
}