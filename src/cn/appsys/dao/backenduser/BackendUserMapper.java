package cn.appsys.dao.backenduser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

/**
 * ��������Ա�ӿ�
 * @author Administrator
 *
 */
public interface BackendUserMapper {
	/**
	 * ��������Ա��½�������˺������ѯ�Ƿ�����û�
	 */
	public BackendUser loginByCode(@Param("userCode") String userCode);
}
