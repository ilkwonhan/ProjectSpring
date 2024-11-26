package com.champit.intra.SpringBoot.batch.Discord.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiscordDao {

    // @Select("select username from dba_users")
    public int vacationCount();
    
}
