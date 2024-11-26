package com.champit.intra.SpringBoot.service.service.Career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.champit.intra.SpringBoot.service.dao.Career.CareerDao;
import com.champit.intra.vo.Career;

@Service
@RequiredArgsConstructor
public class CareerServiceImpl implements CareerService {

	
    @Autowired
    private final CareerDao careerDao;
 
	@Override
	public int updateCareer(Career career) {
		return careerDao.updateCareer(career);
	};


}
