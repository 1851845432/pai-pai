package com.caijiale.paipai.user.Interceptor;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class RequestLogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 记录请求日志 记录请求URL，请求参数
        log.info("Request URL: {}", request.getRequestURL());
        log.info("Request Params: {}", JSONUtil.toJsonStr(request.getParameterMap()));
        return true;
    }
}
