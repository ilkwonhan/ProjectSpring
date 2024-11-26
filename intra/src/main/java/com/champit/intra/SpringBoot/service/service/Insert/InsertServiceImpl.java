package com.champit.intra.SpringBoot.service.service.Insert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

import com.champit.intra.SpringBoot.service.dao.Insert.InsertDao;
import com.champit.intra.vo.Career;
import com.champit.intra.vo.Code;
import com.champit.intra.vo.Company;
import com.champit.intra.vo.Emp;

@Service
@RequiredArgsConstructor
public class InsertServiceImpl implements InsertService {

    @Autowired
    private final InsertDao insertDao;
	
	
	@Override
    public int insertEmp(Emp emp) {
		int result = insertDao.insertEmp(emp);
		return result;
	}
	
	@Override
    public int insertCompany(Company company) {
		int result = insertDao.insertCompany(company);
		return result;
	}

	@Override
    public int insertCode(Code code) {
		int result = insertDao.insertCode(code);
		return result;
	}

    @Override
	public int insertCareer(Career career) {
		int result = insertDao.insertCareer(career);
		return result;
	}


}
