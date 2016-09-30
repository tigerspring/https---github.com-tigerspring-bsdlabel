package org.bsd.label.manager.service.impl;

import java.util.Date;

import org.bsd.label.domain.App;
import org.bsd.label.manager.service.AppService;
import org.bsd.label.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	AppRepository appRepository;
	
	public void save(){
		App app = new App();
		app.setAppName("标签管理系统");
		app.setAppDesc("测试后台");
		app.setCreateTime(new Date());
		app.setModifyTime(new Date());
		appRepository.save(app);
	}
}
