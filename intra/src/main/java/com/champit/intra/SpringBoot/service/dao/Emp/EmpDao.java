package com.champit.intra.SpringBoot.service.dao.Emp;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.champit.intra.vo.Emp;

@Mapper
public interface EmpDao {

    public List<Emp> getEmpList();
    public List<Emp> getMaxEmpNo();
    public Emp getEmpInfo(String empNo);
    public int updateEmp(Emp emp);
}
