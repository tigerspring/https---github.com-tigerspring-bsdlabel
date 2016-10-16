package org.bsd.label.manager.controller;

import java.util.List;

import org.bsd.label.domain.User;
import org.bsd.label.manager.model.UserModel;
import org.bsd.label.manager.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends BaseAbstractController{

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("login")
	public String login(UserModel userModel){
		List<User> users = loginService.findUserByUserNameAndPwd(userModel.getLoginName(),userModel.getPassWord());
		if(users.size() > 0){
			setSession("logUser", userModel);
			return "index";
		}else{
			return "login";
		}
		
	}
	@RequestMapping("logout")
	public String logout(){
		removeSession("logUser");
		return "login";
	}
}
