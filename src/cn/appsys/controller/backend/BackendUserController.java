package cn.appsys.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.backenduser.BackendUserService;
import cn.appsys.tools.Constants;

/**
 * ��������Ա������
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/backend")
public class BackendUserController {
	@Resource
	private BackendUserService backendUserService;
	private Logger logger=Logger.getLogger(BackendUserController.class);
	
	//���볬������Ա��½ҳ��
	@RequestMapping(value="/backLogin")
	public String backLogin(){
		return "backendlogin";
	}
	
	//��������Ա��½����֤�˺�����
	@RequestMapping(value="/doLogin")
	public String doLogin(@RequestParam(value="userCode") String userCode,
							@RequestParam(value="userPassword") String userPassword,
							HttpServletRequest request,
							HttpSession session){
		logger.debug("===================>��������Ա��½��֤��");
		//ƥ���û�
		BackendUser user=null;
		user=backendUserService.loginByCode(userCode, userPassword);
		if (user!=null) {//��½�ɹ�
			session.setAttribute(Constants.BACKUSER_SESSION, user);//�����û���Ϣ
			//ҳ����ת
			return "redirect:/backend/flatform/main";
		}else {
			//�����ڵ�½ҳ�棬��ʾ��������Ϣ
			request.setAttribute("error", "�û��������벻��ȷ");
			return "backendlogin";
		}
	}
	
	//��½�ɹ�
	@RequestMapping(value="/flatform/main")
	public String login(HttpSession session){
		if (session.getAttribute(Constants.BACKUSER_SESSION)==null) {
			return "redirect:/backend/backLogin";
		}
		return "backend/main";
	}
	
	//�û�ע����½
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.BACKUSER_SESSION);
		return "backendlogin";
	}
	
}
