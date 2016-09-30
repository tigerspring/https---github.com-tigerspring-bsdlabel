package org.bsd.label.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("springMvc")
public class WebAppTest {

	@RequestMapping("test")
	public String test(){
		System.out.println("Ö´ÐÐ³É¹¦£¡");
		return "index";
	}
}
