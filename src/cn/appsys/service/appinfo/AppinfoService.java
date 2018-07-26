package cn.appsys.service.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

/**
 * app基础信息接口实现
 * @author Administrator
 *
 */
public interface AppinfoService {
	/**
	 * 查询信息列表
	 */
	public List<AppInfo> getAppInfoList(String softwareName,
										Integer status,
										Integer categoryLevel1,
										Integer categoryLevel2,
										Integer categoryLevel3,
										Integer flatformId,
										Integer devId,
										Integer currentPageNo,
										Integer pageSize);
	/**
	 * 查询商品记录数
	 */
	public int getAppInfoCount(String softwareName,
								Integer status,
								Integer categoryLevel1,
								Integer categoryLevel2,
								Integer categoryLevel3,
								Integer flatformId,
								Integer devId);
}
