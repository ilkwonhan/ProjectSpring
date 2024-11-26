package com.champit.intra.SpringBoot.service.service.Emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.List;

import com.champit.intra.SpringBoot.service.dao.Emp.EmpDao;
import com.champit.intra.vo.Emp;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

    @Autowired
    private final EmpDao empDao;
	
	@Override
	public List<Emp> getEmpList() {
		return empDao.getEmpList();
	}
	

	@Override
    public List<Emp> getMaxEmpNo() {
		return empDao.getMaxEmpNo();
	}
	
	@Override
	public Emp getEmpInfo(String empNo){
		return empDao.getEmpInfo(empNo);
	}
	
	@Override
	public int updateEmp(Emp emp) {
		return empDao.updateEmp(emp);
	}
}
