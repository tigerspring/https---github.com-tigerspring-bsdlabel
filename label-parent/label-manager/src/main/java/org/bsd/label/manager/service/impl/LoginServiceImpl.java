package org.bsd.label.manager.service.impl;

import java.util.List;

import org.bsd.label.domain.User;
import org.bsd.label.manager.service.LoginService;
import org.bsd.label.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findUserByUserNameAndPwd(String userName,String passWord){
		return userRepository.findByLoginNameAndPassWord(userName, passWord);
	}
}
