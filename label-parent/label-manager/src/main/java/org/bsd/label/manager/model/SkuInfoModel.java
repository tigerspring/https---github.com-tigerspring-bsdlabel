package org.bsd.label.manager.model;

public class SkuInfoModel {
	/**
	 * 产品编号
	 */
	private String skuNo;
	/**
	 * 产品名称
	 */
	private String proName;
	/**
	 * 产品规格
	 */
	private String specifications;
	/**
	 * 生产厂商
	 */
	private String manufacturer;
	/**
	 * 代理人
	 */
	private String agent;
	/**
	 * 生产日期
	 */
	private String productDate;
	public String getSkuNo() {
		return skuNo;
	}
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	
}
