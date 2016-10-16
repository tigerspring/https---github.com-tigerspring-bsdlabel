package org.bsd.label.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * 这册证实体
 * @author jxf
 *
 */
@Entity
public class RegistrationInfo  extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7147543668635370480L;
	
	/**
	 * 注册证号
	 */
	@Column(nullable=false)
	private String registrationNo;
	/**
	 * 有效日期
	 */
	@Column(nullable=false)
	private Date effectiveDate;
	/**
	 * 失效日期
	 */
	@Column(nullable=false)
	private Date expiryDate;
	
	//skuInfos表是关系的维护者，owner side，有主导权，它有个外键指向SkuInfo表。
	@ManyToMany(fetch=FetchType.LAZY)
	private Set<SkuInfo> skuInfos;
	
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Set<SkuInfo> getSkuInfos() {
		return skuInfos;
	}
	public void setSkuInfos(Set<SkuInfo> skuInfos) {
		this.skuInfos = skuInfos;
	}
	
	

}
