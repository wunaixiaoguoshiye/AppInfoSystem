package cn.appsys.service.devuser;

import cn.appsys.pojo.DevUser;

public interface DevUserService {
	/**
	 * app�������û���½�������û��˺ź�������֤�û��Ƿ����
	 * @param devCode
	 * @param password
	 * @return
	 */
	public DevUser login(String devCode,String password);
	
}
