package cn.appsys.service.backenduser;

import cn.appsys.pojo.BackendUser;

/**
 * 超级管理员实现接口
 * @author Administrator
 *
 */
public interface BackendUserService {
	/**
	 *超级管理员登陆验证，根据超级管理员用户密码查询是否存在
	 */
	public BackendUser loginByCode(String userCode,String userPassword);
	
	
}
