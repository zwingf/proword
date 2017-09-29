/**
 * 
 */
package com.proword.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author houkai
 *
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {
	
	/**
	 * 在这里校验用户是否登录
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//获取url地址  
        String reqUrl=request.getRequestURI().replace(request.getContextPath(), "");  
        
        //当url地址为登录的url的时候跳过拦截器  
        if(reqUrl.contains("/admin/toLogin") || reqUrl.contains("/admin/login")){
        	return true;
        }else{  
            HttpSession session=request.getSession(); 
            Object obj = session.getAttribute(session.getId());  
            if(obj == null || "".equals(obj.toString())){  
    			response.sendRedirect("/proword-web/admin/toLogin");
    			return false;  
            } else{
            	return true;
            } 
        }
	}


	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
