package org.bsd.label.manager.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bsd.label.domain.RegistrationInfo;
import org.bsd.label.domain.SkuInfo;
import org.bsd.label.manager.model.RegistrationInfoModel;
import org.bsd.label.manager.model.SkuInfoModel;
import org.bsd.label.manager.service.RegistrationInfoService;
import org.bsd.label.manager.service.SkuInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("skuinfo")
public class SkuInfoController extends BaseAbstractController {

	@Autowired
	private SkuInfoService skuInfoService;
	@Autowired
	private RegistrationInfoService registrationInfoService;

	@RequestMapping("list")
	public String list(@RequestParam(name="currentPage",defaultValue="0") Integer currentPage,SkuInfoModel skuInfoModel, ModelMap modelMap){
		Pageable page = new PageRequest(currentPage, DEFAULT_PAGE_SIZE, new Sort(Direction.ASC,"id"));
		Page<SkuInfo> registrationInfos = skuInfoService.getSkuInfoPageList(skuInfoModel,page);
		modelMap.addAttribute("pages", registrationInfos);
		modelMap.addAttribute("pageSize", DEFAULT_PAGE_SIZE);
		modelMap.addAttribute("currentPage", currentPage);
		return "label/labelTable";
	}
	@RequestMapping("addLabel")
	public String addLabel(Long id,Integer currentPage,ModelMap modelMap){
		id = id == null?-1:id;
		modelMap.addAttribute("currentPage", currentPage);
		return "label/addLabel";
	}
	@RequestMapping("save")
	public String save(@RequestParam(name="currentPage",defaultValue="0") Integer currentPage,SkuInfoModel skuInfoModel) throws ParseException{
		SkuInfo skuInf = new SkuInfo();
		BeanUtils.copyProperties(skuInfoModel, skuInf,"productDate");
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");

		Date proDate = fmt.parse(skuInfoModel.getProductDate());
		skuInf.setProductDate(proDate);
		skuInfoService.save(skuInf);
		return "forward:/skuinfo/list?currentPage="+currentPage;
	}
	/*@RequestMapping("modify")
	public String modify(Long id,Integer currentPage,RegistrationInfoModel registrationInfoModel) throws ParseException{
		RegistrationInfo registrationInfo = skuInfoService.findOne(id);
		BeanUtils.copyProperties(registrationInfoModel, registrationInfo,"EffectiveDate","ExpiryDate");
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");

		Date effectiveDate = fmt.parse(registrationInfoModel.getEffectiveDate());
		Date expiryDate = fmt.parse(registrationInfoModel.getExpiryDate());
		registrationInfo.setEffectiveDate(effectiveDate);
		registrationInfo.setExpiryDate(expiryDate);
		skuInfoService.save(registrationInfo);
		return "forward:/registrationinfo/list?currentPage="+currentPage;
	}*/
	@RequestMapping("delete")
	public String delete(Long id,Integer currentPage){
		skuInfoService.delete(id);
		return "forward:/skuinfo/list?currentPage="+currentPage;
	}
	/*
	@PostMapping("importData")
	public String importData(@RequestParam(name="file", required=false)MultipartFile  file,Integer currentPage) throws IllegalStateException, IOException, ParseException{
		File uploadFile = skuInfoService.getUploadFile(file);
		Workbook workbook = skuInfoService.getWorkBook(uploadFile.getAbsolutePath());
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
		skuInfoService.save(registrationInfoList);
		return "forward:/registrationinfo/list";
	}*/
	
	@RequestMapping("skuinfoManage")
	public ModelAndView registrationInfoList(ModelAndView mav){
		mav.setViewName("label/labelMag");
		return mav;
//		return "registration/registerMag";
	}
	@RequestMapping("loadRegistrationInfo")
	@ResponseBody
	public List<RegistrationInfoModel> loadRegistrationInfo(@RequestParam(name="registrationNo",required=true)String registrationNo){
		System.out.println("registrationNo="+registrationNo);
		List<RegistrationInfo> registrationList = registrationInfoService.getRegistrationInfoListByResNo("%"+registrationNo+"%");
//		StringBuilder sbu = new StringBuilder("");
//		for(RegistrationInfo rinfo : registrationList){
//			sbu.append("{\"id\":\""+rinfo.getId()+"\",\"registrationNo\":\""+registrationNo+"\"},");
//		}
//		String tmpStr = null;
//		if(sbu.length() > 1){
//			tmpStr = sbu.toString().substring(0, sbu.toString().length()-1);
//		}
//		StringBuilder jsonStr = new StringBuilder("[");
//		jsonStr.append(tmpStr+"]");
//		System.out.println(jsonStr.toString());
//		return jsonStr.toString();
		List<RegistrationInfoModel> registrationInfoModelList = new ArrayList<RegistrationInfoModel>();
		for(RegistrationInfo registrationInfo:registrationList){
			RegistrationInfoModel registrationInfoModel = new RegistrationInfoModel();
			registrationInfoModel.setId(registrationInfo.getId());
			registrationInfoModel.setRegistrationNo(registrationInfo.getRegistrationNo());
			registrationInfoModelList.add(registrationInfoModel);
		}
		return registrationInfoModelList;
	}
}
