package org.bsd.label.manager.controller;

import org.bsd.label.manager.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("springMvc")
public class WebAppTest {
	
	@Autowired
	AppService appService;

	@RequestMapping("test")
	public String test(){
		appService.save();
		System.out.println("Ö´ÐÐ³É¹¦£¡");
		return "index";
	}
}
