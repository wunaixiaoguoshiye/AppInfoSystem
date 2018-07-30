package cn.appsys.dao.devuser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

/**
 * app开发者用户接口
 * @author Administrator
 *
 */
public interface DevUserMapper {
	/**
	 * APP开发者用户登录，根据用户编号查询是否存在用户
	 * @return
	 */
	public DevUser getLoginUser(@Param("devCode") String devCode );
}
