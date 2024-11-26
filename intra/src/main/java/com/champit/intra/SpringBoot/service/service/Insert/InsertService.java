package com.champit.intra.SpringBoot.service.service.Insert;

import com.champit.intra.vo.Career;
import com.champit.intra.vo.Code;
import com.champit.intra.vo.Company;
import com.champit.intra.vo.Emp;


public interface InsertService {

    int insertEmp(Emp emp);
    int insertCompany(Company company);
    int insertCode(Code code);
    int insertCareer(Career career);
    

}
