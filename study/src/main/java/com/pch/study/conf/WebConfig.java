package com.pch.study.conf;

import com.pch.study.conf.filter.ParamFilter;
import com.pch.study.conf.interceptor.LogInterceptor;
import com.pch.sys.service.LogService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/12
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private LogService logService;

    @Bean
    public FilterRegistrationBean paramFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new ParamFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/**"));
        HttpServletRequest request;
        return filterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor(logService)).addPathPatterns("/**");
    }

}
