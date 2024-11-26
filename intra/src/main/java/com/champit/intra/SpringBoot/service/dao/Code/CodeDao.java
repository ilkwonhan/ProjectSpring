package com.champit.intra.SpringBoot.service.dao.Code;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.champit.intra.vo.Code;

@Mapper
public interface CodeDao {

    public List<Code> getCodeList();
}
