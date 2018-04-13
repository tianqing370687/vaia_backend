package com.vaia.entity;

import com.vaia.entity.TestEntity;

public interface TestEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestEntity record);

    int insertSelective(TestEntity record);

    TestEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestEntity record);

    int updateByPrimaryKey(TestEntity record);
}