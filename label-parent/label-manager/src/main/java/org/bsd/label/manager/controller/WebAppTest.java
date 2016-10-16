package org.bsd.label.manager.controller;

import org.bsd.label.manager.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("springMvc")
public class WebAppTest extends BaseAbstractController {

	@Autowired
	AppService appService;

	@RequestMapping("test")
	public String test(ModelMap modelMap) {
		appService.save();
		System.out.println("Ö´ÐÐ³É¹¦£¡");
		modelMap.put("contextPath", getROOTPath());
		return "index";
	}

	@RequestMapping("clickTab")
	public ModelAndView clickTab(Integer index,ModelAndView mav) {
		if (index == 0) {
			mav.setViewName("registration/"+Tab.REGISTERMAG.getContext());
			return mav;
		} else if (index == 1) {
			mav.setViewName("label/"+Tab.LABELMAG.getContext());
			return mav;
		} else if (index == 2) {
			mav.setViewName(Tab.PRINT.getContext());
			return mav;
		} else if (index == 3) {
			mav.setViewName(Tab.PRIVACY.getContext());
			return mav;
		} else{
			mav.setViewName("label/"+Tab.LABELMAG.getContext());
			return mav;
		}
	}

	enum Tab {
		SEARCH("search"),REGISTERMAG("registerMag"), LABELMAG("labelMag"), PRINT("print"), PRIVACY("privacy");

		private String context;

		public String getContext() {
			return context;
		}

		public void setContext(String context) {
			this.context = context;
		}

		Tab(String context) {
			this.context = context;
		}
	}

}
