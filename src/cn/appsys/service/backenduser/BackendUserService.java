package cn.appsys.service.backenduser;

import cn.appsys.pojo.BackendUser;

/**
 * ��������Աʵ�ֽӿ�
 * @author Administrator
 *
 */
public interface BackendUserService {
	/**
	 *��������Ա��½��֤�����ݳ�������Ա�û������ѯ�Ƿ����
	 */
	public BackendUser loginByCode(String userCode,String userPassword);
	
	
}
