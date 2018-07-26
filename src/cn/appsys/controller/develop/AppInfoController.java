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
	
	//������Ϣά����ҳ����ѯapp��Ϣ�б�
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
		List<AppInfo> appInfoList=null;		//�洢appinfo������Ϣ
		List<DataDictionary> statusList=null;	//�洢app״̬��Ϣ
		List<DataDictionary> flatFormList=null;	//�洢app����ƽ̨��Ϣ
		//��������������ȡֵ	ajaxʵ�֣�ѡ�������б�ʱ��ȡ
		List<AppCategory> categorieLevel1List=null;
		List<AppCategory> categorieLevel2List=null;
		List<AppCategory> categorieLevel3List=null;
		//ҳ������
		int pageSize=Constants.pageSize;
		//���嵱ǰҳ��
		Integer currentPageNo=1;
		if (_pageIndex!=null) {//ǰ̨�����ҳ��
			try {
				currentPageNo=Integer.valueOf(_pageIndex);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//ǰ̨�����ֵΪ�ַ��������������ת��
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
		
		//��ѯ�б��������
		Integer totalCount=0;
		try {
			totalCount=appinfoService.getAppInfoCount(_querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//��ҳ��
		PageSupport pages=new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount=pages.getTotalPageCount(); 
		//������ҳ��βҳ
		if (currentPageNo<1) {//��ǰҳ��С��1
			currentPageNo=1;
		}else if(currentPageNo>totalPageCount){//��ǰҳ�������ҳ��
			currentPageNo=totalPageCount;
		}
		try {
			appInfoList=appinfoService.getAppInfoList(_querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
			for (AppInfo appinfo : appInfoList) {
				logger.debug("����ƽ̨��============>"+appinfo.getFlatformName());
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
	
	//�������ͱ�Ų�ѯ��Ӧ�����ֵ�
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
	//���ݸ�����һ���ļ�����࣬��ѯ��һ���ļ������
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
