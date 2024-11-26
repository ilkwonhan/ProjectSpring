package com.champit.intra.SpringBoot.service.dao.Company;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.champit.intra.vo.Company;

@Mapper
public interface CompanyDao {

    public int updateCompany(Company company);
    
	public List<Company> getSelectCompany();
	public String getLoginCompany(String login_id, String login_pw);
    
	String getImgChk(String originFilename);
    public boolean overlappedID(Company company);
}
