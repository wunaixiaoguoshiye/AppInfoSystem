package cn.appsys.service.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

/**
 * app������Ϣ�ӿ�ʵ��
 * @author Administrator
 *
 */
public interface AppinfoService {
	/**
	 * ��ѯ��Ϣ�б�
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
	 * ��ѯ��Ʒ��¼��
	 */
	public int getAppInfoCount(String softwareName,
								Integer status,
								Integer categoryLevel1,
								Integer categoryLevel2,
								Integer categoryLevel3,
								Integer flatformId,
								Integer devId);
}
