package cn.appsys.controller.develop;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.appcategory.AppCategoryService;
import cn.appsys.service.appinfo.AppinfoService;
import cn.appsys.service.datadictionary.DataDictionaryService;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;


@Controller
@RequestMapping(value="/dev/flatform")
public class AppInfoController {
	@Resource
	private AppinfoService appinfoService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	
	private Logger logger=Logger.getLogger(AppInfoController.class);
	
	//进入信息维护首页，查询app信息列表
	@RequestMapping(value="/appList")
	public String appList(Model model,HttpSession session,
							@RequestParam(value="querySoftwareName",required=false) String _querySoftwareName,
							@RequestParam(value="queryStatus",required=false) String _queryStatus,
							@RequestParam(value="queryCategoryLevel1",required=false) String _queryCategoryLevel1,
							@RequestParam(value="queryCategoryLevel2",required=false) String _queryCategoryLevel2,
							@RequestParam(value="queryCategoryLevel3",required=false) String _queryCategoryLevel3,
							@RequestParam(value="queryFlatformId",required=false) String _queryFlatformId,
							@RequestParam(value="pageIndex",required=false) String _pageIndex ){
		Integer devId=((DevUser)session.getAttribute(Constants.DEVUSER_SESSION)).getId();
		List<AppInfo> appInfoList=null;		//存储appinfo基础信息
		List<DataDictionary> statusList=null;	//存储app状态信息
		List<DataDictionary> flatFormList=null;	//存储app所属平台信息
		//三级分类下拉框取值	ajax实现，选择下拉列表时获取
		List<AppCategory> categorieLevel1List=null;
		List<AppCategory> categorieLevel2List=null;
		List<AppCategory> categorieLevel3List=null;
		//页面容量
		int pageSize=Constants.pageSize;
		//定义当前页码
		Integer currentPageNo=1;
		if (_pageIndex!=null) {//前台传入的页码
			try {
				currentPageNo=Integer.valueOf(_pageIndex);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//前台传入的值为字符串，在这里进行转换
		Integer queryStatus=null;
		if (_queryStatus!=null && !("").equals(_queryStatus)) {
			 queryStatus=Integer.parseInt(_queryStatus);
		}
		Integer queryCategoryLevel1=null;
		if (_queryCategoryLevel1!=null && !("").equals(_queryCategoryLevel1)) {
			queryCategoryLevel1=Integer.parseInt(_queryCategoryLevel1);
		}
		Integer queryCategoryLevel2=null;
		if (_queryCategoryLevel2!=null && !("").equals(_queryCategoryLevel2)) {
			queryCategoryLevel2=Integer.parseInt(_queryCategoryLevel2);
		}
		Integer queryCategoryLevel3=null;
		if (_queryCategoryLevel3!=null && !("").equals(_queryCategoryLevel3)) {
			queryCategoryLevel3=Integer.parseInt(_queryCategoryLevel3);
		}
		Integer queryFlatformId=null;
		if (_queryFlatformId!=null && !("").equals(_queryFlatformId)) {
			queryFlatformId=Integer.parseInt(_queryFlatformId);
		}
		
		//查询列表的总数量
		Integer totalCount=0;
		try {
			totalCount=appinfoService.getAppInfoCount(_querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//总页数
		PageSupport pages=new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount=pages.getTotalPageCount(); 
		//控制首页和尾页
		if (currentPageNo<1) {//当前页码小于1
			currentPageNo=1;
		}else if(currentPageNo>totalPageCount){//当前页码大于总页数
			currentPageNo=totalPageCount;
		}
		try {
			appInfoList=appinfoService.getAppInfoList(_querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
			for (AppInfo appinfo : appInfoList) {
				logger.debug("所属平台：============>"+appinfo.getFlatformName());
			}
			statusList=this.getDataDictionaryList("APP_STATUS");
			flatFormList=this.getDataDictionaryList("APP_FLATFORM");
			categorieLevel1List=appCategoryService.getAppCategoryListByParentId(null);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("appInfoList",appInfoList);
		model.addAttribute("statusList",statusList);
		model.addAttribute("flatFormList",flatFormList);
		model.addAttribute("categorieLevel1List",categorieLevel1List);
		model.addAttribute("pages",pages);
		model.addAttribute("queryStatus",queryStatus);
		model.addAttribute("_querySoftwareName",_querySoftwareName);
		model.addAttribute("queryCategoryLevel1",queryCategoryLevel1);
		model.addAttribute("queryCategoryLevel2",queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3",queryCategoryLevel3);
		model.addAttribute("queryFlatformId",queryFlatformId);
		
		return "developer/appinfolist";
	}
	
	//根据类型编号查询对应数据字典
	public List<DataDictionary> getDataDictionaryList(String Code){
		List<DataDictionary> dataDictionariesList=null;
		try {
			dataDictionariesList=dataDictionaryService.getDataDictionaryList(Code);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dataDictionariesList;	
	}
	//根据根据上一级的级别分类，查询下一级的级别分类
	public List<AppCategory> getAppCategoryList(String pid){
		List<AppCategory> appCategoryList=null;
		try {
			appCategoryList=appCategoryService.getAppCategoryListByParentId(pid==null?null:Integer.parseInt(pid));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return appCategoryList;
	}
	
	
}
