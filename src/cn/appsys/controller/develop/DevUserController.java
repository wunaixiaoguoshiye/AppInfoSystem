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
 * app开发者用户Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/dev")
public class DevUserController {
	@Resource
	private DevUserService devUserService;
	private Logger logger=Logger.getLogger(DevUserController.class);
	
	//进入登陆页面
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("==============>进入登陆页面");
		return "devlogin";
	}
	
	//app开发者用户登陆验证
	@RequestMapping(value="/dologin")
	public String doLogin(@RequestParam String devCode,
							@RequestParam String devPassword,
							HttpSession session,
							HttpServletRequest request){
		logger.debug("===================>app开发者登陆验证中");
		//匹配用户
		DevUser user=null;
		user=devUserService.login(devCode, devPassword);
		if (user!=null) {//登陆成功
			session.setAttribute(Constants.DEVUSER_SESSION, user);//保存用户信息
			//页面跳转
			return "redirect:/dev/flatform/main";
		}else {
			//保留在登陆页面，提示错误下信息
			request.setAttribute("error", "用户名获密码不正确");
			return "devlogin";
		}
	}
	
	//登陆成功后
	@RequestMapping(value="/flatform/main")
	public String main(HttpSession session){
		if (session.getAttribute(Constants.DEVUSER_SESSION)==null) {
			return "redirect:/dev/login";
		}else {
			return "developer/main";
		}
	}
	
	//用户注销方法
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.DEVUSER_SESSION);
		return "devlogin";
	}
	
	
}
