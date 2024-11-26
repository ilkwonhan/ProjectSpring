package com.champit.intra.SpringBoot.service.service.Emp;

import java.util.List;

import com.champit.intra.vo.Emp;


public interface EmpService {

	List<Emp> getEmpList();
    List<Emp> getMaxEmpNo();
    Emp getEmpInfo(String empNo);
    int updateEmp(Emp emp);

}
