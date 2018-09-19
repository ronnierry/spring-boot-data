package com.ronnie.data.config;

import com.ronnie.data.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/19$ 14:57$
 * @Remark:
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    /**
     * 对于rest -api 没有效果
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }

    /**
     * 所有生效
     * @return
     */
    @Bean
    public MappedInterceptor myMappedInterceptor() {
        return new MappedInterceptor(new String[]{"/**"}, new MyInterceptor());
    }
}
