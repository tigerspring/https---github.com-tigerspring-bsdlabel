package org.bsd.label.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.bsd.label.domain.RegistrationInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface RegistrationInfoService {

	public void save(RegistrationInfo registrationInfo);
	
	public void save(List<RegistrationInfo> registrationInfo);
	
	public List<RegistrationInfo> getRegistrationInfoList();
	
	public Page<RegistrationInfo> getRegistrationInfoPageList(Pageable page);
	
	public void delete(Long id);
	
	public RegistrationInfo findOne(Long id);
	
	File getUploadFile(MultipartFile file)  throws IllegalStateException, IOException ;
	
	Workbook getWorkBook(String path);
	
	public List<RegistrationInfo> getRegistrationInfoListByResNo(String registrationNo);
}
