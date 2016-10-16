package org.bsd.label.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class SkuInfo  extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2607446454450257255L;
	/**
	 * sku编号
	 */
	@Column(nullable=false)
	private String skuNo;
	/**
	 * 产品名称
	 */
	@Column(nullable=false)
	private String proName;
	/**
	 * 产品规格
	 */
	@Column(nullable=false)
	private String specifications;
	/**
	 * 生产厂商
	 */
	@Column(nullable=false)
	private String manufacturer;
	/**
	 * 代理人
	 */
	@Column(nullable=false)
	private String agent;
	
	//mappedBy="skuInfos"表示skuInfos是双向关系的维护端
	
	@ManyToMany(mappedBy="skuInfos",fetch=FetchType.LAZY)
	private Set<RegistrationInfo> registrationInfos = new HashSet<RegistrationInfo>();
	/**
	 * 生产日期
	 */
	private Date productDate;
	
	
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
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	
}
