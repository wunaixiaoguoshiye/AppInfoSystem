package cn.appsys.service.appinfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;

@Service
public class AppInfoServiceImpl implements AppinfoService{
	@Resource
	private AppInfoMapper appInfoMapper;
	
	@Override
	public List<AppInfo> getAppInfoList(String softwareName, Integer status,
			Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3, Integer flatformId, Integer devId,
			Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		currentPageNo = (currentPageNo-1)*pageSize;
		return appInfoMapper.getAppInfoList(softwareName, status, categoryLevel1, categoryLevel2, categoryLevel3, flatformId, devId, currentPageNo, pageSize);
	}

	@Override
	public int getAppInfoCount(String softwareName, Integer status,
			Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3, Integer flatformId, Integer devId) {
		// TODO Auto-generated method stub
		System.out.println(softwareName+" " +status + " " +categoryLevel1+" " + categoryLevel2+ " " + categoryLevel3 + " " + flatformId + " " + devId);
		int num = appInfoMapper.getAppInfoCount(softwareName, status, categoryLevel1, categoryLevel2, categoryLevel3, flatformId, devId);
		System.out.println(num);
		return num;
	}

	@Override
	public AppInfo getAppInfoByApkName(Integer id, String APKName) {
		// TODO Auto-generated method stub
		return appInfoMapper.getAppInfoByApkName(id, APKName);
	}

	@Override
	public int add(AppInfo appInfo) {
		// TODO Auto-generated method stub
		return appInfoMapper.add(appInfo);
	}

}
