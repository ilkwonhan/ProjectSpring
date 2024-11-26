package com.champit.intra.SpringBoot.service.service.Project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

import java.util.List;

import com.champit.intra.SpringBoot.service.dao.Project.ProjectDao;
import com.champit.intra.vo.Project;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private final ProjectDao projectDao;
	
	@Override
	public List<Project> getProjectList() {
		return projectDao.getProjectList();
	}
	
	


}
