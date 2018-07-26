package cn.appsys.dao.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

/**
 * app������Ϣ�ӿ�
 * @author Administrator
 *
 */
public interface AppInfoMapper {
	/**
	 * ��ѯ��Ϣ�б�
	 */
	public List<AppInfo> getAppInfoList(@Param("softwareName")String softwareName,
										@Param("status")Integer status,
										@Param("categoryLevel1")Integer categoryLevel1,
										@Param("categoryLevel2")Integer categoryLevel2,
										@Param("categoryLevel3")Integer categoryLevel3,
										@Param("flatformId")Integer flatformId,
										@Param("devId")Integer devId,
										@Param("currentPageNo")Integer currentPageNo,
										@Param("pageSize")Integer pageSize);
	/**
	 * ��ѯ��Ʒ��¼��
	 */
	public int getAppInfoCount(@Param("softwareName")String softwareName,
								@Param("status")Integer status,
								@Param("categoryLevel1")Integer categoryLevel1,
								@Param("categoryLevel2")Integer categoryLevel2,
								@Param("categoryLevel3")Integer categoryLevel3,
								@Param("flatformId")Integer flatformId,
								@Param("devId")Integer devId);
	
	
}
