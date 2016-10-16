package org.bsd.label.manager.service;

import java.util.List;

import org.bsd.label.domain.User;

public interface LoginService {

	public List<User> findUserByUserNameAndPwd(String userName,String passWord);
}
