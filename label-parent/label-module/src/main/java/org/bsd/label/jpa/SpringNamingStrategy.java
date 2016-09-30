package org.bsd.label.jpa;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class SpringNamingStrategy extends ImprovedNamingStrategy{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7989896213357926992L;
	
	@Override
	public String foreignKeyColumnName(String propertyName,
			String propertyEntityName, String propertyTableName,
			String referencedColumnName) {
		
		String name = propertyEntityName;
		if(propertyTableName != null)
			name = StringUtils.unqualify(propertyName);
		
		Assert.state(StringUtils.hasLength(name),"Unable to generate foreignKeyColumnName");
		
		return columnName(name) + "_" + referencedColumnName;
	}

}
