package org.bsd.label.domain;

import java.sql.Date;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class User  extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -782005100410575243L;
	/**
	 * 用户登录名称
	 */
	private String loginName;
	/**
	 * 用户密码
	 */
	private String passWord;
	/**
	 * 用户真实姓名
	 */
	private String realName;
	/**
	 * 用户电话
	 */
	private String phoneNum;
	private Date createTime;
	private Date modifyTime;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
}
