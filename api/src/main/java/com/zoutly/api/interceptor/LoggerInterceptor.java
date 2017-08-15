package com.zoutly.api.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        StringBuilder sb = new StringBuilder();

        sb.append("Requested=");
        sb.append(request.getMethod());
        sb.append(" ");
        if(request.getQueryString() != null) {
            sb.append(request.getRequestURL().append("?").append(request.getQueryString()));
        } else {
            sb.append(request.getRequestURL());
        }

        sb.append(";; user-agent=");
        sb.append(request.getHeader("user-agent"));

        // TODO? by user - another interceptor - Spring Security
        // sb.append(";; By user=");

        sb.append(";; Handler=");
        sb.append(handler.toString());

        logger.info(sb.toString());
        return super.preHandle(request, response, handler);
    }
}
