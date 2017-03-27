package com.pch.study.conf.interceptor;

import com.pch.common.util.HttpUtil;
import com.pch.common.util.StringUtil;
import com.pch.sys.po.Log;
import com.pch.sys.service.LogService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/12
 */
public class LogInterceptor extends HandlerInterceptorAdapter {

    private LogService logService;

    public LogInterceptor(LogService logService) {
        this.logService = logService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getRequestURI().contains(".")) {
            String ctx = request.getContextPath();
            String uri = request.getRequestURI();
            uri = StringUtil.substring(uri, ctx.length());
            String data = HttpUtil.getFormData(request);
            String ip = HttpUtil.getIp(request);
            String agent = request.getHeader("User-Agent");
            Log log = new Log();
            log.setIp(ip);
            log.setUserAgent(agent);
            log.setData(data);
            log.setUrl(uri);
            logService.save(log);
        }
        return super.preHandle(request, response, handler);
    }
}
