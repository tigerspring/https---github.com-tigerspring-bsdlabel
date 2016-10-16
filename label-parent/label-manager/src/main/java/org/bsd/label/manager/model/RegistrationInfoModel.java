package org.bsd.label.manager.model;

public class RegistrationInfoModel {
	/**
	 * 注册证id
	 */
	private Long id;
	/**
	 * 注册证号
	 */
	private String registrationNo;
	/**
	 * 有效日期
	 */
	private String effectiveDate;
	/**
	 * 失效日期
	 */
	private String expiryDate;
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
