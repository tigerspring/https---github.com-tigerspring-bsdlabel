package org.bsd.label.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseAbstractController{
	
	public final static Integer DEFAULT_PAGE_SIZE = 10;

	@Autowired 
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	
	/**
	 * 获取session的属性
	 * @param key
	 * @return
	 */
	protected Object getSession(String key) {
		return request.getSession().getAttribute(key);
	}
	
	
	/**
	 * 设置session属性
	 * @param key
	 * @param value
	 */
	protected void setSession(String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
	/**
	 * 删除session属性
	 * @param key
	 */
	protected void removeSession(String key) {
		request.getSession().removeAttribute(key);
	}

	/**
	 * 系统获取资源根路径
	 * @return
	 */
	protected String getROOTPath() {
		String path = request.getContextPath();  
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
		return basePath;
	}

}
