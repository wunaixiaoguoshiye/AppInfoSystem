package cn.appsys.dao.devuser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

/**
 * app�������û��ӿ�
 * @author Administrator
 *
 */
public interface DevUserMapper {
	/**
	 * APP�������û���¼�������û���Ų�ѯ�Ƿ�����û�
	 * @return
	 */
	public DevUser getLoginUser(@Param("devCode") String devCode );
}
