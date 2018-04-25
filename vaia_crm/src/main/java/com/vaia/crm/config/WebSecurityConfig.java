package com.vaia.crm.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.vaia.constant.RetMessageEnum;
import com.vaia.crm.controller.vo.BaseVO;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by nicholas.chi on 2018/4/23.
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {
    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

//        addInterceptor.excludePathPatterns("/**");

        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/crm/login");
        // 拦截配置
        addInterceptor.addPathPatterns("/crm/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            HttpSession session = request.getSession();
            if (session.getAttribute(SESSION_KEY) != null){
                return true;
            }

            response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            response.addHeader("Access-Control-Max-Age", "3600");

            BaseVO vo = new BaseVO();
            vo.setRet(RetMessageEnum.SESSION_TIMEOUT);
            response.getWriter().write(JSON.toJSONString(vo));
            return false;
        }
    }

}
