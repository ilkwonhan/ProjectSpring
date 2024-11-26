package com.champit.intra.SpringBoot.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.champit.intra.vo.User;

@Mapper
public interface TestDao {

    // @Select("select username from dba_users")
    public List<User> getTestNameString();
    public List<User> getNameStringByStatus(User user);
}
