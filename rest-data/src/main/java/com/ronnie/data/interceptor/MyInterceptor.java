package com.ronnie.data.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/19$ 14:56$
 * @Remark:
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        String requestURL = request.getRequestURL().toString();
        System.out.println(requestURL);
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }
}
