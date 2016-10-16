package org.bsd.label.manager.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bsd.label.domain.RegistrationInfo;
import org.bsd.label.manager.service.RegistrationInfoService;
import org.bsd.label.repository.RegistrationInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.StringUtils;

@Service
@Transactional
public class RegistrationInfoServiceImpl implements RegistrationInfoService {
	
	@Autowired
	private RegistrationInfoRepository registrationInfoRepository;
	@Autowired
	@Value(value = "${file.upload.path}")
	private String uploadPath;
	
	public void save(RegistrationInfo registrationInfo) {
		registrationInfoRepository.save(registrationInfo);
	}
	public void save(List<RegistrationInfo> registrationInfo) {
		registrationInfoRepository.save(registrationInfo);
	}

	public List<RegistrationInfo> getRegistrationInfoList() {
		return registrationInfoRepository.findAll();
	}
	public Page<RegistrationInfo> getRegistrationInfoPageList(Pageable page) {
		return registrationInfoRepository.findAll(page);
	}

	public void delete(Long id) {
		registrationInfoRepository.delete(id);
	}

	public RegistrationInfo findOne(Long id) {
		return registrationInfoRepository.findOne(id);
	}
	public File getUploadFile(MultipartFile file) throws IllegalStateException, IOException {
		//�����ϴ�·�� �����Ըĳ������ļ���ȡ·��
		File localFilePath = new File(uploadPath);
		if(!localFilePath.exists()){
			localFilePath.mkdirs();
		}
		File uploadedFile = new File(localFilePath.getAbsolutePath()+File.separator+System.currentTimeMillis()+getSuffix(file.getOriginalFilename()));
		file.transferTo(uploadedFile);
		return uploadedFile;
	}
	private String getSuffix(String file){
		if(!StringUtils.isNullOrEmpty(file)){
			return file.substring(file.lastIndexOf("."),file.length());
		}
		return "";
	}
	public Workbook getWorkBook(String path) {
		Workbook workbook = null;
		InputStream stream = null;
		try {
			stream = new FileInputStream(path);
			if(".xls".equals(getSuffix(path))){
				workbook = new HSSFWorkbook(stream);
				return workbook;
			}else if(".xlsx".equals(getSuffix(path))){
				workbook = new XSSFWorkbook(stream);
				return workbook;
			}else{
				System.out.println("���ϴ�excel�ļ���");
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�����ļ�ʱ���ļ�δ�ҵ�!");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�����ļ�ʱ��IO�쳣!");
			return null;
		}finally{
			if(stream != null){
				try {
					stream.close();
				} catch (IOException e) {
					System.out.println("�ر��ļ���ʱ��IO�쳣!");
				}
			}
		}
	}
	public List<RegistrationInfo> getRegistrationInfoListByResNo(String registrationNo) {
		return registrationInfoRepository.findRegistrationInfoByregistrationNoLike(registrationNo);
	}

}
