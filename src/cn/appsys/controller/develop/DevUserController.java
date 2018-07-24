package cn.appsys.controller.develop;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.devuser.DevUserService;
import cn.appsys.tools.Constants;


/**
 * app�������û�Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/dev")
public class DevUserController {
	@Resource
	private DevUserService devUserService;
	private Logger logger=Logger.getLogger(DevUserController.class);
	
	//�����½ҳ��
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("==============>�����½ҳ��");
		return "devlogin";
	}
	
	//app�������û���½��֤
	@RequestMapping(value="/dologin")
	public String doLogin(@RequestParam String devCode,
							@RequestParam String devPassword,
							HttpSession session,
							HttpServletRequest request){
		logger.debug("===================>app�����ߵ�½��֤��");
		//ƥ���û�
		DevUser user=null;
		user=devUserService.login(devCode, devPassword);
		if (user!=null) {//��½�ɹ�
			session.setAttribute(Constants.DEVUSER_SESSION, user);//�����û���Ϣ
			//ҳ����ת
			return "redirect:/dev/flatform/main";
		}else {
			//�����ڵ�½ҳ�棬��ʾ��������Ϣ
			request.setAttribute("error", "�û��������벻��ȷ");
			return "devlogin";
		}
	}
	
	//��½�ɹ���
	@RequestMapping(value="/flatform/main")
	public String main(HttpSession session){
		if (session.getAttribute(Constants.DEVUSER_SESSION)==null) {
			return "redirect:/dev/login";
		}else {
			return "developer/main";
		}
	}
	
	//�û�ע������
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.DEVUSER_SESSION);
		return "devlogin";
	}
	
	
}
