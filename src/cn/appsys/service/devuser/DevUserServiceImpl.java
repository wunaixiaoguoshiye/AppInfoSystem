package cn.appsys.service.devuser;

import javax.annotation.Resource;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.stereotype.Service;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;

@Service
public class DevUserServiceImpl implements DevUserService{

	@Resource
	private DevUserMapper devUserMapper;
	
	@Override
	public DevUser login(String devCode, String password) {
		// TODO Auto-generated method stub
		DevUser devUser=null;
		devUser=devUserMapper.getLoginUser(devCode);
		if (devUser!=null) {
			//�����ѯ���������û���������벻��ͬ
			if (!devUser.getDevPassword().equals(password)) {
				devUser=null;
			}
		}
		return devUser;
	}
	
	
}
