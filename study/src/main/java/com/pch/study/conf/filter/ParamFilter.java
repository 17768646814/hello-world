package com.pch.study.conf.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/12
 */
public class ParamFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (!parameterMap.isEmpty()) {
            System.out.println("print request paramters ======================================================================");
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                System.out.println(entry.getKey() + " => " + Arrays.toString(entry.getValue()));
            }
            System.out.println("======================================================================");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
