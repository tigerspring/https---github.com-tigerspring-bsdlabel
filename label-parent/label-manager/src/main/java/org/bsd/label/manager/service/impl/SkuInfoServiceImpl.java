package org.bsd.label.manager.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.poi.ss.usermodel.Workbook;
import org.bsd.label.domain.RegistrationInfo;
import org.bsd.label.domain.SkuInfo;
import org.bsd.label.manager.model.SkuInfoModel;
import org.bsd.label.manager.service.SkuInfoService;
import org.bsd.label.repository.SkuInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class SkuInfoServiceImpl implements SkuInfoService {
	
	@Autowired
	private SkuInfoRepository skuInfoRepository;


	public void delete(Long id) {
		skuInfoRepository.delete(id);
	}


	public File getUploadFile(MultipartFile file) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Workbook getWorkBook(String path) {
		// TODO Auto-generated method stub
		return null;
	}


	public void save(SkuInfo skuInfo) {
		skuInfoRepository.save(skuInfo);
	}


	public void save(List<SkuInfo> SkuInfo) {
		// TODO Auto-generated method stub
		
	}


	public List<SkuInfo> getSkuInfoList() {
		// TODO Auto-generated method stub
		return null;
	}


	public Page<SkuInfo> getSkuInfoPageList(final SkuInfoModel skuInfoModel,Pageable page) {
		return skuInfoRepository.findAll(new Specification<SkuInfo>() {
			public Predicate toPredicate(Root<SkuInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(null != skuInfoModel && !StringUtils.isEmpty(skuInfoModel.getSkuNo())) {
					Predicate p1 = cb.like(root.get("skuNo").as(String.class), "%" + skuInfoModel.getSkuNo() + "%");
					list.add(p1);
                }
				Predicate[] p = new Predicate[list.size()];
				return query.where(list.toArray(p)).getRestriction();
			}
		}, page);
	}


	public SkuInfo findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
