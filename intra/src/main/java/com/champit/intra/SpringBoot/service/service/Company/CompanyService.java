package com.champit.intra.SpringBoot.service.service.Company;

import java.util.List;

import com.champit.intra.vo.Company;


public interface CompanyService {

	int updateCompany(Company company);

	List<Company> getSelectCompany();
	String getLoginCompany(String login_id, String login_pw);

	String getImgChk(String originFilename);
    boolean overlappedID(Company company);

    

    

}
