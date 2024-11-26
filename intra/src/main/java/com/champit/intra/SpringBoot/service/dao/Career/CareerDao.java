package com.champit.intra.SpringBoot.service.dao.Career;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.champit.intra.vo.Career;
import com.champit.intra.vo.Project;

@Mapper
public interface CareerDao {

    public List<Project> getProjectList();
    public int updateCareer(Career career);
}
