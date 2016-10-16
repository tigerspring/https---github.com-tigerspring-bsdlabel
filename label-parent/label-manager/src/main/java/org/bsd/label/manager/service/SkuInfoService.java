package org.bsd.label.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.bsd.label.domain.SkuInfo;
import org.bsd.label.manager.model.SkuInfoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface SkuInfoService {

public void save(SkuInfo SkuInfo);
	
	public void save(List<SkuInfo> SkuInfo);
	
	public List<SkuInfo> getSkuInfoList();
	
	public Page<SkuInfo> getSkuInfoPageList(SkuInfoModel skuInfoModel,Pageable page);
	
	public void delete(Long id);
	
	public SkuInfo findOne(Long id);
	
	File getUploadFile(MultipartFile file)  throws IllegalStateException, IOException ;
	
	Workbook getWorkBook(String path);
}
