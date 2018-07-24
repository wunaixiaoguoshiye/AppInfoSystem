package cn.appsys.service.backenduser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backenduser.BackendUserMapper;
import cn.appsys.pojo.BackendUser;

@Service
public class BackendUserServiceImpl implements BackendUserService{
	@Resource
	private BackendUserMapper backendUserMapper;

	@Override
	public BackendUser loginByCode(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		BackendUser user=null;
		user=backendUserMapper.loginByCode(userCode);
		if (user!=null) {//�ɹ�
			if (!user.getUserPassword().equals(userPassword)) {//���벻һ��
				user=null;
			}
		}
		return user;
	}
		
}
