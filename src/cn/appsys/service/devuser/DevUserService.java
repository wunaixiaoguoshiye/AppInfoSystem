package cn.appsys.service.devuser;

import cn.appsys.pojo.DevUser;

public interface DevUserService {
	/**
	 * app开发者用户登陆，根据用户账号和密码验证用户是否存在
	 * @param devCode
	 * @param password
	 * @return
	 */
	public DevUser login(String devCode,String password);
	
}
