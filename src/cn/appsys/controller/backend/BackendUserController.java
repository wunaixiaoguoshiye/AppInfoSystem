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
 * 超级管理员控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/backend")
public class BackendUserController {
	@Resource
	private BackendUserService backendUserService;
	private Logger logger=Logger.getLogger(BackendUserController.class);
	
	//进入超级管理员登陆页面
	@RequestMapping(value="/backLogin")
	public String backLogin(){
		return "backendlogin";
	}
	
	//超级管理员登陆，验证账号密码
	@RequestMapping(value="/doLogin")
	public String doLogin(@RequestParam(value="userCode") String userCode,
							@RequestParam(value="userPassword") String userPassword,
							HttpServletRequest request,
							HttpSession session){
		logger.debug("===================>超级管理员登陆验证中");
		//匹配用户
		BackendUser user=null;
		user=backendUserService.loginByCode(userCode, userPassword);
		if (user!=null) {//登陆成功
			session.setAttribute(Constants.BACKUSER_SESSION, user);//保存用户信息
			//页面跳转
			return "redirect:/backend/flatform/main";
		}else {
			//保留在登陆页面，提示错误下信息
			request.setAttribute("error", "用户名获密码不正确");
			return "backendlogin";
		}
	}
	
	//登陆成功
	@RequestMapping(value="/flatform/main")
	public String login(HttpSession session){
		if (session.getAttribute(Constants.BACKUSER_SESSION)==null) {
			return "redirect:/backend/backLogin";
		}
		return "backend/main";
	}
	
	//用户注销登陆
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.BACKUSER_SESSION);
		return "backendlogin";
	}
	
}
