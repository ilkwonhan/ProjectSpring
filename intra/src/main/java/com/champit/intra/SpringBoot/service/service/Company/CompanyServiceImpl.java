package com.champit.intra.SpringBoot.service.service.Company;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

import com.champit.intra.SpringBoot.service.dao.Company.CompanyDao;
import com.champit.intra.vo.Company;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private final CompanyDao companyDao;
	
	@Override
	public int updateCompany(Company company) {
		return companyDao.updateCompany(company);
	}
	
	public List<Company> getSelectCompany() {
		return companyDao.getSelectCompany();
	};
	
	public String getLoginCompany(String login_id, String login_pw) {
		return companyDao.getLoginCompany(login_id, login_pw);
	};
	
	public String getImgChk(String originFilename) {
		return companyDao.getImgChk(originFilename);
	}
	
	@Override
	public boolean overlappedID(Company company) {
		return companyDao.overlappedID(company);
	}


}
