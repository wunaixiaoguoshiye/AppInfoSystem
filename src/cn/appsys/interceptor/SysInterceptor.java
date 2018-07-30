package cn.appsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.tools.Constants;



/**
 *拦截器，检查用户是否登陆
 * @author asusa
 *
 */
public class SysInterceptor extends HandlerInterceptorAdapter{
	private Logger logger=Logger.getLogger(SysInterceptor.class);
	public boolean preHandle(HttpServletRequest request,
								HttpServletResponse response,
								Object handler) throws Exception{
		logger.debug("SysInterceptor preHandle!");
		HttpSession session=request.getSession();
		DevUser user=(DevUser) session.getAttribute(Constants.DEVUSER_SESSION);
		BackendUser Backuser=(BackendUser) session.getAttribute(Constants.BACKUSER_SESSION);
		if(null != user){ //dev SUCCESS
			return true;
		}else if(null != Backuser){ //backend SUCCESS
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/403.jsp");
			return false;
		}
	}
}
