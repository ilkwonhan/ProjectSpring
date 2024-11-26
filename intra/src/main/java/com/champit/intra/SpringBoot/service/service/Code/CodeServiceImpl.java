package com.champit.intra.SpringBoot.service.service.Code;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import java.util.List;

import com.champit.intra.SpringBoot.service.dao.Code.CodeDao;
import com.champit.intra.vo.Code;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {

    @Autowired
    private final CodeDao codeDao;
	
	@Override
	public List<Code> getCodeList() {
		return codeDao.getCodeList();
	}
	


}
