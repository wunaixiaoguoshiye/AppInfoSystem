package cn.appsys.dao.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

/**
 * app基础信息接口
 * @author Administrator
 *
 */
public interface AppInfoMapper {
	/**
	 * 查询信息列表
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
	 * 查询商品记录数
	 */
	public int getAppInfoCount(@Param("softwareName")String softwareName,
								@Param("status")Integer status,
								@Param("categoryLevel1")Integer categoryLevel1,
								@Param("categoryLevel2")Integer categoryLevel2,
								@Param("categoryLevel3")Integer categoryLevel3,
								@Param("flatformId")Integer flatformId,
								@Param("devId")Integer devId);
	public AppInfo getAppInfo(@Param(value="id")Integer id,@Param(value="APKName")String APKName)throws Exception;

	/**
	 * 查询apkName查询是否有重名
	 */
	public AppInfo getAppInfoByApkName(@Param("id")Integer id,@Param("APKName")String APKName);
	/**
	 * 根据appId，更新最新versionId
	 * @param versionId
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public int updateVersionId(@Param(value="versionId")Integer versionId,@Param(value="id")Integer appId)throws Exception;
	
	/**
	 * 新增app信息
	 */
	public int add(AppInfo appInfo);
	/**
	更新app状态
	*/
	public int updateSatus(@Param(value="status")Integer status,@Param(value="id")Integer id)throws Exception;
	
	
	
	
}
