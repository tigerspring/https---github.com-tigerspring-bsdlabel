package org.bsd.label.manager.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.bsd.label.domain.RegistrationInfo;
import org.bsd.label.manager.controller.WebAppTest.Tab;
import org.bsd.label.manager.model.RegistrationInfoModel;
import org.bsd.label.manager.service.RegistrationInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("registrationinfo")
public class RegistrationInfoController extends BaseAbstractController {
	
	@Autowired
	private RegistrationInfoService registrationInfoService;

	@RequestMapping("list")
	public String list(@RequestParam(name="currentPage",defaultValue="0",required=false) Integer currentPage, ModelMap modelMap){
		Pageable page = new PageRequest(currentPage, DEFAULT_PAGE_SIZE, new Sort(Direction.ASC,"id"));
		Page<RegistrationInfo> registrationInfos = registrationInfoService.getRegistrationInfoPageList(page);
		modelMap.addAttribute("pages", registrationInfos);
		modelMap.addAttribute("pageSize", DEFAULT_PAGE_SIZE);
		modelMap.addAttribute("currentPage", currentPage);
		return "registration/registrationTable";
	}
	@RequestMapping("addregistration")
	public String addregistration(Long id,Integer currentPage,ModelMap modelMap){
		id = id == null?-1:id;
		RegistrationInfo registrationInfo = registrationInfoService.findOne(id);
		modelMap.addAttribute("registrationInfo", registrationInfo);
		modelMap.addAttribute("currentPage", currentPage);
		return "registration/addregistration";
	}
	@RequestMapping("save")
	public String save(Integer currentPage,RegistrationInfoModel registrationInfoModel) throws ParseException{
		RegistrationInfo registrationInfo = new RegistrationInfo();
		BeanUtils.copyProperties(registrationInfoModel, registrationInfo,"EffectiveDate","ExpiryDate");
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");

		Date effectiveDate = fmt.parse(registrationInfoModel.getEffectiveDate());
		Date expiryDate = fmt.parse(registrationInfoModel.getExpiryDate());
		registrationInfo.setEffectiveDate(effectiveDate);
		registrationInfo.setExpiryDate(expiryDate);
		registrationInfoService.save(registrationInfo);
		return "forward:/registrationinfo/list?currentPage="+currentPage;
	}
	@RequestMapping("modify")
	public String modify(Long id,Integer currentPage,RegistrationInfoModel registrationInfoModel) throws ParseException{
		RegistrationInfo registrationInfo = registrationInfoService.findOne(id);
		BeanUtils.copyProperties(registrationInfoModel, registrationInfo,"EffectiveDate","ExpiryDate");
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");

		Date effectiveDate = fmt.parse(registrationInfoModel.getEffectiveDate());
		Date expiryDate = fmt.parse(registrationInfoModel.getExpiryDate());
		registrationInfo.setEffectiveDate(effectiveDate);
		registrationInfo.setExpiryDate(expiryDate);
		registrationInfoService.save(registrationInfo);
		return "forward:/registrationinfo/list?currentPage="+currentPage;
	}
	@RequestMapping("delete")
	public String delete(Long id,Integer currentPage){
		registrationInfoService.delete(id);
		return "forward:/registrationinfo/list?currentPage="+currentPage;
	}
	@PostMapping("importData")
	public String importData(@RequestParam(name="file", required=false)MultipartFile  file,Integer currentPage) throws IllegalStateException, IOException, ParseException{
		File uploadFile = registrationInfoService.getUploadFile(file);
		Workbook workbook = registrationInfoService.getWorkBook(uploadFile.getAbsolutePath());
		Sheet sheet =  workbook.getSheetAt(0);
		// 获得总行数
		int rowNum = sheet.getPhysicalNumberOfRows();
		List<RegistrationInfo> registrationInfoList = new ArrayList<RegistrationInfo>();
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 1; i < rowNum; i++) {
			RegistrationInfo registrationInfo = new RegistrationInfo();
			//注册证编号
			sheet.getRow(i).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
			String registrationNo = sheet.getRow(i).getCell(0).getStringCellValue().trim();

			//起始日期
			sheet.getRow(i).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
			String effectiveDateStr = sheet.getRow(i).getCell(1).getStringCellValue().trim();
			//起始日期
			sheet.getRow(i).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
			String expiryDateStr = sheet.getRow(i).getCell(1).getStringCellValue().trim();
			
			Date effectiveDate = fmt.parse(effectiveDateStr);
			Date expiryDate = fmt.parse(expiryDateStr);
			registrationInfo.setRegistrationNo(registrationNo);
			registrationInfo.setEffectiveDate(effectiveDate);
			registrationInfo.setExpiryDate(expiryDate);
			registrationInfoList.add(registrationInfo);
		}
		registrationInfoService.save(registrationInfoList);
		return "forward:/registrationinfo/list";
	}
	@RequestMapping("registrationInfoList")
	public ModelAndView RegistrationInfoList(ModelAndView mav){
		mav.setViewName("registration/registerMag");
		return mav;
//		return "registration/registerMag";
	}
}
