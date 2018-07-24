package cn.appsys.dao.backenduser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

/**
 * 超级管理员接口
 * @author Administrator
 *
 */
public interface BackendUserMapper {
	/**
	 * 超级管理员登陆，根据账号密码查询是否存在用户
	 */
	public BackendUser loginByCode(@Param("userCode") String userCode);
}
