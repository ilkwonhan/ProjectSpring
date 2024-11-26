package com.champit.intra.SpringBoot.service.dao.Insert;

import org.apache.ibatis.annotations.Mapper;

import com.champit.intra.vo.Career;
import com.champit.intra.vo.Code;
import com.champit.intra.vo.Company;
import com.champit.intra.vo.Emp;


@Mapper
public interface InsertDao {
    public int insertEmp(Emp emp);
    public int insertCompany(Company company);
    public int insertCode(Code code);
    public int insertCareer(Career career);
}
