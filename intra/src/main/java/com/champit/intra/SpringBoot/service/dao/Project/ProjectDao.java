package com.champit.intra.SpringBoot.service.dao.Project;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.champit.intra.vo.Project;

@Mapper
public interface ProjectDao {

    public List<Project> getProjectList();

}
