package com.ldd.flower.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * @Author liudongdong
 * @Date Created in 20:26 2019/9/20
 * @Description
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger= Logger.getLogger("LoginInterceptior");
    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        logger.info(request.getServletPath());
        // 如果获取的request的session中的loginUser参数为空（未登录），就返回登录页，否则放行访问
        if("/receive.html".equals(request.getServletPath()))
        {
            return true;
        }
        if (user == null) {
            logger.info("未登录");
            // 未登录，给出错误信息，
            request.setAttribute("msg","无权限请先登录");
            // 获取request返回页面到登录页
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        } else {
            logger.info("已经登录");
            // 已登录，放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
