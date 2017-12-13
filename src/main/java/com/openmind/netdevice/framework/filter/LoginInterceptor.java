package com.openmind.netdevice.framework.filter;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/8/31
 */
public class LoginInterceptor implements HandlerInterceptor {

    static Logger logger = Logger.getLogger(LoginInterceptor.class);
    private List<String> excludeMappingUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        //后缀  .css html json js......
        String postFix;
        //拦截非空
        if (!StringUtils.isEmpty(requestURI)) {
            int index = requestURI.lastIndexOf(".");
            if (index > -1) {
                postFix = requestURI.substring(index);
                //如果是静态文件直接放行
                if (!StringUtils.isEmpty(postFix) && excludeMappingUrl.contains(postFix))
                    return true;

            }//如果是非login界面
            if (!requestURI.contains("/login")) {
                HttpSession session = request.getSession();
                String username = (String) session.getAttribute("userToken");
                String path = request.getContextPath();
                String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
                if (username == null) {
                    //TODO 这里先设置一个 反向逻辑 方便debug
//                    response.getOutputStream().write("false123".getBytes());
//                    response.sendRedirect("login.jsp");
                    return true;
                } else {
                    return true;
                }

            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object
            handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object
            handler, Exception ex) throws Exception {

    }


    public void setExcludeMappingUrl(List<String> excludeMappingUrl) {
        this.excludeMappingUrl = excludeMappingUrl;
    }
}
