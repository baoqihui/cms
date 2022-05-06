package com.hbq.cms.filter;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@AllArgsConstructor
public class FilterConfig {
    private UserInterceptor userInterceptor;

    /**
     * 拦截器
     * */
    @Bean
    public WebMvcConfigurer WebMvcConfigurer() {
        return new WebMvcConfigurer() {
            public void addInterceptors(InterceptorRegistry registry) {
                //排除无需拦截路径
                List<String> excludeList=new ArrayList<>();
                excludeList.add("/user/register");
                excludeList.add("/user/login");
                excludeList.add("/file/upload");
                excludeList.add("/file/list/**");
                excludeList.add("/major/list");
                excludeList.add("/trains/list");
                //配置需要拦截路径/*
                registry.addInterceptor(userInterceptor)
                        .addPathPatterns("/file/**")
                        .addPathPatterns("/user/**")
                        .addPathPatterns("/banner/**")
                        .addPathPatterns("/major/**")
                        .addPathPatterns("/trains/**")
                        .addPathPatterns("/userTrains/**")
                        .excludePathPatterns(excludeList);
            }
        };
    }
}
